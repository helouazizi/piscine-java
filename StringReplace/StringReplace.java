public class StringReplace {
    public static String replace(String s, String target, String replacement) {
        // your code here

        if (s == null || target == null || replacement == null) {
            return null;
        }
        return s.replace(target, replacement);

    }

    public static String replace(String s, char target, char replacement) {
        // your code here

        if (s == null) {
            return null;
        }
        return s.replace(target, replacement);

    }
}