import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double rate = 0;

        while (true) {
            System.out.print("What is the rate of return? ");
            if (scanner.hasNextDouble()) {
                rate = scanner.nextDouble();
                if (rate == 0) {
                    System.out.println("Sorry. That's not a valid input.");
                } else {
                    break;
                }
            } else {
                System.out.println("Sorry. That's not a valid input.");
                scanner.next();
            }
        }

        int years = (int)(72 / rate);
        System.out.println("It will take " + years + " years to double your initial investment.");
    }
}
