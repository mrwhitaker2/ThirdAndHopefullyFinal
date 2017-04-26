/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

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
    private String rental_date;

    public String getRental_date() {
        return rental_date;
    }

    public void setRental_date(String Rental_date) {
        this.rental_date = Rental_date;
    }

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

    public double calcRevenue() {
        double rev;
        if (sales < replacement_cost) {
            rev = replacement_cost - sales;
        } else {
            rev = sales - replacement_cost;
        }

        return rev;
    }

    public boolean getDateAndCompare(String date) {

        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDate = localDate.format(formatter);
        LocalDate parseDate = LocalDate.parse(formatDate, formatter);
        List<String> todayList = Arrays.asList(formatDate.split("-"));
        List<String> dateList = Arrays.asList(date.split("-"));
        if(Integer.parseInt(todayList.get(0)) == Integer.parseInt(dateList.get(0)))
        {
           return false;
        }
        else{
                if(Integer.parseInt(todayList.get(1)) < Integer.parseInt(dateList.get(1)))
                {
                    return false;
                }
                else if(Integer.parseInt(todayList.get(1)) == Integer.parseInt(dateList.get(1)))
                {
                    if(Integer.parseInt(todayList.get(2)) < Integer.parseInt(dateList.get(2)))
                    {
                       return false; 
                    }
                }
            }
        return true;
    }
}
