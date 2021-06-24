package sellFan.dto;

import java.math.BigInteger;
import lombok.Builder;
import lombok.Data;

@Data
public class Bill {
    private Integer Id;
    private Integer User_Id;
    private String Full_Name;
    private String Gender;
    private String Phone_number;
    private String Address;
    private String Requirement;
    private BigInteger Total;
}
