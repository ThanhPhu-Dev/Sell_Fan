/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sellFan.dto;
import lombok.Builder;
import lombok.Data;
/**
 *
 * @author NghiaDX
 */
@Data
@Builder
public class User {
    private String Email;
    private String HashedPw;
    private String FullName;
}