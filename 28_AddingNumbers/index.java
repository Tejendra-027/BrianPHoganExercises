import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();
            total = total + number;
        }

        System.out.println("The total is " + total + ".");
    }
}
