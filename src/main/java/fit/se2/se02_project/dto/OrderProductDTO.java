package fit.se2.se02_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDTO {
    private String image;
    private String productName;
    private int quantity;
    private BigDecimal price;

}
