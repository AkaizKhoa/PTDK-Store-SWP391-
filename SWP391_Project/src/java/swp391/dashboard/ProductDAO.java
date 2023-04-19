package swp391.dashboard;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class ProductDAO implements Serializable {

    private List<ProdcutDTO> listdto;

    public List<ProdcutDTO> getListdto() {
        return listdto;
    }

    public void getTop10Products() throws NamingException, SQLException {
//        List<ProdcutDTO> products = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect to the database
            con = DBHelpers.getConnection();
            if (con != null) {
                //2. Define the SQL query to retrieve the top 10 products based on their quantity
                String sql = "SELECT TOP 10 ProductID, SUM(Quantity) AS Quantity "
                        + "FROM [OrdersDetail] "
                        + "GROUP BY ProductID "
                        + "ORDER BY Quantity DESC";
                //3. Create the PreparedStatement
                stm = con.prepareStatement(sql);
                //4. Execute the query and retrieve the results
                rs = stm.executeQuery();
                while (rs.next()) {
                    //5. Retrieve the data from the result set and create a ProductDTO object
                    ProdcutDTO product = new ProdcutDTO();
                    int pro = rs.getInt("ProductID");
                    int quan = rs.getInt("Quantity");
                    //6. Add the product to the list
                    product = new ProdcutDTO(pro, quan);

                    if (this.listdto == null) {
                        this.listdto = new ArrayList<>();
                    }
                    this.listdto.add(product);
                }
            } //end con is available
        } finally {
            //7. Close the database resources
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
    }

    public void getTop10ItemsInMonthYear(String month, String year) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            // 1. Connect to the database
            con = DBHelpers.getConnection();
            if (con != null) {
                // 2. Create SQL query
                String sql = "SELECT TOP 10 ProductID, SUM(Quantity) AS Quantity,ord.OrdersDtID FROM [OrdersDetail] ord  INNER JOIN [Orders] orn ON ord.OrdersID = orn.OrdersID WHERE  MONTH([DateOrders]) = ? AND YEAR([DateOrders]) = ? GROUP BY ProductID, ord.OrdersDtID  ORDER BY Quantity DESC";
                // 3. Create prepared statement
                stm = con.prepareStatement(sql);
                stm.setString(1, month);
                stm.setString(2, year);
                // 4. Execute query
                rs = stm.executeQuery();
                // 5. Process results
                while (rs.next()) {
                    ProdcutDTO product = new ProdcutDTO();
                    int pro = rs.getInt("ProductID");
                    int quan = rs.getInt("Quantity");
                    //6. Add the product to the list
                    product = new ProdcutDTO(pro, quan);

                    if (this.listdto == null) {
                        this.listdto = new ArrayList<>();
                    }
                    this.listdto.add(product);
                }
            } // end if con is available
        } finally {
            // 6. Close connections
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
    }
}
