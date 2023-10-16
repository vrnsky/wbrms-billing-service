package my.edu.sunway.wbrms.wbrmsbillingservice.config.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.UUID;

@Schema(description = "Entity-request to calculate final bill")
public record BillItem(

        @Schema(description = "Table identifier")
        String table,
        @Schema(description = "Unique identifier of item on menu")
        UUID itemId,

        @Schema(description = "Item's price")
        BigDecimal price,

        @Schema(description = "Number of item chosen")
        int count
) {
}
