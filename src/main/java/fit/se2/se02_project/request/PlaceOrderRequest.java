package fit.se2.se02_project.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderRequest {
    private List<ProductQuantityRequest> productInfor;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private int payment;
    private String note;

}
