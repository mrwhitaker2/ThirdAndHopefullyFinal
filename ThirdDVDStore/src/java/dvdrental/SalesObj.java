/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

/**
 *
 * @author Taylor
 */
public class SalesObj {

    private String title;
    private double rental_rate;
    private int times_rented;
    private double sales;
    private double replacement_cost;
    private double revenue;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(double rental_rate) {
        this.rental_rate = rental_rate;
    }

    public int getTimes_rented() {
        return times_rented;
    }

    public void setTimes_rented(int times_rented) {
        this.times_rented = times_rented;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(double replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public double calcRevenue()
    {
        double rev;
        if(sales < replacement_cost)
        {
            rev = replacement_cost - sales;
        }
        else{
            rev = sales - replacement_cost;
        }
        
        return rev;
    }
    
}
