/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sellFan.models;
import lombok.Builder;
import lombok.Data;
/**
 *
 * @author NghiaDX
 */
@Data
@Builder
public class ProductType {
    private Integer Id;
    private String Name;
}
