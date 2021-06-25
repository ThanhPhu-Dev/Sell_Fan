package sellFan.mapper;

import sellFan.dto.Bill;
import sellFan.dto.BillDetail;
import sellFan.dto.Product;
import sellFan.dto.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillMappper implements RowMappper<Bill>{
    @Override
    public Bill mapRow(ResultSet rs) {
        try {
            Bill bill = new Bill();
            bill.setId(rs.getInt("id"));
            bill.setUser_Id(rs.getInt("user_id"));
            bill.setFull_Name(rs.getString("full_name"));
            bill.setGender(rs.getString("gender"));
            bill.setPhone_number(rs.getString("phone_number"));
            bill.setAddress(rs.getString("address"));
            bill.setTotal(rs.getInt("total"));
            bill.setRequirement(rs.getString("requirement"));
            bill.setDate_Created(rs.getDate("date_created"));

            return bill;
        } catch (SQLException ex) {
            return null;
        }
    }
}
