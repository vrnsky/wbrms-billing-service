package my.edu.sunway.wbrms.wbrmsbillingservice.config.dto;

import java.math.BigDecimal;

public record Tax(
        String description,
        BigDecimal percentage,
        BigDecimal fixedAmount
) {
}
