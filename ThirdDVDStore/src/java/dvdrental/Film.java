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
public class Film {

    private int film_id;
    private String title;
    private String description;
    private String release_year;
    private String language_id;
    private String original_language_id;
    private String rental_duration;
    private String rental_rate;
    private String length;
    private String replacement_cost;
    private String rating;
    private String special_features;
    private String last_update;
    private String rental_date;
    private boolean inStock;

    public boolean getInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getRental_date() {
        return rental_date;
    }

    public void setRental_date(String rental_date) {
        this.rental_date = rental_date;
    }

    /**
     * @return the film_id
     */
    public int getFilm_id() {
        return film_id;
    }

    /**
     * @param film_id the film_id to set
     */
    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the release_year
     */
    public String getRelease_year() {
        return release_year;
    }

    /**
     * @param release_year the release_year to set
     */
    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    /**
     * @return the language_id
     */
    public String getLanguage_id() {
        return language_id;
    }

    /**
     * @param language_id the language_id to set
     */
    public void setLanguage_id(String language_id) {
        this.language_id = language_id;
    }

    /**
     * @return the original_language_id
     */
    public String getOriginal_language_id() {
        return original_language_id;
    }

    /**
     * @param original_language_id the original_language_id to set
     */
    public void setOriginal_language_id(String original_language_id) {
        this.original_language_id = original_language_id;
    }

    /**
     * @return the rental_duration
     */
    public String getRental_duration() {
        return rental_duration;
    }

    /**
     * @param rental_duration the rental_duration to set
     */
    public void setRental_duration(String rental_duration) {
        this.rental_duration = rental_duration;
    }

    /**
     * @return the rental_rate
     */
    public String getRental_rate() {
        return rental_rate;
    }

    /**
     * @param rental_rate the rental_rate to set
     */
    public void setRental_rate(String rental_rate) {
        this.rental_rate = rental_rate;
    }

    /**
     * @return the length
     */
    public String getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * @return the replacement_cost
     */
    public String getReplacement_cost() {
        return replacement_cost;
    }

    /**
     * @param replacement_cost the replacement_cost to set
     */
    public void setReplacement_cost(String replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * @return the special_features
     */
    public String getSpecial_features() {
        return special_features;
    }

    /**
     * @param special_features the special_features to set
     */
    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }

    /**
     * @return the last_update
     */
    public String getLast_update() {
        return last_update;
    }

    /**
     * @param last_update the last_update to set
     */
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

}
