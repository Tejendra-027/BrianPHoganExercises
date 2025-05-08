import java.util.ArrayList;
import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        String userInput;

        while (true) {
            System.out.print("Enter a number: ");
            userInput = input.nextLine();

            if (userInput.equalsIgnoreCase("done")) {
                break;
            }

            if (isNumber(userInput)) {
                numbers.add(Integer.parseInt(userInput));
            } else {
                System.out.println("Invalid input. Please enter a number or 'done'.");
            }
        }

        if (numbers.size() == 0) {
            System.out.println("No numbers were entered.");
            return;
        }

        System.out.print("Numbers: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i != numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        double sum = 0;
        int min = numbers.get(0);
        int max = numbers.get(0);

        for (int n : numbers) {
            sum += n;
            if (n < min) min = n;
            if (n > max) max = n;
        }

        double average = sum / numbers.size();

        double squaredDiffSum = 0;
        for (int n : numbers) {
            squaredDiffSum += Math.pow(n - average, 2);
        }
        double stdDev = Math.sqrt(squaredDiffSum / numbers.size());

        System.out.println("The average is " + (int)average + ".");
        System.out.println("The minimum is " + min + ".");
        System.out.println("The maximum is " + max + ".");
        System.out.printf("The standard deviation is %.2f.\n", stdDev);
    }

    public static boolean isNumber(String s) {
        if (s == null || s.equals("")) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
