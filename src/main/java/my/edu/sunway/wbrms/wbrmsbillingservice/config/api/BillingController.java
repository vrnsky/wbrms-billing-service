package my.edu.sunway.wbrms.wbrmsbillingservice.config.api;

import lombok.RequiredArgsConstructor;
import my.edu.sunway.wbrms.wbrmsbillingservice.config.dto.BillItem;
import my.edu.sunway.wbrms.wbrmsbillingservice.config.dto.BillPayment;
import my.edu.sunway.wbrms.wbrmsbillingservice.service.BillingService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/billing")
@RequiredArgsConstructor
public class BillingController {

    private final BillingService billingService;

    @PostMapping("/{tableId}")
    public Mono<BillPayment> calculateBill(@PathVariable(name = "tableId") String tableId, @RequestBody List<BillItem> billItems) {
        return Mono.just(billingService.calculateBill(tableId, billItems));
    }

}
