/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

/**
 *
 * @author mrwhi
 */
public class Customer {
    
    private int Customer_Id;
    private String Username;
    private String Password;
    private String Customer_Pref;
    private String Payment;
    private String Email; 

    /**
     * @return the Customer_Id
     */
    public int getCustomer_Id() {
        return Customer_Id;
    }

    /**
     * @param Customer_Id the Customer_Id to set
     */
    public void setCustomer_Id(int Customer_Id) {
        this.Customer_Id = Customer_Id;
    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Customer_Pref
     */
    public String getCustomer_Pref() {
        return Customer_Pref;
    }

    /**
     * @param Customer_Pref the Customer_Pref to set
     */
    public void setCustomer_Pref(String Customer_Pref) {
        this.Customer_Pref = Customer_Pref;
    }

    /**
     * @return the Payment
     */
    public String getPayment() {
        return Payment;
    }

    /**
     * @param Payment the Payment to set
     */
    public void setPayment(String Payment) {
        this.Payment = Payment;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
    
}
