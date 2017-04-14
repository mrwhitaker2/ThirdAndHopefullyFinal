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
    private static ResultSet rs;
    private static List<Film> films = new ArrayList<Film>();
      private static List<Film> filmdetails = new ArrayList<Film>();

    public static void searchGenre(String field) {

        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " SELECT DISTINCT F.film_id, F.title, F.description, F.rental_duration, F.rental_rate, F.rating"
                    + " FROM inventory as I"
                    + " JOIN film as F"
                    + " ON I.film_id = F.film_id"
                    + " JOIN film_category as FC"
                    + " ON F.film_id = FC.film_id"
                    + " JOIN category as C"
                    + " ON FC.category_id = C.category_id"
                    + " where C.name =?");
            ps.setString(1, field);
            rs = ps.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setFilm_id(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setRental_duration(rs.getString("rental_duration"));
                film.setRental_rate(rs.getString("rental_rate"));
                film.setRating(rs.getString("rating"));
                films.add(film);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void searchActor(String field) {

        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " SELECT DISTINCT F.film_id, F.title, F.description, F.rental_duration, F.rental_rate, F.rating"
                    + " FROM inventory as I"
                    + " JOIN film as F"
                    + " ON I.film_id = F.film_id"
                    + " JOIN film_actor as FA"
                    + " ON F.film_id = FA.film_id"
                    + " JOIN actor as A"
                    + " ON FA.actor_id = A.actor_id"
                    + " where A.last_name = ?");
            ps.setString(1, field);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setFilm_id(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setRental_duration(rs.getString("rental_duration"));
                film.setRental_rate(rs.getString("rental_rate"));
                film.setRating(rs.getString("rating"));
                films.add(film);
            }
            st = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean searchStore(String field) {

        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " SELECT DISTINCT F.film_id, F.title, F.description, F.rental_duration, F.rental_rate, F.rating"
                    + " FROM film as F"
                    + " JOIN inventory as I"
                    + " ON F.film_id = I.film_id"
                    + " JOIN store as S"
                    + " ON I.store_id = S.store_id"
                    + " where S.store_id = ?");
            ps.setString(1, field);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
            while (rs.next()) {
                Film film = new Film();
                film.setFilm_id(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setRental_duration(rs.getString("rental_duration"));
                film.setRental_rate(rs.getString("rental_rate"));
                film.setRating(rs.getString("rating"));
                films.add(film);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

    public static List<Film> getSearchResults() {

        return films;

    }
    
    public static List<Film> getFilmDetails() {

        return filmdetails;

    }

    public static void getDetails(String film_id) {

        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " SELECT * FROM film where film_id=?");
            ps.setString(1, film_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setFilm_id(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setRelease_year(rs.getString("release_year"));
                film.setRental_duration(rs.getString("rental_duration"));
                film.setRental_rate(rs.getString("rental_rate"));
                film.setLength(rs.getString("length"));
                film.setRating(rs.getString("rating"));
                film.setSpecial_features(rs.getString("special_features"));
                filmdetails.add(film);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
