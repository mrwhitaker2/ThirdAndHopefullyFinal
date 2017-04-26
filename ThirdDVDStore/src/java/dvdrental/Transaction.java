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
public class Transaction {
    
    private int t_id;
    private String Date_Rented;
    private int Film_Id;
    private int Customer_Id;
    private double Amount;
    private String title;

    /**
     * @return the t_id
     */
    public int getT_id() {
        return t_id;
    }

    /**
     * @param t_id the t_id to set
     */
    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    /**
     * @return the Date_Rented
     */
    public String getDate_Rented() {
        return Date_Rented;
    }

    /**
     * @param Date_Rented the Date_Rented to set
     */
    public void setDate_Rented(String Date_Rented) {
        this.Date_Rented = Date_Rented;
    }

    /**
     * @return the Film_Id
     */
    public int getFilm_Id() {
        return Film_Id;
    }

    /**
     * @param Film_Id the Film_Id to set
     */
    public void setFilm_Id(int Film_Id) {
        this.Film_Id = Film_Id;
    }

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
     * @return the Amount
     */
    public double getAmount() {
        return Amount;
    }

    /**
     * @param Amount the Amount to set
     */
    public void setAmount(double Amount) {
        this.Amount = Amount;
    }
    
     public String getTitle() {
        return title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
}
