package my.edu.sunway.wbrms.wbrmsbillingservice.config.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Entity describing discount and vouchers")
public record Discount(

        @Schema(description = "Description of discount or voucher")
        String description,

        @Schema(description = "Applicable percentage")
        BigDecimal percentage,

        @Schema(description = "Fixed amount of discount")
        BigDecimal fixedAmount
) {
}
