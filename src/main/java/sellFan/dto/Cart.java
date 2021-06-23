package sellFan.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cart {
    private Integer Id;
    private String User_Email;
    private Integer ProductId;
    private Integer Quantity;
}
