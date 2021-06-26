/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sellFan.dto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author NghiaDX
 */
@Data
public class User {
    private Integer Id;
    private String Email;
    private String HashedPw;
    private String FullName;
    private String code;
    private Integer status;
    private String Address;
    private String Phone;
    private String public_id;
    private String public_url;
}
