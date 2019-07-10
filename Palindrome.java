public class Palindrome {
    public static boolean isPalindrome(String word) {
        String temp = "";

        for(int i = word.length()-1; i >= 0; i--) {
        	temp += word.charAt(i);
        }

        if(temp.equalsIgnoreCase(word))
        	return true;
        else
        	return false;
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}