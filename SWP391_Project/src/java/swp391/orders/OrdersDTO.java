/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.orders;

import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import javax.naming.NamingException;
import swp391.customer.CustomerDAO;
import swp391.ordersdetail.OrdersDetailDAO;
import swp391.paymentMethod.PaymentMethodDAO;
import swp391.shippingmethod.ShippingMethodDAO;

/**
 *
 * @author Chau Nhat Truong
 */
public class OrdersDTO implements Serializable {

    private int ordersID;
    private int customerID;
    private int paymentID;
    private int shippingID;
    private Date dateOrders;
    private int status;
    private String cusName;
    private String cusPhone;
    private String cusAddress;
    private float revenue;
    private int month;
    private int year;
    private int totalOrders;

    public OrdersDTO(int ordersID, int customerID, int paymentID, int shippingID, Date dateOrders, int status, String cusName, String cusPhone, String cusAddress) {
        this.ordersID = ordersID;
        this.customerID = customerID;
        this.paymentID = paymentID;
        this.shippingID = shippingID;
        this.dateOrders = dateOrders;
        this.status = status;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
    }
    
    public OrdersDTO(int ordersID, int paymentID, int shippingID, Date dateOrders, String cusName, String cusPhone, String cusAddress) {
        this.ordersID = ordersID;
        this.paymentID = paymentID;
        this.shippingID = shippingID;
        this.dateOrders = dateOrders;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
    }

    public OrdersDTO(int ordersID, int customerID, int shippingID, Date dateOrders, int status) {
        this.ordersID = ordersID;
        this.customerID = customerID;
        this.shippingID = shippingID;
        this.dateOrders = dateOrders;
        this.status = status;
    }

    public OrdersDTO(int ordersID, int shippingID, Date dateOrders, int status) {
        this.ordersID = ordersID;
        this.shippingID = shippingID;
        this.dateOrders = dateOrders;
        this.status = status;
    }
    
    public String getNameOfUser() throws SQLException, NamingException {
        CustomerDAO customerDAO = new CustomerDAO();
        String customerName = customerDAO.getNameOfUserByUserID(this.customerID);
        return customerName;
    }

    public String getNameOfMethod() throws SQLException, NamingException {
        ShippingMethodDAO shippingMethodDAO = new ShippingMethodDAO();
        String nameOfMethod = shippingMethodDAO.getShippingNameByShippingId(this.shippingID);
        return nameOfMethod;
    }

    public String getNameOfPaymentMethod() throws SQLException, NamingException {
        PaymentMethodDAO paymentMethodDAO = new PaymentMethodDAO();
        String nameOfPaymentMethod = paymentMethodDAO.getNameOfMethodByMethodID(this.paymentID);
        return nameOfPaymentMethod;
    }

    public float getTotal() {
        float total = 0;
        OrdersDetailDAO dAO = new OrdersDetailDAO();
        total = total + dAO.getTotalCartByOrdersId(this.ordersID);
        return total;
    }

    public OrdersDTO() {
    }

    public OrdersDTO(int ordersID, String cusName, String cusPhone, String cusAddress) {
        this.ordersID = ordersID;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
    }

    public OrdersDTO(int ordersID, Date dateOrders, String cusName, String cusPhone, String cusAddress) {
        this.ordersID = ordersID;
        this.dateOrders = dateOrders;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
    }

    public OrdersDTO(int ordersID, int customerID, int shippingID, Date dateOrders, int status, String cusName, String cusPhone, String cusAddress) {
        this.ordersID = ordersID;
        this.customerID = customerID;
        this.shippingID = shippingID;
        this.dateOrders = dateOrders;
        this.status = status;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
    }

    public OrdersDTO(int ordersID, int customerID, Date dateOrders) {
        this.ordersID = ordersID;
        this.customerID = customerID;
        this.dateOrders = dateOrders;
    }

    public OrdersDTO(int ordersID) {
        this.ordersID = ordersID;
    }

    public OrdersDTO(int month, int year, int totalOrders) {
        this.month = month;
        this.year = year;
        this.totalOrders = totalOrders;
    }

    public OrdersDTO(int year, float revenue) {
        this.year = year;
        this.revenue = revenue;
    }

    public OrdersDTO(int month, int year, float revenue) {
        this.month = month;
        this.year = year;
        this.revenue = revenue;
    }

    public OrdersDTO(int year, int totalOrders) {
        this.year = year;
        this.totalOrders = totalOrders;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getOrdersID() {
        return ordersID;
    }

    public void setOrdersID(int ordersID) {
        this.ordersID = ordersID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getShippingID() {
        return shippingID;
    }

    public void setShippingID(int shippingID) {
        this.shippingID = shippingID;
    }

    public Date getDateOrders() {
        return dateOrders;
    }

    public void setDateOrders(Date dateOrders) {
        this.dateOrders = dateOrders;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    /**
     * @return the revenue
     */
    public float getRevenue() {
        return revenue;
    }

    /**
     * @param revenue the revenue to set
     */
    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the totalOrders
     */
    public int getTotalOrders() {
        return totalOrders;
    }

    /**
     * @param totalOrders the totalOrders to set
     */
    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

}
