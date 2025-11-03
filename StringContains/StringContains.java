public class StringContains {
    public static boolean isStringContainedIn(String subString, String s) {
        // your code here
        if (s == null) {
            return false ;
        }
        return s.contains(subString);
    }
}
