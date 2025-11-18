import java.util.regex.Pattern;

public class RegexMatch {

    public static boolean containsOnlyAlpha(String s) {
        return Pattern.matches("[a-zA-Z]+", s);
    }

    public static boolean startWithLetterAndEndWithNumber(String s) {
        return Pattern.matches("^[a-zA-Z].*\\d+$", s);
    }

    public static boolean containsAtLeast3SuccessiveA(String s) {
        return Pattern.matches(".*AAA.*", s);
    }
}
