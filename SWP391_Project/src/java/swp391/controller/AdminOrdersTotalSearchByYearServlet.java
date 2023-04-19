/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;
import swp391.orders.OrdersDAO;
import swp391.orders.OrdersDTO;
import swp391.utils.MyApplicationConstants;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AdminOrdersTotalSearchByYearServlet", urlPatterns = {"/AdminOrdersTotalSearchByYearServlet"})
public class AdminOrdersTotalSearchByYearServlet extends HttpServlet {

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
                MyApplicationConstants.AdminOrdersTotalSearchByYearServlet.ADMIN_PAGE);
        // Check if user is logged in
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("USER") == null) {
            response.sendRedirect(siteMaps.getProperty(
                    MyApplicationConstants.LoginServlet.LOGIN_PAGE));
            return;
        }
        String dateOrderYear = request.getParameter("txtYearOrder");
        
        try{
            if (dateOrderYear == null || dateOrderYear.isEmpty()) {
                OrdersDAO dao1 = new OrdersDAO();
                dao1.showOrdersRevenueByMonth();
                List<OrdersDTO> result1 = dao1.getOrdersList1();
                request.setAttribute("MONTHREVENUE_RESULT", result1);

                OrdersDAO dao2 = new OrdersDAO();
                dao2.showOrdersRevenueByYear();
                List<OrdersDTO> result2 = dao2.getOrdersList2();
                request.setAttribute("YEARREVENUE_RESULT", result2);

                OrdersDAO dao3 = new OrdersDAO();
                dao3.showTotalOrdersByMonth();
                List<OrdersDTO> result3 = dao3.getOrdersList3();
                request.setAttribute("TOTALORDERSINMONTH_RESULT", result3);

                OrdersDAO dao4 = new OrdersDAO();
                dao4.showTotalOrdersByYear();
                List<OrdersDTO> result4 = dao4.getOrdersList4();
                request.setAttribute("TOTALORDERSINYEAR_RESULT", result4);

                System.out.println(result1);
                System.out.println(result2);
                System.out.println(result3);
                System.out.println(result4);

                url = siteMaps.getProperty(
                        MyApplicationConstants.AdminOrdersTotalSearchByYearServlet.ADMIN_PAGE);
            } else {
                int year = Integer.parseInt(dateOrderYear);

                OrdersDAO dao4 = new OrdersDAO();
                dao4.showTotalOrdersByYearSearch(year);
                List<OrdersDTO> result4 = dao4.getOrdersList4();
                if (result4 == null) {
                    dao4.showTotalOrdersByYear();
                    result4 = dao4.getOrdersList4();
                    request.setAttribute("TOTALORDERSINYEAR_RESULT", result4);

                    OrdersDAO dao1 = new OrdersDAO();
                    dao1.showOrdersRevenueByMonth();
                    List<OrdersDTO> result1 = dao1.getOrdersList1();
                    request.setAttribute("MONTHREVENUE_RESULT", result1);

                    OrdersDAO dao2 = new OrdersDAO();
                    dao2.showOrdersRevenueByYear();
                    List<OrdersDTO> result2 = dao2.getOrdersList2();
                    request.setAttribute("YEARREVENUE_RESULT", result2);

                    OrdersDAO dao3 = new OrdersDAO();
                    dao3.showTotalOrdersByMonth();
                    List<OrdersDTO> result3 = dao3.getOrdersList3();
                    request.setAttribute("TOTALORDERSINMONTH_RESULT", result3);

                    url = siteMaps.getProperty(
                            MyApplicationConstants.AdminOrdersTotalSearchByYearServlet.ADMIN_PAGE);
                } else {
                    request.setAttribute("TOTALORDERSINYEAR_RESULT", result4);

                    OrdersDAO dao1 = new OrdersDAO();
                    dao1.showOrdersRevenueByMonth();
                    List<OrdersDTO> result1 = dao1.getOrdersList1();
                    request.setAttribute("MONTHREVENUE_RESULT", result1);

                    OrdersDAO dao2 = new OrdersDAO();
                    dao2.showOrdersRevenueByYear();
                    List<OrdersDTO> result2 = dao2.getOrdersList2();
                    request.setAttribute("YEARREVENUE_RESULT", result2);

                    OrdersDAO dao3 = new OrdersDAO();
                    dao3.showTotalOrdersByMonth();
                    List<OrdersDTO> result3 = dao3.getOrdersList3();
                    request.setAttribute("TOTALORDERSINMONTH_RESULT", result3);
                    url = siteMaps.getProperty(
                            MyApplicationConstants.AdminOrdersTotalSearchByYearServlet.ADMIN_PAGE);
                }
            }


        
         } catch (NamingException ex) {
            log("AdminOrdersRevenueServlet _ Naming _ " + ex.getMessage());
        } catch (SQLException ex) {
            log("AdminOrdersRevenueServlet _ SQL _ " + ex.getMessage());
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
