/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.product;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.naming.NamingException;
import swp391.utils.DBHelper;

/**
 *
 * @author nguye
 */
public class ProductDAO implements Serializable {

    private List<ProductDTO> listProduct;

    public List<ProductDTO> getListProduct() {
        return listProduct;
    }

    private List<ProductDTO> listProductByFilter;

    public List<ProductDTO> getListProductByFilter() {
        return listProductByFilter;
    }

    public String getProductNameByProductId(int productId) {
        String productName = null;
        String sql = "Select name from Product where productid = ?";
        try {
            Connection con = DBHelper.makeConnection();

            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                productName = rs.getString("name");
            }
            con.close();
        } catch (SQLException | NamingException e) {
            e.getMessage();
        }
        return productName;
    }

    public int searchProduct(String searchValue)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT ProductID, Name, Description, Quantity, Price,p.CateID, p.Status, ps.Size, CreateTime, Avatar, Avatar2 \n"
                        + "from Product p join ProductSize ps on p.SizeID = ps.SizeID\n"
                        + "where p.Name like ? and p.Status = 1";

                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ProductID");
                    String name = rs.getString("Name");
                    String descr = rs.getString("Description");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    int cateID = rs.getInt("CateID");
                    boolean status = rs.getBoolean("Status");
                    int size = rs.getInt("Size");
                    Date date = rs.getDate("CreateTime");
                    String avatar = rs.getString("Avatar");
                    String avatar2 = rs.getString("Avatar2");
                    ProductDTO dto = new ProductDTO(id, name, descr, quantity, price, cateID, status, size, date, avatar, avatar2);

                    if (this.listProduct == null) {
                        this.listProduct = new ArrayList<>();
                    }
                    this.listProduct.add(dto);
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
        return this.listProduct.size();
    }

    public void searchByFilter(int cateID, double priceFrom, double priceTo, int size)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select ProductID, Name, Description, Quantity, Price, ps.Size, Avatar, Avatar2 "
                        + "From Product p, ProductSize ps "
                        + "Where ";
                if (cateID > 0) {
                    sql += " CateID = ? AND p.Status = 1 and p.SizeID = ps.SizeID";
                }
                if (priceFrom >= 0) {
                    sql += " And Price >= ? AND p.Status = 1 and p.SizeID = ps.SizeID";
                }
                if (priceTo != 0) {
                    sql += " And Price <= ? AND p.Status = 1 and p.SizeID = ps.SizeID";
                }
                if (size != 0) {
                    sql += " And ps.Size = ? AND p.Status = 1 and p.SizeID = ps.SizeID";
                }
                stm = con.prepareStatement(sql);
                stm.setInt(1, cateID);
                if (priceFrom >= 0 && priceTo != 0 && size != 0) {
                    stm.setDouble(2, priceFrom);
                    stm.setDouble(3, priceTo);
                    stm.setInt(4, size);
                } else if (priceFrom >= 0 && priceTo != 0) {
                    stm.setDouble(2, priceFrom);
                    stm.setDouble(3, priceTo);
                } else if (priceFrom >= 0 && size != 0) {
                    stm.setDouble(2, priceFrom);
                    stm.setInt(3, size);
                } else if (priceFrom >= 0) {
                    stm.setDouble(2, priceFrom);
                } else if (priceTo != 0 && size != 0) {
                    stm.setDouble(2, priceTo);
                    stm.setInt(3, size);
                } else if (priceTo != 0) {
                    stm.setDouble(2, priceTo);
                } else if (size != 0) {
                    stm.setInt(2, size);
                }
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ProductID");
                    String name = rs.getString("Name");
                    String description = rs.getString("Description");
