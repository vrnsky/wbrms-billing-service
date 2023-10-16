package my.edu.sunway.wbrms.wbrmsbillingservice.config.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Entity describing final bill")
public record BillPayment(

        @Schema(description = "Unique identifier of table")
        String table,

        @Schema(description = "Date and time of bill creation")
        @DateTimeFormat(pattern = "dd/MM/yyyy HH:ss")
        LocalDateTime time,

        @Schema(description = "Total without applying any discounts and vouchers, and taxes")
        BigDecimal subTotal,

        @Schema(description = "Applicable taxes")
        List<Tax> taxes,

        @Schema(description = "Applicable discounts")
        List<Discount> discounts,

        @Schema(description = "The final bill amount")
        BigDecimal finalAmount
) {
}
