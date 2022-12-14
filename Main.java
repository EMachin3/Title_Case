import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        Capitalization changeTitle = null; //stores object that will modify title
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title that you want to modify.");
        String title = input.nextLine();
        System.out.println("Do you want to use title case or sentence case?");
        boolean validInput = true;
        int caseType = -1;
        while (validInput)
        {
            System.out.println("Enter 1 for title case or 2 for sentence case.");
            caseType = input.nextInt();
            if (caseType == 1)
            {
                changeTitle = new TitleCase(title);
                validInput = false;
                //changeTitle.initializeLowercase();
            }
            else if (caseType == 2)
            {
                changeTitle = new SentenceCase(title);
                validInput = false;
                //changeTitle.initializeLowercase();
            }
            else
            {
                System.out.println("Invalid input received.");
            }
        }
        changeTitle.addProperNouns();
        String newTitle = changeTitle.changeCapitalization();
        System.out.println("Here is your new title:");
        System.out.println(newTitle);
    }
}
