import java.util.Arrays;
import java.util.Scanner;

public class index {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter two strings and I'll tell you if they are anagrams:");
        System.out.print("Enter the first string: ");
        String first = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String second = scanner.nextLine();

        if (isAnagram(first, second)) {
            System.out.printf("\"%s\" and \"%s\" are anagrams.%n", first, second);
        } else {
            System.out.printf("\"%s\" and \"%s\" are not anagrams.%n", first, second);
        }
    }

    
    public static boolean isAnagram(String word1, String word2) {
       
        if (word1.length() != word2.length()) {
            return false;
        }

        
        char[] chars1 = word1.toLowerCase().toCharArray();
        char[] chars2 = word2.toLowerCase().toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }
}
