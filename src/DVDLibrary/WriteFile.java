package DVDLibrary;

import java.io.FileWriter;
import java.io.IOException;
import static DVDLibrary.Menu.dvdLibrary;

/**
 * @author Ryan Taylor
 * Writes the full DVD library collection to the same .txt file as the input file.
 */
public class WriteFile {
    public final String OUTFILE = "dvds.txt";

    public WriteFile(){

        FileWriter writer = null;
        try {
            writer = new FileWriter(OUTFILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < dvdLibrary.size(); i++) {
            try {
                writer.write(dvdLibrary.get(i) + System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nDVD Library saved to: " +OUTFILE);
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
