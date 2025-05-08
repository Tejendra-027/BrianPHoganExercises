import java.util.Scanner;
import java.util.Random;

public class index {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        String playAgain = "y";

        System.out.println("Let's play Guess the Number.");

        while (playAgain.equals("y")) {
            int max = 0;

            System.out.print("Pick a difficulty level (1, 2, or 3): ");
            String level = input.nextLine();

            if (level.equals("1")) {
                max = 10;
            } else if (level.equals("2")) {
                max = 100;
            } else if (level.equals("3")) {
                max = 1000;
            } else {
                System.out.println("Invalid choice.");
                continue;
            }

            int number = random.nextInt(max) + 1;
            int guesses = 0;
            boolean correct = false;

            System.out.print("I have my number. What's your guess? ");

            while (!correct) {
                String guessText = input.nextLine();
                guesses++;

                if (!isNumber(guessText)) {
                    System.out.print("That's not a number. Guess again: ");
                    continue;
                }

                int guess = Integer.parseInt(guessText);

                if (guess < number) {
                    System.out.print("Too low. Guess again: ");
                } else if (guess > number) {
                    System.out.print("Too high. Guess again: ");
                } else {
                    System.out.println("You got it in " + guesses + " guesses!");
                    correct = true;
                }
            }

            System.out.print("Play again? (y/n): ");
            playAgain = input.nextLine();
        }

        System.out.println("Goodbye!");
    }

    public static boolean isNumber(String s) {
        if (s == null || s.equals("")) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}
