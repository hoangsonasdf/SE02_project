package fit.se2.se02_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListOrderDTO {
    private long id;
    private List<OrderProductDTO> listProduct;
    private long statusId;
    private String statusName;
    private long userId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;

}
