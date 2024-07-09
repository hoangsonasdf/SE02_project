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
public class ProductDTO {
    private long id;
    private String productName;
    private long categoryId;
    private long statusId;
    private String categoryName;
    private String statusName;
    private BigDecimal price;
    private int quantity;
    private BigDecimal salePrice;
    private String image;
    private String description;

}
