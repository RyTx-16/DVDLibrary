package DVDLibrary;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Ryan Taylor
 */

public class Menu {
    public static boolean inactive = false;
    public static ArrayList<DVD> dvdLibrary = new ArrayList<>(); // Static Array to store all DVDs
    /**
     * Menu system to loop the functionality of the program until the user decides to quit.
     */
    public Menu() {
        while (!inactive) {
            System.out.println("""
                    \n-------- DVD Collection System --------
                    \t1. Add New DVD
                    \t2. Edit Existing DVD
                    \t3. Remove a DVD
                    \t4. Display all DVDs
                    \t5. Find a DVD
                    \t9. Exit
                    Please enter an option:""");

            try {
                Scanner in = new Scanner(System.in);
                int menuScan = in.nextInt();
                switch (menuScan) {
                    case 1 -> addDVD();  // Creates a new DVD by calling a DVD Constructor.
                    case 2 -> editDVD(); // Iterate through the ArrayList and edits the details of a DVD.
                    case 3 -> removeDVD(); // Find one movie through DVD Title using getTitle getter. Remove the result from the collection.
                    case 4 -> printLibrary(); // Iterate through the ArrayList and print all results of the collection. Calls the toString by default.
                    case 5 -> findDVD(); // Finds one movie through DVD Title using getTitle getter.
                    case 9 -> {
                        // Exits the application and saves the library to a .txt file by calling the WriteFile Class.
                        inactive = true;
                        new WriteFile();
                    }
                    default -> System.out.println("Invalid Input Range.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong Input Type."); // Triggers Even in Method Called switch
            }
        }
    }

    /**
     * Method to add a new DVD to the library.
     */
    private void addDVD() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input DVD Name: ");
        String DvdTitle = in.nextLine();
        System.out.println("Input DVD Release Date: ");
        String DvdYear = in.nextLine();
        DVD newDvd = new DVD(DvdTitle, DvdYear);
        System.out.println(newDvd.getTitle() + ", added to the library; edit the details in menu.");
    }

    /**
     * Method to edit a specific detail of a DVD, using get and setters.
     */
    private void editDVD(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a DVD Title: ");
        String find = in.nextLine();
        boolean found = false, errorIndex = false; // Controls the flow of the method and prints the appropriate error handling.

        for (int i = 0; i < dvdLibrary.size(); i++) {
            if (dvdLibrary.get(i).getTitle().equalsIgnoreCase(find)) {
                System.out.println(dvdLibrary.get(i).toStringFormatted() + "\n\nInput category you want to change? \n" +
                        "\t1. Title\n\t2. Release Date\n\t3. MPAA Rating\n\t4. Director" +
                        "\n\t5. Studio\n\t6. User Rating");
                in = new Scanner(System.in);
                int editScan = in.nextInt();

                if ((editScan >= 1) && (editScan <= 6)) {
                    System.out.println("\nInput new information:  ");
                    in = new Scanner(System.in);
                    String editInfo = in.nextLine();
                    found = true;
                    switch (editScan)  {
                        case 1 -> dvdLibrary.get(i).setTitle(editInfo);
                        case 2 -> dvdLibrary.get(i).setDate(editInfo);
                        case 3 -> dvdLibrary.get(i).setMPAARating(editInfo);
                        case 4 -> dvdLibrary.get(i).setDirector(editInfo);
                        case 5 -> dvdLibrary.get(i).setStudio(editInfo);
                        case 6 -> dvdLibrary.get(i).setUserRating(editInfo);
                        default -> System.out.println("Invalid Choice.");
                    }
                    System.out.println("Updated DVD Information -> " + dvdLibrary.get(i).toStringFormatted());
                } else {
                    errorIndex = true;
                    System.out.println("Input not in valid range.");
                }
            }
        } if ((!found) & (!errorIndex)) {
            System.out.println(find + ", not found in library."); // Prints only if both conditions are met
        }
    }

    /**
     * Method which removes a specific DVD from the library as well as its details.
     */
    private void removeDVD(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a Title: ");

        String removeDVD = in.nextLine();
        for (int i = 0; i < dvdLibrary.size(); i++) {
            if (dvdLibrary.get(i).getTitle().equalsIgnoreCase(removeDVD)) { // Using IgnoreCase to ensure the result is found.
                dvdLibrary.remove(i);
                System.out.println("Removed: " + removeDVD + ", from the library.");
            }
        }
    }

    /**
     * Method which finds a specific DVD from the library based on the DVD title.
     * Handles if the DVS is not in the library.
     */
    private void findDVD() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a DVD title: ");
        String findTitle = in.nextLine();
        boolean found = false;

        for (int i = 0; i < dvdLibrary.size(); i++) {
            if (dvdLibrary.get(i).getTitle().equalsIgnoreCase(findTitle)) {
                System.out.println(dvdLibrary.get(i).toStringFormatted());
                found = true;
            }
        } if (!found){
            System.out.println(findTitle + ", not found in library.");
        }
    }

    /**
     * Method which prints the entire DVD library, as long as the library is not empty.
     */
    private void printLibrary() {
        if (dvdLibrary.isEmpty()){
            System.out.println("Library is empty.");
        } else {
            System.out.println("\n---------------- DVD Library ----------------");
            for (DVD dvd : dvdLibrary) {
                System.out.println(dvd.toStringFormatted());
            }
        }
    }
}
