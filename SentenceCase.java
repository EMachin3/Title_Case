import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.net.*;
public class SentenceCase implements Capitalization {
    private String title;
    private boolean afterColon;
    private Set<String> lowercaseWords;
    private Set<String> properNouns;
    
    public SentenceCase(String title)
    {
        this.title = title;
        afterColon = false;
        lowercaseWords = new HashSet<String>();
        properNouns = new HashSet<String>();
        properNouns.add("I");
        properNouns.add("i");
    }
    /**
     * Set the initial values of the lowercaseWords set using a file 
     * in the current directory.
     */
    public void initializeLowercase() throws FileNotFoundException
    {
        File file = new File("lowercase_words.txt");
        
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext())
        {
            lowercaseWords.add(scanner.next());
        }
        scanner.close();

        /*for (String str : lowercaseWords)
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
                lowercaseWords.remove(word);
            }
        }
        input.close();
    }
    /**
     * This method should take in a string, modify the string
     * to fit a desired capitalization scheme, and return
     * the modified string. This implementation should convert
     * the title field to sentence case.
     * @return the string with a different capitalization format.
     */
    public String changeCapitalization()
    {
        Scanner scanner = new Scanner(title);
        String newTitle = "";
        if (scanner.hasNext())
        {
            String nextWord = scanner.next();
            newTitle += this.uppercaseForm(nextWord) + " ";
            if (nextWord.endsWith(":"))
            {
                afterColon = true;
            }
        }
        else
        {
            scanner.close();
            return "";
        }
        while (scanner.hasNext())
        {
            String nextWord = scanner.next();
            if (afterColon)
            {
                newTitle += this.uppercaseForm(nextWord) + " ";
                afterColon = nextWord.endsWith(":");
            }
            else if (properNouns.contains(nextWord.replaceAll("\\p{Punct}","")) || 
                properNouns.contains(nextWord.replaceAll("\\p{Punct}","").toLowerCase())
                || properNouns.contains(this.uppercaseForm(nextWord.replaceAll("\\p{Punct}",""))))
            {
                newTitle += this.uppercaseForm(nextWord) + " ";
                afterColon = nextWord.endsWith(":");
            }
            else
            {
                newTitle += this.lowercaseForm(nextWord) + " ";
                afterColon = nextWord.endsWith(":");
            }
                //boolean notPronoun = true;
                /*for (String str : properNouns)
                {
                    if (nextWord.contains(str) || nextWord.toLowerCase().contains(str)) 
                    //in case if nextWord is followed by punctuation
                    {
                        newTitle += this.uppercaseForm(nextWord) + " ";
                        afterColon = nextWord.endsWith(":");
                        notPronoun = false;
                    }
                }*/
                //if (notPronoun)
                //{
                    //newTitle += this.lowercaseForm(nextWord) + " ";
                    //afterColon = nextWord.endsWith(":");
                //}
            /*if (afterColon && nextWord.endsWith(":"))
            {
                newTitle += this.uppercaseForm(nextWord) + " ";
            }
            else if (afterColon)
            {
                newTitle += this.uppercaseForm(nextWord) + " ";
                afterColon = false;
            }
            if (nextWord.endsWith(":"))
            {
                afterColon = true;
            }*/
        }
        scanner.close();
        return newTitle;
    }
    /**
     * Modifies a single word so that its first character is uppercase.
     * @param str specifies which word should be modified.
     * @return a new string that starts with an uppercase letter.
     */
    public String uppercaseForm(String str)
    {
        if (str.length() < 2)
        {
            return str.substring(0, 1).toUpperCase();
        }
        else
        {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }
    /**
     * Modifies a single word so that its first character is lowercase.
     * @param str specifies which word should be modified.
     * @return a new string that starts with a lowercase letter.
     */
    public String lowercaseForm(String str)
    {
        if (str.length() < 2)
        {
            return str.substring(0, 1).toLowerCase();
        }
        else
        {
            return str.substring(0, 1).toLowerCase() + str.substring(1);
        }
    }
}
