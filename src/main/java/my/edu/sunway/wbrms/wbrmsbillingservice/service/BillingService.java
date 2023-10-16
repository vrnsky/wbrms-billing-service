package my.edu.sunway.wbrms.wbrmsbillingservice.service;

import my.edu.sunway.wbrms.wbrmsbillingservice.config.dto.BillItem;
import my.edu.sunway.wbrms.wbrmsbillingservice.config.dto.BillPayment;
import my.edu.sunway.wbrms.wbrmsbillingservice.config.dto.Tax;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BillingService {

    public BillPayment calculateBill(String table, List<BillItem> items) {
        var subTotal = BigDecimal.ZERO;
        for (BillItem item : items) {
            subTotal = subTotal.add(item.price().multiply(BigDecimal.valueOf(item.count())));
        }

        var taxes = buildDefaultTaxes();

        var finalAmount = new BigDecimal(subTotal.longValue());

        for (Tax tax : taxes) {
            if (tax.percentage() != null && tax.fixedAmount() != null) {
                throw new IllegalArgumentException("Taxes configured incorrectly!");
            }
            if (tax.percentage() == null && tax.fixedAmount() == null) {
                throw new IllegalArgumentException("Taxes configured incorrectly");
            }
            if (tax.percentage() != null) {
                var taxAmount = subTotal.multiply(tax.percentage());
                finalAmount = finalAmount.add(taxAmount);
            }
            if (tax.fixedAmount() != null) {
                finalAmount = finalAmount.add(tax.fixedAmount());
            }
        }

        return new BillPayment(
                table,
                LocalDateTime.now(),
                subTotal,
                taxes,
                new ArrayList<>(),
                finalAmount
        );


    }

    List<Tax> buildDefaultTaxes() {
        return Arrays.asList(
                new Tax("GST", BigDecimal.valueOf(6d / 100d), null),
                new Tax("Service Tax", BigDecimal.valueOf(10d / 100d), null)
        );
    }
}
