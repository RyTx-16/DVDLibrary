package DVDLibrary;

/**
 * @author Ryan Taylor
 */

import java.io.*;
import java.util.HashMap;

/**
 * Adds result of line from the in file to a HashMap, meaning that I can call each
 * individual word in line and add it to the ArrayList using a DVD Constructor.
 */
public class ReadFile {
    public final String INFILE = "dvds.txt";
    public static HashMap<Integer, String> values = new HashMap<>();

    public ReadFile() {
        File fileName = new File(INFILE);

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String str = "";
            do {
                str = br.readLine(); // Reads each line in the file and assigns to a String.
                if (str != null) {
                    String [] dvd = str.split(","); // Feeds line into an Array, splits it by ','.
                    for (int i=0; i <= dvd.length-1; i++) {
                        if (i == 1){
                            dvd[i] = dvd[i].replaceAll("/", ""); // Removes any '/' from string for dates. Dash Marshalling.
                            //System.out.println(dvd[i]);
                            while (dvd[i].length() <= 7){ // Ensures length of date is equal to 8
                                dvd[i] = (0+dvd[i]);
                            }
                        }
                        values.put(i, dvd[i]); // Adds the index and value of the index to the HashMap for each line in the .txt file.
                    }
                    DVD dvdAdd = new DVD(values); // Creates a new DVD Object using file inputs. Added to ArrayList through obj constructor.
                }
            } while (str != null);
        } catch (IOException e ){
            e.printStackTrace();
        } System.out.println("DVD Library loaded from: " + INFILE);
    }
}

