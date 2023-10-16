package my.edu.sunway.wbrms.wbrmsbillingservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Definition of tax")
public record Tax(
        @Schema(description = "Description of tax", example = "GST")
        String description,

        @Schema(description = "Percentage of tax", example = "0.06")
        BigDecimal percentage,

        @Schema(description = "Fixed amount of tax", example = "100.00")
        BigDecimal fixedAmount
) {
}
