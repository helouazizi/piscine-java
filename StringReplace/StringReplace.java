public class StringReplace {
    public static String replace(String s, String target, String replacement) {
        // your code here

        if (s == null) {
            return new String();
        }
        return s.replaceAll(target, replacement);

    }
}