/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import swp391.brand.BrandDAO;
import swp391.brand.BrandDTO;
import swp391.category.CategoryDAO;
import swp391.category.CategoryDTO;
import swp391.product.ProductDAO;
import swp391.product.ProductDTO;
import swp391.utils.MyApplicationConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Chau Nhat Truong
 */
@WebServlet(name = "AdminNewProductServlet", urlPatterns = {"/AdminNewProductServlet"})
//@MultipartConfig(
//        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
//        maxFileSize = 1024 * 1024 * 10, // 10MB
//        maxRequestSize = 1024 * 1024 * 50 // 50MB
//)
@MultipartConfig(maxFileSize = 16177215) // 16MB
public class AdminNewProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        String url = siteMaps.getProperty(
                MyApplicationConstants.AdminNewProductServlet.ADMINPRODUCTLIST_PAGE); //

        // Check if user is logged in
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("USER") == null) {
            response.sendRedirect(siteMaps.getProperty(
                MyApplicationConstants.LoginServlet.LOGIN_PAGE));
            return;
        }
        
        String name = request.getParameter("txtName");
        System.out.println("txtName:" + name);
          byte[] bytes1 = name.getBytes(StandardCharsets.ISO_8859_1);
        name = new String(bytes1, StandardCharsets.UTF_8);
        
        String description = request.getParameter("txtDescription");
        System.out.println("txtDescription:" + description);
 byte[] bytes2 = description.getBytes(StandardCharsets.ISO_8859_1);
        description = new String(bytes2, StandardCharsets.UTF_8);
        
        
        String txtQuantity = request.getParameter("txtQuantity");
        int quantity = Integer.parseInt(txtQuantity);
        System.out.println("txtQuantity:" + quantity);

        String txtPrice = request.getParameter("txtPrice");
        float price = Float.parseFloat(txtPrice);
        System.out.println("txtPrice:" + price);

        String txtSize = request.getParameter("txtSize");
        int sizeID = Integer.parseInt(txtSize);
        System.out.println("txtSize:" + sizeID);

        String cboCategory = request.getParameter("cboCategory");
        int categoryID = Integer.parseInt(cboCategory);
        System.out.println("cboCategory:" + categoryID);

        String cboBrand = request.getParameter("cboBrand");
        int brandID = Integer.parseInt(cboBrand);
        System.out.println("cboBrand:" + brandID);

        // Get the first image data from the request
        Part filePart1 = request.getPart("image1");
        String imageName1 = filePart1.getSubmittedFileName();
//        String imageFilePath1 = "D:/SWP/SWP391_Project/web/images/" + imageName1;
//        InputStream imageData1 = filePart1.getInputStream();
        System.out.println("IMAGE:" + filePart1);
        Part filePart2 = request.getPart("image2");
        String imageName2 = filePart2.getSubmittedFileName();
//          String imageFilePath2 = "D:/SWP/SWP391_Project/web/images/" + imageName2;

//        InputStream imageData2 = filePart2.getInputStream();
        
        try {
            CategoryDAO categoryDao = new CategoryDAO();
            categoryDao.showCategory();
            List<CategoryDTO> categoryResult = categoryDao.getCategorysList();
            request.setAttribute("CATEGORY_RESULT", categoryResult);
            BrandDAO brandDao = new BrandDAO();
            brandDao.showBrand();
            List<BrandDTO> brandResult = brandDao.getBrandsList();
            request.setAttribute("BRAND_RESULT", brandResult);
////          
//            ByteArrayOutputStream buffer1 = new ByteArrayOutputStream();
//
//            int nRead1;
//            byte[] data1 = new byte[1024];
//
//            while ((nRead1 = imageData1.read(data1, 0, data1.length)) != -1) {
//                buffer1.write(data1, 0, nRead1);
//            }
//
//            buffer1.flush();
//
//            byte[] byteArray1 = buffer1.toByteArray();
//
//            ByteArrayOutputStream buffer2 = new ByteArrayOutputStream();
//
//            int nRead2;
//            byte[] data2 = new byte[1024];
//
//            while ((nRead2 = imageData2.read(data2, 0, data2.length)) != -1) {
//                buffer2.write(data2, 0, nRead2);
//            }
//
//            buffer2.flush();
//
//            byte[] byteArray2 = buffer2.toByteArray();
//
//            // Convert byteArray1 to Base64 encoding
//            String base64Image1 = Base64.getEncoder().encodeToString(byteArray1);
//            System.out.println("ImageData1:" + base64Image1);
//            // Convert byteArray2 to Base64 encoding
//            String base64Image2 = Base64.getEncoder().encodeToString(byteArray2);
//            System.out.println("ImageData2:" + base64Image2);
//
//            // Set the Base64-encoded images as request attributes
//            request.setAttribute("base64Image1", base64Image1);
//            request.setAttribute("base64Image2", base64Image2);

            ProductDAO dao = new ProductDAO();
            ProductDTO dto1 = new ProductDTO(brandID, name, description, quantity, price, true, sizeID, brandID, brandID, imageName1, imageName2);

            boolean result1 = dao.createProduct(dto1);
            if (result1) {
                url = siteMaps.getProperty(
                        MyApplicationConstants.AdminNewProductServlet.ADMINPRODUCTLIST_PAGE);
            }
//            }
        } catch (NamingException ex) {
            log("AdminNewProductServlet _ Naming _ " + ex.getMessage());
        } catch (SQLException ex) {
            log("AdminNewProductServlet _ SQL _ " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
