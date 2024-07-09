package fit.se2.se02_project.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeRequest {
    private String currentPass;
    private String newPass;
    private String confirmNewPass;

}
