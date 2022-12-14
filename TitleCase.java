import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.net.*;
public class TitleCase implements Capitalization {
    private String title;
    private boolean afterColon;
    private Set<String> lowercaseWords;
    private Set<String> properNouns;
    
    public TitleCase(String title)
    {
        this.title = title;
        afterColon = false;
        lowercaseWords = new HashSet<String>();
        properNouns = new HashSet<String>();
    }
    /**
     * Set the initial values of the lowercaseWords set using a file 
     * in the current directory.
     */
    public void initializeLowercase() throws FileNotFoundException
    {
        //final File f = new File(TitleCase.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        //System.out.println(f.getParent());
        //File file = new File("C:\\Users\\EMach\\OneDrive\\Desktop\\coding_tingies\\java_code\\Title_Case\\lowercase_words.txt");
        File file = new File("lowercase_words.txt");
        
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext())
        {
            System.out.print(scanner.next() + " ");
        }
        scanner.close();
        /*for(String str : lowercaseWords)
        {
            System.out.println(str);
        }*/
    }
    /**
     * Allows the user to specify which words in the title are proper nouns
     * so that these words can remain as uppercase. The function will repeatedly
     * ask for input from the user until receiving the end loop input, "!!!".
     * Each input is added to a HashSet of proper nouns.
     */
    public void addProperNouns()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter any proper nouns that should remain capitalized.");
        System.out.println("When you are done, input three exclamation marks: !!!");
        boolean validInput = true;
        while (validInput)
        {
            String word = input.next();
            if (word.equals("!!!"))
            {
                validInput = false;
            }
            else
            {
                properNouns.add(word);
            }
        }
        input.close();
        /*for (String blah : properNouns)
        {
            System.out.println(blah);
        }*/
    }
    /**
     * This method should take in a string, modify the string
     * to fit a desired capitalization scheme, and return
     * the modified string.
     * @return the string with a different capitalization format.
     */
    public String changeCapitalization()
    {
        Scanner scanner = new Scanner(title);
        return null;
    }
    /**
     * Modifies a single word so that its first character is uppercase.
     * @param str specifies which word should be modified.
     * @return a new string that starts with an uppercase letter.
     */
    public String uppercaseForm(String str)
    {
        return null;
    }
    /**
     * Modifies a single word so that its first character is lowercase.
     * @param str specifies which word should be modified.
     * @return a new string that starts with a lowercase letter.
     */
    public String lowercaseForm(String str)
    {
        return null;
    }
    
}
