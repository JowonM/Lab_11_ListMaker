import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
        // A Static ArrayList to hold Data//
    static ArrayList<String> list = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
            //Start of helper methods used//

        //a boolean method to see if one would like to exit//
    private static Boolean exitLoop()
    {
        //Use of safeInput method//
        boolean exitLoop = SafeInput.getYNConfirm(in,"Are you sure? Y or N.");
        return exitLoop;
    }
        //A simple Static method to delete a determined value based off of its number in the list//
    private static void deleteElement()
    {
        Scanner sc = new Scanner(System.in);
        String message = "Enter item number to remove";
        if(list.isEmpty()) {
            System.out.println("         List is Empty         ");
            return;
        }
        //Use of SafeInput method//
        int index = SafeInput.getRangedInt(sc, message,1, list.size());
        list.remove(index-1);
    }
        //A simple Static method to add a determined value//
    private static void addElement()
    {
        Scanner sc = new Scanner(System.in);
        String item = SafeInput.getNonZeroLenString(sc, "Enter item to add");
        list.add(item);

    }
        //A static method to print an element in the list//
    private static void print() {
        if (list.isEmpty()) {
            System.out.println("This list is empty...");
        } else {
            System.out.println("This is your list:");
            numberedList();
        }
    }
        //a Static method that will print the updated list with numbering//
    private static void numberedList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

            //The main method used to make use of the methods//
    public static void main(String[] args)
    {
            //A static sting to use as a menu for inputs//
        final String menu = "/ A is to Add / D is to Delete / P is to Print / Q is to Quit /";
            //a boolean value to be used in show if one is done using the loop//
        boolean finished = false;
            //a String variable for the users input//
        String choice = "";


            //The do-while and switch that handles the brunt of the program//
        do
        {
            print();
            choice = SafeInput.getRegExString(in, menu, "[AaDdPpQp]");
            choice = choice.toUpperCase();

            //The switch loop that will take in a users input//

            switch (choice)
            {
                case "A":
                    addElement();
                    break;
                case "D":
                    deleteElement();
                    break;
                case "P":
                    print();
                    break;
                case "Q":
                    finished = exitLoop();
                    break;
            }
        }
        while (!finished);
    }
    }
