/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sellFan.dto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 *
 * @author NghiaDX
 */
@Data
public class BillDetail {
    private Integer Id;
    private Integer BillId;
    private Integer ProductId;
    private Integer Quantity;
    private Integer Total;
    private Date Date_Created;

    private Product BillDetailProduct;
}
