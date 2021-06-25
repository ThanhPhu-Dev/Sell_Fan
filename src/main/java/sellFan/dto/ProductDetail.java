/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sellFan.dto;
import java.util.List;
import lombok.Builder;
import lombok.Data;
/**
 *
 * @author NghiaDX
 */
@Data
public class ProductDetail {
    private Integer ProductId;
    private String Type;
    private String Diameter;
    private String WindMode;
    private String DashBoard;
    private String MotorType;
    private String Utility;
    private String SizeWight;
    private String BrandName;
    private String MadeIn;
    private String DebutYear;
    private String Company;
    private String Image;
}
