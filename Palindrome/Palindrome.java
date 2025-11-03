public class Palindrome {
    public static boolean isPalindrome(String s) {
        // your code here
        if (s == null) {
            return false ;
        }
        String reversed = new StringBuilder(s).reverse().toString();
         return s.toLowerCase().equals(reversed.toLowerCase());

    }
}