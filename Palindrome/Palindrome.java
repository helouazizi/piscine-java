public class Palindrome {
    public static boolean isPalindrome(String s) {
        // your code here
        String reversed = new StringBuilder(s).reverse().toString();
        s.equals(reversed);

    }
}