package by.serhel.contentsgeneretor.validator;

public class Validator {
    public static final String MD_TITLE_REGEX = "\\s*#+.*\\s*";

    public static boolean isTitle(String line){
        boolean matches = line.matches(MD_TITLE_REGEX);
        return matches;
    }
}
