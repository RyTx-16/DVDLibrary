package DVDLibrary;

/**
 * @author Ryan Taylor
 */

import java.util.HashMap;
import static DVDLibrary.Menu.dvdLibrary;

/**
 * Concrete Class for creating a DVD Object, holds the variables needed to create the object.
 */
public class DVD {
    public static int uniqueId = 1;
    private int id;
    private String title;
    private String date;
    private String MPAARating; // G, PG, PG-13, R, NC-17
    private String director;
    private String studio;
    private String userRating;

    /**
     * Simple Constructor for creating a DVD Object and adding it to the library.
     * @param title
     * @param date
     */
    public DVD(String title, String date){
        this.id = uniqueId++;
        this.title = title;
        this.date = date;
        dvdLibrary.add(this);
    }

    /**
     * Constructor for creating a DVD Object using the information stored in the HashMap.
     * @param values
     */
    public DVD(HashMap<Integer, String> values) {
        this.id = uniqueId++;
        this.title = values.get(0);
        this.date = values.get(1);
        this.MPAARating = values.get(2);
        this.director = values.get(3);
        this.studio = values.get(4);
        this.userRating = values.get(5);
        dvdLibrary.add(this);
    }

    /**
     * Getters and Setters for each one of my variables.
     */
    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMPAARating() {
        return MPAARating;
    }

    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return
                title +
                "," + date +
                "," + MPAARating +
                "," + director +
                "," + studio +
                "," + userRating;
    }

    public String toStringFormatted(){
        return
                title +
                " -> " + date +
                ", " + MPAARating +
                ", " + director +
                ", " + studio +
                ", " + userRating;
    }
}
