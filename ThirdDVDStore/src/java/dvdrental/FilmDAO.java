/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author mrwhi
 */
public class FilmDAO {
    
    private static boolean st = false;
   
    public static boolean searchGenre(String field) {
       
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " SELECT F.title, F.description, C.'name'"
                            + " FROM film as F"
                            + " JOIN film_category as FC"
                            + " ON F.film_id = FC.film_id"
                            + " JOIN category as C"
                            + " ON FC.category_id = C.category_id"
                            + " where C.name = '?'");       
            ps.setString(1, field);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

}
