package fit.se2.se02_project.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddproductRequest {
    private String productName;
    private String quantity;
    private String price;
    private long productStatusId;
    private String saleprice;
    private long categoryId;
    private MultipartFile image;
    private String description;
}
