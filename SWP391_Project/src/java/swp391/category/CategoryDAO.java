/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.category;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import swp391.utils.DBHelper;

/**
 *
 * @author nguye
 */
public class CategoryDAO implements Serializable {

    public List<CategoryDTO> getListCategory() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CategoryDTO> list = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {

                String sql = "SELECT CateID, Name, Description, Status "
                        + "FROM Category";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();

                while (rs.next()) {
                    CategoryDTO dto = new CategoryDTO();
                    dto.setCateID(rs.getInt("CateID"));
                    dto.setName(rs.getString("Name"));
                    dto.setDescription(rs.getString("Description"));
                    dto.setStatus(rs.getBoolean("Status"));

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

    public boolean createCategory(CategoryDTO dto)
            throws SQLException, NamingException {;
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Insert Into Category("
                        + "Name, Description, Status "
                        + ") "
                        + "Values(?, ?, 1 "
                        + ")";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getName());
                stm.setString(2, dto.getDescription());
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

    private List<CategoryDTO> categorysList;

    public List<CategoryDTO> getCategorysList() {
        return categorysList;
    }

    public void showCategory()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select CateID, Name, Description, Status "
                        + "From Category";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int cateID = rs.getInt("CateID");
                    String name = rs.getString("Name");
                    String description = rs.getString("Description");
                    boolean status = rs.getBoolean("Status");
                    CategoryDTO dto = new CategoryDTO(cateID, name, description, status);
                    if (this.categorysList == null) {
                        this.categorysList = new ArrayList<>();
                    }
                    this.categorysList.add(dto);
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

    public boolean updateCartegory(int cateID, String name,
            String description, boolean status)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBHelper.makeConnection();
            String sql = "Update Category "
                    + "Set Name = ?, Description = ? , Status = ? "
                    + "Where CateID = ?";
            //3. Create statement
            stm = con.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, description);
            stm.setBoolean(3, status);
            stm.setInt(4, cateID);
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

    public boolean deleteCategory(int cateID)
            throws SQLException, NamingException {;
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Update Category "
                        + "Set Status = 0 "
                        + "Where CateID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, cateID);
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

    public List<Integer> getListSizeByCategory(int cateID)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Integer> list = null;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select Size \n"
                        + "from ProductSize ps, Product p \n"
                        + "where p.SizeID = ps.SizeID and CateID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, cateID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int size = rs.getInt("Size");
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(size);
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

    public List<Integer> getListSize()
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Integer> list = null;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select Size \n"
                        + "from ProductSize ps, Product p \n"
                        + "where p.SizeID = ps.SizeID\n"
                        + "group by Size";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int size = rs.getInt("Size");
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(size);
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

}
