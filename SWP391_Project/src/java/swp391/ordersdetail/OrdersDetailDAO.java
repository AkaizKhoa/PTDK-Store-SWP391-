/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.ordersdetail;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import swp391.cart.CartObject;
import swp391.orders.OrdersDAO;
import swp391.utils.DBHelper;

/**
 *
 * @author Chau Nhat Truong
 */
public class OrdersDetailDAO implements Serializable {

    public boolean addToOrdersDetail(CartObject cart, float discount, int ordersID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm1 = null;
        PreparedStatement stm2 = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String (For selected price)
                String sql1 = "SELECT [ProductID], [Price] FROM [SWP391].[dbo].[Product] "
                        + "where ProductID = ?";
                stm1 = con.prepareStatement(sql1);
                Map<String, Integer> items = cart.getItems();
                for (String productID : items.keySet()) {
                    stm1.setString(1, productID);
                    rs = stm1.executeQuery();
                    if (rs.next()) {
                        float price = rs.getFloat("Price");
                        float total = (price * items.get(productID)) - discount;
                        String sql2 = "Insert Into OrdersDetail("
                                + "ProductID, OrdersID, Quantity, Discount, Price, "
                                + " Total"
                                + ") "
                                + "Values("
                                + " ?, ?, ?, ?, ?, ?"
                                + ")";
                        stm2 = con.prepareStatement(sql2);
                        stm2.setInt(1, Integer.parseInt(productID));
                        stm2.setInt(2, ordersID);
                        stm2.setInt(3, items.get(productID));
                        stm2.setFloat(4, discount);
                        stm2.setFloat(5, price);
                        stm2.setFloat(6, total);

                        int effectedRows = stm2.executeUpdate();
                        if (effectedRows > 0) {
                            result = true;
                        }
                    }//end of insert cart on DB
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm1 != null) {
                stm1.close();
            }
            if (stm2 != null) {
                stm2.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    private List<OrdersDetailDTO> ordersDetailList;
    
    public float totalInOrderDetail(int ordersId){
        float total = 0;
        
        String sql = "select Total from OrdersDetail where OrdersID = ?";
        try {
            Connection con = DBHelper.makeConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, ordersId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                total += rs.getFloat("Total");
            }
            con.close();
        } catch (SQLException | NamingException ex) {
            ex.getMessage();
        }
        return total;
    }
    
    //getOrderDetailByOrderHeaderID -> select
    public List<OrdersDetailDTO> getlListOrdersDetail() {
        List<OrdersDetailDTO> list = new ArrayList<>();
        String sql = "SELECT [OrdersDtID]\n"
                + "      ,[ProductID]\n"
                + "      ,[OrdersID]\n"
                + "      ,[Quantity]\n"
                + "      ,[Discount]\n"
                + "      ,[Price]\n"
                + "      ,[Total]\n"
                + "      ,[Status]\n"
                + "  FROM [dbo].[OrdersDetail] where OrdersID = ? ";
        try {
            Connection con = DBHelper.makeConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            OrdersDAO aO = new OrdersDAO();
            int OrdersId = aO.getOrdersIdLastes();
            ps.setInt(1, OrdersId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrdersDetailDTO dTO = new OrdersDetailDTO();
                dTO.setOrdersDetailID(rs.getInt("OrdersDtID"));
                dTO.setProductID(rs.getInt("ProductID"));
                dTO.setQuantity(rs.getInt("Quantity"));
                dTO.setDiscount(rs.getFloat("Discount"));
                dTO.setPrice(rs.getFloat("Price"));
                dTO.setTotal(rs.getFloat("Total"));
                list.add(dTO);
            }
        } catch (SQLException | NamingException ex) {
            ex.getMessage();
        }
        return list;
    }
    
    public List<OrdersDetailDTO> getlListOrdersDetailByOrderID(int orderID) {
        List<OrdersDetailDTO> list = new ArrayList<>();
        String sql = "SELECT [OrdersDtID]\n"
                + "      ,[ProductID]\n"
                + "      ,[OrdersID]\n"
                + "      ,[Quantity]\n"
                + "      ,[Discount]\n"
                + "      ,[Price]\n"
                + "      ,[Total]\n"
                + "      ,[Status]\n"
                + "  FROM [dbo].[OrdersDetail] where OrdersID = ? ";
        try {
            Connection con = DBHelper.makeConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrdersDetailDTO dTO = new OrdersDetailDTO();
                dTO.setOrdersDetailID(rs.getInt("OrdersDtID"));
                dTO.setProductID(rs.getInt("ProductID"));
                dTO.setQuantity(rs.getInt("Quantity"));
                dTO.setDiscount(rs.getFloat("Discount"));
                dTO.setPrice(rs.getFloat("Price"));
                dTO.setTotal(rs.getFloat("Total"));
                list.add(dTO);
            }
        } catch (SQLException | NamingException ex) {
            ex.getMessage();
        }
        return list;
    }

    public float getTotalCartByOrdersId(int ordersId){
        float total = 0;
        String sql = "select Total from OrdersDetail where OrdersID = ?";
        try (Connection conn = DBHelper.makeConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ordersId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                total += rs.getFloat("Total");
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return total;
    }

    public List<OrdersDetailDTO> getOrdersDetailList() {
        return ordersDetailList;
    }

    public void showOrdersDetailID()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select Total "
                        + "From OrdersDetail";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    float total = rs.getFloat("Total");
                    OrdersDetailDTO dto = new OrdersDetailDTO(total);
                    if (this.ordersDetailList == null) {
                        this.ordersDetailList = new ArrayList<>();
                    }
                    this.ordersDetailList.add(dto);
                }
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
    }
    
    
    
     public int addToOrdersDetail(int productID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int key = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Insert Into OrdersDetail("
                        + "ProductID, Quantity, Discount, Price, PaymentID, "
                        + "ShippingID, Total, Status"
                        + ") "
                        + "Values("
                        + " ?, ?, ?, ?, ?, ?, ?, ?"
                        + ")";
                stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stm.setInt(1, productID);
                int effectedRows = stm.executeUpdate();
                rs = stm.getGeneratedKeys();
                if (rs.next()) {
                    key = rs.getInt(1);
                }
                while (effectedRows > 0) {
                    return key;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return key;
    }
    
   
}