//                    description = URLEncoder.encode(description, "UTF-8");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    size = rs.getInt("Size");
                    String avatar = rs.getString("Avatar");
                    String avatar2 = rs.getString("Avatar2");
                    ProductDTO dto = new ProductDTO(
                            id, name, description, quantity, price, size, avatar, avatar2);
                    if (this.listProductByFilter == null) {
                        this.listProductByFilter = new ArrayList<>();
                    }
                    this.listProductByFilter.add(dto);
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

    public ProductDTO getItemByID(String ID)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ProductDTO dto = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT ProductID, Name, Description, Quantity, Price, p.Status, Size,p.CateID, CreateTime, Avatar, Avatar2\n"
                        + " FROM Product p, ProductSize ps\n"
                        + " WHERE ProductID = ? and p.SizeID = ps.SizeID";
                stm = con.prepareStatement(sql);
                stm.setInt(1, Integer.parseInt(ID));
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ProductID");
                    String name = rs.getString("Name");
                    String description = rs.getString("Description");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    boolean status = rs.getBoolean("Status");
                    int size = rs.getInt("Size");
                    int cateID = rs.getInt("CateID");
                    Date date = rs.getDate("CreateTime");
                    String avatar = rs.getString("Avatar");
                    String avatar2 = rs.getString("Avatar2");
                    dto = new ProductDTO(id, name, description, quantity, price, cateID, status, size, date, avatar, avatar2);
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
        return dto;
    }

    public List<ProductDTO> getNewestProduct()
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ProductDTO dto = null;
        List<ProductDTO> list = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {

                String sql = "select ProductID, Name, Description, Price, ps.Size, Avatar, Avatar2\n"
                        + "                        from Product p, ProductSize ps\n"
                        + "                        where Name LIKE (select Name from Product where ProductID = (select max(ProductID) from Product)) and p.SizeID = ps.SizeID";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ProductID");
                    String name = rs.getString("Name");
                    String descr = rs.getString("Description");
//                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
//                    boolean status = rs.getBoolean("Status");
                    int size = rs.getInt("Size");
//                    Date date = rs.getDate("CreateTime");
                    String avatar = rs.getString("Avatar");
                    String avatar2 = rs.getString("Avatar2");

                    dto = new ProductDTO(id, name, price, descr, size, avatar, avatar2);

                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(dto);
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
        return list;
    }

    public List<ProductDTO> getSecondNewestProduct()
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ProductDTO dto = null;
        List<ProductDTO> list = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {

                String sql = "SELECT ProductID, Name, Description, Price, ps.Size, Avatar, Avatar2 \n"
                        + "                        FROM Product p, ProductSize ps\n"
                        + "                        WHERE Name = (\n"
                        + "                        SELECT TOP 1 Name\n"
                        + "                        FROM Product\n"
                        + "                        WHERE ProductID < (SELECT MAX(ProductID) FROM Product) \n"
                        + "                        AND Name not like (select Name from Product where ProductID = (SELECT MAX(ProductID) FROM Product))\n"
                        + "                        ORDER BY ProductID DESC\n"
                        + "                        ) and p.SizeID = ps.SizeID";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ProductID");
                    String name = rs.getString("Name");
                    String descr = rs.getString("Description");
//                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
//                    boolean status = rs.getBoolean("Status");
                    int size = rs.getInt("Size");
//                    Date date = rs.getDate("CreateTime");
                    String avatar = rs.getString("Avatar");
                    String avatar2 = rs.getString("Avatar2");
                    dto = new ProductDTO(id, name, price, descr, size, avatar, avatar2);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(dto);
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
        return list;
    }

    public List<ProductDTO> searchRelatedProduct(int cateID)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<ProductDTO> list = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT ProductID, Name, Description, Quantity, Price,p.CateID, p.Status, ps.Size, CreateTime, Avatar, Avatar2 \n"
                        + "from Product p join ProductSize ps on p.SizeID = ps.SizeID\n"
                        + "where p.CateID = ? and p.Status = 1";

                stm = con.prepareStatement(sql);
                stm.setInt(1, cateID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ProductID");
                    String name = rs.getString("Name");
                    String descr = rs.getString("Description");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("Price");
                    boolean status = rs.getBoolean("Status");
                    int size = rs.getInt("Size");
                    Date date = rs.getDate("CreateTime");
                    String avatar = rs.getString("Avatar");
                    String avatar2 = rs.getString("Avatar2");

                    ProductDTO dto = new ProductDTO(id, name, descr, quantity, price, cateID, status, size, date, avatar, avatar2);

                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(dto);
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
        return list;
    }

    private List<ProductDTO> itemsList;

    public List<ProductDTO> getItemsList() {
        return itemsList;
    }

    public void searchByFilter(float priceFrom, float priceTo, int size)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select Name, Description, Quantity, Price, Size "
                        + "From Product "
                        + "Where ";

                if (priceFrom >= 0) {
                    sql += " Price >= ?";
                }
                if (priceTo != 0) {
                    sql += " And Price <= ?";
                }
                if (size != 0) {
                    sql += " And Size = ?";
                }
                stm = con.prepareStatement(sql);
                stm.setFloat(1, priceFrom);
                stm.setFloat(2, priceTo);
                stm.setInt(3, size);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("Name");
                    String description = rs.getString("Description");
                    int quantity = rs.getInt("Quantity");
                    float price = rs.getFloat("Price");
                    size = rs.getInt("Size");

                    ProductDTO dto = new ProductDTO(
                            name, description, price, quantity, size);
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }
                    this.itemsList.add(dto);
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

    public void showProduct()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT p.ProductID, p.Name, p.Description, p.Quantity, p.Price, p.Status, p.Avatar , p.Avatar2 , ps.Size "
                        + "FROM Product p "
                        + "INNER JOIN ProductSize ps ON p.SizeID = ps.SizeID ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    String name = rs.getString("Name");
                    String description = rs.getString("Description");
                    int quantity = rs.getInt("Quantity");
                    float price = rs.getInt("Price");
                    int size = rs.getInt("Size");
                    boolean status = rs.getBoolean("Status");
                    String avatar = rs.getString("Avatar");
                    String avatar2 = rs.getString("Avatar2");
                    ProductDTO dto = new ProductDTO(productID, name, description, quantity, price, status, size, avatar, avatar2);
                    if (this.itemsList == null) {
                        this.itemsList = new ArrayList<>();
                    }
                    this.itemsList.add(dto);
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

    public boolean createProduct(ProductDTO dto)
            throws SQLException, NamingException {;
        Connection con = null;
        PreparedStatement stm = null;
        long milis = System.currentTimeMillis();
        Date date = new Date(milis);
        boolean result = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Insert Into Product("
                        + "Name, Description, Quantity, Price, Status , SizeID, "
                        + "CreateTime, CateID, BrandID , Avatar, Avatar2"
                        + ") "
                        + "Values(? , ? , ? , ? , ? , ? , ?, ? , ?  , ? , ? "
                        + ")";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getName());
                stm.setString(2, dto.getDescription());
                stm.setInt(3, dto.getQuantity());
                stm.setDouble(4, dto.getPrice());
                stm.setBoolean(5, true);
                stm.setInt(6, dto.getSize());
                stm.setDate(7, date);
                stm.setInt(8, dto.getCateID());
                stm.setInt(9, dto.getBrandID());
                stm.setString(10, dto.getAvatar());
                stm.setString(11, dto.getAvatar2());

                int effectedRows = stm.executeUpdate();
                if (effectedRows > 0) {
                    result = true;
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
        return result;
    }

    public boolean updateProduct(int productID, String name, String description, int quantity,
            float price)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBHelper.makeConnection();
            String sql = "Update Product "
                    + "Set Name = ?, Description = ?, Quantity = ?, Price = ? "
                    + "Where ProductID = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, description);
            stm.setInt(3, quantity);
            stm.setFloat(4, price);
            stm.setInt(5, productID);
            int effectedRows = stm.executeUpdate();
            if (effectedRows > 0) {
                result = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean deleteProduct(int productID)
            throws SQLException, NamingException {;
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Update Product "
                        + "Set Status = 0 "
                        + "Where ProductID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, productID);
                int effectedRows = stm.executeUpdate();
                if (effectedRows > 0) {
                    result = true;
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
        return result;
    }

}
