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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrwhi
 */
public class FilmDAO {

    private static boolean st = false;
    private static Connection connection;
    private static ResultSet rs;
    private static List<Film> films = new ArrayList<Film>();
    private static ArrayList<Film> filmdetails = new ArrayList<Film>();
    private static ArrayList<Film> inventory = new ArrayList<Film>();
    private static ArrayList<Film> cartfilms = new ArrayList<Film>();
    private static ArrayList<Film> wishlistfilms = new ArrayList<Film>();
    private static ArrayList<Film> filmsbought = new ArrayList<Film>();

    public FilmDAO() {
        connection = DBConnectionUtil.getConnection();
    }

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

    public static List<Film> getCartDetails() {

        return cartfilms;

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

    public static void addCart(int customer_id, int film_id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " INSERT INTO shoppingcart(Customer_Id,Film_id) VALUES (?, ?)");

            ps.setInt(1, customer_id);
            ps.setInt(2, film_id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void viewCart(int customer_id) {

        cartfilms.clear();
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " SELECT SC.Customer_Id, F.film_id, F.title, F.rental_rate"
                    + " FROM shoppingcart as SC"
                    + " JOIN film as F"
                    + " ON SC.Film_Id = F.film_id"
                    + " where SC.Customer_Id=?");
            ps.setInt(1, customer_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setFilm_id(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setRental_rate(rs.getString("rental_rate"));
                cartfilms.add(film);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void getRentalNoBS() {
        films.clear();
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    "SELECT DISTINCT F.Film_id, F.title, FT.description, F.rental_rate, F.rating, F.last_update FROM Film AS F JOIN film_text as FT ON FT.film_id=F.film_id JOIN RentalNOBS as R ON R.Film_Id=F.film_id");
            ResultSet rs = ps.executeQuery();
            st = rs.next();
            while (rs.next()) {
                Film film = new Film();
                film.setFilm_id(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setRental_rate(rs.getString("rental_rate"));
                film.setRating(rs.getString("rating"));
                film.setInStock(false);
                films.add(film);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Film> getInventory() {
        inventory.clear();
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(" SELECT DISTINCT F.Film_id, F.title, FT.description, F.rental_rate, F.rating, F.last_update FROM Film AS F JOIN film_text as FT ON FT.film_id=F.film_id");
            ResultSet rs = ps.executeQuery();
            st = rs.next();
            while (rs.next()) {
                Film film = new Film();
                film.setFilm_id(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setRental_rate(rs.getString("rental_rate"));
                film.setRating(rs.getString("rating"));
                film.setLast_update(rs.getDate("last_update").toString());
                film.setInStock(true);
                inventory.add(film);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < inventory.size(); i++) {
            for (int x = 0; x < films.size(); x++) {
                if (inventory.get(i).getFilm_id() == films.get(x).getFilm_id()) {
                    inventory.get(i).setInStock(false);
                }
            }

        }
        return inventory;
    }

    public static double calculateTotal(int customer_id) {

        double Total = 0.0;
        double listValue = 0.0;

        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    "SELECT f.rental_rate "
                    + " FROM shoppingcart AS S"
                    + " JOIN film as F"
                    + " ON S.film_id=F.film_id"
                    + " WHERE S.Customer_Id=?");
            ps.setInt(1, customer_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                listValue = Double.parseDouble(rs.getString("rental_rate"));
                Total += listValue;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Total;
    }

    public static void deleteFilm(int customer_id, int film_id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " DELETE FROM shoppingcart WHERE customer_id="
                    + customer_id
                    + " and film_id="
                    + film_id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double calculateChange(double Total, String Payment_Amount) {

        double Payment = Double.parseDouble(Payment_Amount);
        double result = 0.0;

        result = Payment - Total;

        return result;
    }

    public static void addWishlist(int customer_id, int film_id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " INSERT INTO wishlist(Customer_Id,Film_id) VALUES (?, ?)");

            ps.setInt(1, customer_id);
            ps.setInt(2, film_id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void viewWishlist(int customer_id) {

        wishlistfilms.clear();
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " SELECT F.film_id, F.title, F.rental_rate"
                    + " FROM wishlist as W"
                    + " JOIN film as F"
                    + " ON W.Film_Id = F.film_id"
                    + " where W.Customer_Id=?");
            ps.setInt(1, customer_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setFilm_id(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setRental_rate(rs.getString("rental_rate"));
                wishlistfilms.add(film);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Film> getWishlistDetails() {

        return wishlistfilms;

    }

    public static void deleteWish(int customer_id, int film_id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " DELETE FROM wishlist WHERE customer_id="
                    + customer_id
                    + " and film_id="
                    + film_id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getFilmsBought(int customer_id) {

        filmsbought.clear();
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " SELECT F.film_id, F.title, F.rental_rate, F.rental_duration"
                    + " FROM shoppingcart as SC"
                    + " JOIN film as F"
                    + " ON SC.Film_Id = F.film_id"
                    + " where SC.Customer_Id=?");
            ps.setInt(1, customer_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setFilm_id(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setRental_rate(rs.getString("rental_rate"));
                film.setRental_duration(rs.getString("rental_duration"));
                filmsbought.add(film);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Film> getFilmsBought() {

        return filmsbought;

    }

    public static void deleteCartInfo(int customer_id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM shoppingcart WHERE customer_id=" + customer_id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
