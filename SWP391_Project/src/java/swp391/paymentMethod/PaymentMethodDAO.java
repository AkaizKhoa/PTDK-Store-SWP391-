/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.paymentMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import swp391.utils.DBHelper;

/**
 *
 * @author Duy
 */
public class PaymentMethodDAO {
    public String getNameOfMethodByMethodID(int methodID) throws SQLException, NamingException {
        String userName = null;
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.makeConnection();
            String sql = "  SELECT NameOfMethod FROM PaymentMethod WHERE PaymentID = ?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, methodID);
            rs = stm.executeQuery();
            while (rs.next()) {
                userName = rs.getString("NameOfMethod");
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return userName;
    }
}
