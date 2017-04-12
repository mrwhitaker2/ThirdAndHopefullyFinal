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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrwhi
 */
public class FilmDAO {
    
    private static boolean st = false;
   
    public static List<Film> searchGenre(String field) {
       
        List<Film> films = new ArrayList<Film>();
        
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " SELECT F.film_id, F.title, F.description"
                            + " FROM inventory as I"
                            + " JOIN film as F"
                            + " ON I.film_id = F.film_id"
                            + " JOIN film_category as FC"
                            + " ON F.film_id = FC.film_id"
                            + " JOIN category as C"
                            + " ON FC.category_id = C.category_id"
                            + " where C.name = '?'");       
            ps.setString(1, field);
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                Film film = new Film();
                film.setFilm_id(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                films.add(film);
            }
            //st = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        } 
        return films;
    }
    
    
    
    
    
     public static List<Film> searchActor(String field) {
         
         List<Film> films = new ArrayList<Film>();
       
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " SELECT F.film_id, F.title, F.description"
                            + " FROM inventory as I"
                            + " JOIN film as F"
                            + " ON I.film_id = F.film_id"
                            + " JOIN film_actor as FA"
                            + " ON F.film_id = FA.film_id"
                            + " JOIN actor as A"
                            + " ON FA.actor_id = A.actor_id"
                            + " where A.last_name = '?'");       
            ps.setString(1, field);
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                Film film = new Film();
                film.setFilm_id(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                films.add(film);
            }
            st = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return films;
    }
     
//     public static boolean searchStore(String field) {
//       
//        try {
//            //loading drivers for mysql
//            Class.forName("com.mysql.jdbc.Driver");
//
//            //creating connection with the database 
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
//            PreparedStatement ps = con.prepareStatement(
//                    " SELECT F.title, F.description, C.'name'"
//                            + " FROM film as F"
//                            + " JOIN film_category as FC"
//                            + " ON F.film_id = FC.film_id"
//                            + " JOIN category as C"
//                            + " ON FC.category_id = C.category_id"
//                            + " where C.name = '?'");       
//            ps.setString(1, field);
//            ResultSet rs = ps.executeQuery();
//            st = rs.next();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return st;
//    }



}
