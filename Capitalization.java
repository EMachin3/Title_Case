import java.io.FileNotFoundException;

public interface Capitalization {
    /**
     * Set the initial values of the lowercaseWords set using a file 
     * in the current directory.
     */
    public void initializeLowercase() throws FileNotFoundException;
    /**
     * Allows the user to specify which words in the title are proper nouns
     * so that these words can remain as uppercase. The function will repeatedly
     * ask for input from the user until receiving the end loop input, "!!!".
     * Each input is added to a HashSet of proper nouns.
     */
    public void addProperNouns();
    /**
     * This method should take in a string, modify the string
     * to fit a desired capitalization scheme, and return
     * the modified string.
     * @param str specifies the title to modify.
     * @return the string with a different capitalization format.
     */
    public String changeCapitalization();
    /**
     * Modifies a single word so that its first character is uppercase.
     * @param str specifies which word should be modified.
     * @return a new string that starts with an uppercase letter.
     */
    public String uppercaseForm(String str);
    /**
     * Modifies a single word so that its first character is lowercase.
     * @param str specifies which word should be modified.
     * @return a new string that starts with a lowercase letter.
     */
    public String lowercaseForm(String str);

}
