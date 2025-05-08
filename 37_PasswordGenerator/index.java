import java.util.*;

public class index {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("What's the minimum length? ");
        int minLength = input.nextInt();

        System.out.print("How many special characters? ");
        int specialCount = input.nextInt();

        System.out.print("How many numbers? ");
        int numberCount = input.nextInt();

        String letters = "abcdefghijklmnopqrstuvwxyz";
        String specials = "!@#$%^&*";
        String numbers = "0123456789";

        List<Character> passwordChars = new ArrayList<>();

        for (int i = 0; i < specialCount; i++) {
            passwordChars.add(specials.charAt(rand.nextInt(specials.length())));
        }

        for (int i = 0; i < numberCount; i++) {
            passwordChars.add(numbers.charAt(rand.nextInt(numbers.length())));
        }

        while (passwordChars.size() < minLength) {
            passwordChars.add(letters.charAt(rand.nextInt(letters.length())));
        }

        Collections.shuffle(passwordChars);

        StringBuilder password = new StringBuilder();
        for (char c : passwordChars) {
            password.append(c);
        }

        System.out.println("Your password is");
        System.out.println(password.toString());
    }
}
