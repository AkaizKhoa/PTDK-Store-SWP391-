/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import swp391.orders.OrdersDAO;
import swp391.orders.OrdersDTO;
import swp391.ordersdetail.OrdersDetailDAO;
import swp391.ordersdetail.OrdersDetailDTO;
import swp391.utils.MyApplicationConstants;

/**
 *
 * @author Duy
 */
@WebServlet(name = "AdminOrderedListServlet", urlPatterns = {"/AdminOrderedListServlet"})
public class AdminOrderedListServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITE_MAP");
        String url = siteMaps.getProperty(
                MyApplicationConstants.AdminOrdersListServlet.ADMIN_ORDERS_LIST_PAGE);
          // Check if user is logged in
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("USER") == null) {
            response.sendRedirect(siteMaps.getProperty(
                MyApplicationConstants.LoginServlet.LOGIN_PAGE));
            return;
        }
        String txtOrderId = request.getParameter("txtOrderId");
        String txtStatus = request.getParameter("txtStatus");
        System.out.println("TXT " + txtStatus);

        try {
            OrdersDAO ordersDAO = new OrdersDAO();
            OrdersDetailDAO ordersDetailDAO = new OrdersDetailDAO();

            List<OrdersDTO> ordersList = ordersDAO.getListOfOrders();
            request.setAttribute("ORDERS_LIST", ordersList);

            url = siteMaps.getProperty(
                    MyApplicationConstants.AdminOrdersListServlet.ADMIN_ORDERS_LIST_PAGE);

            if (txtOrderId != null) {
                int orderID = Integer.parseInt(txtOrderId);
                boolean status = Boolean.parseBoolean(txtStatus);
                System.out.println("ID:" + orderID);
                System.out.println("Status:" + status);
                boolean updateStatus = ordersDAO.updateOrderStatus(orderID, status);

                List<OrdersDetailDTO> list = ordersDetailDAO.getlListOrdersDetailByOrderID(orderID);
                request.setAttribute("orders_detail", list);

                if (updateStatus == true) {
                    ordersList = ordersDAO.getListOfOrders();
                    request.setAttribute("ORDERS_LIST", ordersList);
                    url = siteMaps.getProperty(
                            MyApplicationConstants.AdminOrdersListServlet.ADMIN_ORDERS_LIST_PAGE);
                }
            }

        } catch (NamingException ex) {
            log("AdminCategoryListServlet _ Naming _ " + ex.getMessage());
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminOrderedListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminOrderedListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
