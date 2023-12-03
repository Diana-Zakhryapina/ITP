package Lab1;

public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }
    public static String reverseString(String input) {
        String s = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            s += input.charAt(i);
        }
        return s;
    }
    public static boolean isPalindrome(String s) {
        String reverse = reverseString(s);
        return s.equals(reverse);
    }
}