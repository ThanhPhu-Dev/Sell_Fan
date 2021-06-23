package sellFan.models;

import java.math.BigInteger;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bill {
    private Integer Id;
    private String User_email;
    private String Phone_number;
    private String Address;
    private BigInteger Total;
}
