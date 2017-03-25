package Utility.UtilityMethods;

/**
 * Created by Cheech on 3/25/2017.
 */
public class UtilityMethods {

    /**
     * Pre-Condition - the text has the correct formatting.
     *
     * @param text
     * @return
     */
    public static String[] textParser(String text) {
        if (text.contains("cost")) {
            String[] textWords = text.split(" ");
            return textWords;
        }
        return null;
    }
}
