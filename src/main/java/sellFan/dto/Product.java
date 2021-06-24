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
public class Product {
    private Integer Id;
    private Integer TypeId;
    private String Name;
    private Integer Price;
    private Integer Stock;
    private String Image;
}
