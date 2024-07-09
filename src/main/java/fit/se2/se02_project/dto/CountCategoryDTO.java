package fit.se2.se02_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountCategoryDTO {
    private String categoryName;
    private long id;
    private int total;

}
