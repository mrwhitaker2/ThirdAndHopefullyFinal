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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
    private static ArrayList<SalesObj> salesObjs = new ArrayList<SalesObj>();
    private static ArrayList<Film> wishlistfilms = new ArrayList<Film>();
    private static ArrayList<Film> filmsbought = new ArrayList<Film>();
    private static ArrayList<Film> rentedfilms = new ArrayList<Film>();
    private static ArrayList<Transaction> returnedfilms = new ArrayList<Transaction>();
    private static ArrayList<Film> filmCheck = new ArrayList<Film>();

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

    public static List<SalesObj> getMovieCheckoutsReport() {
        salesObjs.clear();
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    "SELECT F.title, F.rental_rate, COUNT( F.title) as 'Times Rented', SUM(R.Amount) as 'Sales', F.replacement_cost FROM RentalNoBS as R Join film as F on F.Film_Id=R.Film_Id GROUP BY F.Title");
            ResultSet rs = ps.executeQuery();
            st = rs.next();
            while (rs.next()) {
                SalesObj salesObj = new SalesObj();
                salesObj.setTitle(rs.getString("title"));
                salesObj.setRental_rate(rs.getDouble("rental_rate"));
                salesObj.setTimes_rented(rs.getInt("Times Rented"));
                salesObj.setSales(rs.getDouble("Sales"));
                salesObj.setReplacement_cost(rs.getDouble("replacement_cost"));
                salesObj.setRevenue(Math.round(salesObj.calcRevenue() * 100.0) / 100.0);
                salesObjs.add(salesObj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return salesObjs;
    }

    public static List<SalesObj> getBestSellers() {
        salesObjs.clear();
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    "SELECT T.Film_Id,F.title, SUM(T.amount) AS 'Sales' FROM Transactions as T JOIN Film as F ON F.Film_Id=T.Film_Id GROUP BY Film_Id ORDER BY Sales Desc");
            ResultSet rs = ps.executeQuery();
            st = rs.next();
            while (rs.next()) {
                SalesObj salesObj = new SalesObj();
                salesObj.setTitle(rs.getString("title"));
                salesObj.setSales(rs.getDouble("Sales"));
                salesObjs.add(salesObj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return salesObjs;
    }

    public static List<SalesObj> getNonSellers() {
        salesObjs.clear();
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    "SELECT F.title, T.Date_Rented FROM Transactions as T JOIN Film as F On F.film_id=T.Film_Id");
            ResultSet rs = ps.executeQuery();
            st = rs.next();
            while (rs.next()) {
                SalesObj salesObj = new SalesObj();
                salesObj.setTitle(rs.getString("title"));
                salesObj.setRental_date(rs.getString("Date_Rented"));
                if (salesObj.getDateAndCompare(salesObj.getRental_date()) == true) {
                    salesObjs.add(salesObj);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return salesObjs;
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

    public static void getBoughtFromTable(int customer_id) {

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

    public static ArrayList<Film> getFilmsBought() {

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

    public static void addToRentalTable(int customer_id, String formatDate, int filmID, String rentalRate, String Payment) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " INSERT INTO RentalNoBS(Customer_Id,Rental_Date,Film_Id,Amount, Payment_Type) VALUES (?, ?, ?, ?)");
            ps.setInt(1, customer_id);
            ps.setString(2, formatDate);
            ps.setInt(3, filmID);
            ps.setString(4, rentalRate);
            ps.setString(5, Payment);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void getRentedFilms(int customer_id) {
        rentedfilms.clear();
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    "SELECT F.film_id, R.rental_date, F.rental_rate, F.title, F.rental_duration"
                    + " FROM rentalnobs AS R"
                    + " JOIN film AS F"
                    + " ON R.`Film_Id` = F.film_id"
                    + " WHERE R.Customer_Id =?");

            ps.setInt(1, customer_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Film film = new Film();
                film.setFilm_id(rs.getInt("film_id"));
                film.setRental_date(rs.getString("rental_date"));
                film.setRental_rate(rs.getString("rental_rate"));
                film.setTitle(rs.getString("title"));
                film.setRental_duration(rs.getString("rental_duration"));

                rentedfilms.add(film);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Film> getRentedFilms() {

        return rentedfilms;

    }

    public static Film getFilmInformation(int film_id) {
        Film rentedFilm = new Film();

        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    "SELECT film_id, title, rental_duration, rental_rate"
                    + " FROM film"
                    + " WHERE film_id =?");

            ps.setInt(1, film_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                rentedFilm.setFilm_id(rs.getInt("film_id"));
                rentedFilm.setTitle(rs.getString("title"));
                rentedFilm.setRental_duration(rs.getString("rental_duration"));
                rentedFilm.setRental_rate(rs.getString("rental_rate"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rentedFilm;

    }

    public static Film getFilmDateRented(int film_id, int customer_id) {

        Film rentedFilm = new Film();

        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    "SELECT Rental_Date "
                    + " FROM RentalNoBS"
                    + " WHERE Film_Id =" + film_id
                    + " AND Customer_Id=" + customer_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                rentedFilm.setRental_date(rs.getString("Rental_Date"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rentedFilm;
    }

    public static double compareDueDate(String dateRented, int rental_duration, double rental_rate) {
        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDate = localDate.format(formatter);
        LocalDate parseDate = LocalDate.parse(formatDate, formatter);
        List<String> todayList = Arrays.asList(formatDate.split("-"));
        List<String> dateList = Arrays.asList(dateRented.split("-"));
        int x;
        if (Integer.parseInt(todayList.get(1)) > Integer.parseInt(dateList.get(1)) && Integer.parseInt(todayList.get(2)) > Integer.parseInt(dateList.get(2))) {
            x = Integer.parseInt(dateList.get(2)) + 30 + Integer.parseInt(todayList.get(2)) - rental_duration;
            rental_rate = x * (.20) * rental_rate;
            return rental_rate;
        }
        if (Integer.parseInt(dateList.get(1)) < Integer.parseInt(todayList.get(1)) && Integer.parseInt(dateList.get(2)) > Integer.parseInt(todayList.get(2))) {
            x = Integer.parseInt(dateList.get(2)) + 30 - rental_duration;
            rental_rate = x * (.20) * rental_rate;
            return rental_rate;
        }
        if (Integer.parseInt(dateList.get(1)) == Integer.parseInt(todayList.get(1))) {
            x = Integer.parseInt(dateList.get(2)) + rental_duration;
            if (x < Integer.parseInt(todayList.get(2))) {
                x = Integer.parseInt(todayList.get(2)) - x;
                rental_rate = x * (.20) * rental_rate;
                return rental_rate;
            } else {
                return rental_rate;
            }
        }

        return rental_rate;

    }

    public static void addToTransactions(String dateRented, int film_id, int customer_id, double amountPaid) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " INSERT INTO Transactions(Date_Rented,Film_Id,Customer_Id,Amount) VALUES (?, ?, ?, ?)");
            ps.setString(1, dateRented);
            ps.setInt(2, film_id);
            ps.setInt(3, customer_id);
            ps.setDouble(4, amountPaid);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void deleteFromRental(int customer_id, int film_id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " DELETE FROM rentalnobs WHERE customer_id="
                    + customer_id
                    + " and film_id="
                    + film_id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getReturnedFilms(int customer_id, int film_id) {
        returnedfilms.clear();
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    "SELECT T.Date_Rented, T.Film_Id, T.Customer_Id, T.Amount, F.title "
                    + " FROM transactions AS T"
                    + " JOIN film AS F"
                    + " ON T.Film_Id = F.film_id"
                    + " WHERE T.Customer_Id ="
                    + customer_id
                    + " and T.Film_Id="
                    + film_id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Transaction t = new Transaction();
                t.setDate_Rented(rs.getString("Date_Rented"));
                t.setFilm_Id(rs.getInt("Film_Id"));
                t.setCustomer_Id(rs.getInt("Customer_Id"));
                t.setAmount(rs.getDouble("Amount"));
                t.setTitle(rs.getString("title"));

                returnedfilms.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Transaction> getReturnedFilmsList() {

        return returnedfilms;

    }

    public static ArrayList<Film> checkMax5(int customer_id) {
        filmCheck.clear();
        try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * "
                    + " FROM shoppingcart"
                    + " WHERE Customer_Id ="
                    + customer_id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Film film = new Film();
                film.setFilm_id(rs.getInt("Film_Id"));

                filmCheck.add(film);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return filmCheck;

    }

    public static void deleteFromCartAtStart(int customer_id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=convertToNull", "root", "nbuser");
            PreparedStatement ps = con.prepareStatement(
                    " DELETE FROM shoppingcart WHERE customer_id="
                    + customer_id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
