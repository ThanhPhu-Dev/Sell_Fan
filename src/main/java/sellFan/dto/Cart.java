package sellFan.dto;

import lombok.Data;

@Data
public class Cart {
    private Integer Id;
    private Integer User_Id;
    private Integer ProductId;
    private Integer Quantity;

    private Product CartProduct;

}
