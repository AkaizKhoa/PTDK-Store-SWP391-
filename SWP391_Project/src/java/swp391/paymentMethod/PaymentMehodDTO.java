/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.paymentMethod;

/**
 *
 * @author Duy
 */
public class PaymentMehodDTO {
    private int paymentID;
    private String nameOfMethod;
    private int status;

    public PaymentMehodDTO() {
    }

    public PaymentMehodDTO(int paymentID, String nameOfMethod, int status) {
        this.paymentID = paymentID;
        this.nameOfMethod = nameOfMethod;
        this.status = status;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getNameOfMethod() {
        return nameOfMethod;
    }

    public void setNameOfMethod(String nameOfMethod) {
        this.nameOfMethod = nameOfMethod;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
