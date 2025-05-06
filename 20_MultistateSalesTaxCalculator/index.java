import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the order amount? ");
        double orderAmount = sc.nextDouble();

        System.out.print("What state do you live in? ");
        String state = sc.next();

        double tax = 0;
        double total = orderAmount;

        if (state.equalsIgnoreCase("Wisconsin")) {
            System.out.print("What county do you live in? ");
            String county = sc.next();

            tax = orderAmount * 0.05;

            if (county.equalsIgnoreCase("Eau Claire")) {
                tax += orderAmount * 0.005;
            } else if (county.equalsIgnoreCase("Dunn")) {
                tax += orderAmount * 0.004;
            }

            total = orderAmount + tax;
        } else if (state.equalsIgnoreCase("Illinois")) {
            tax = orderAmount * 0.08;
            total = orderAmount + tax;
        }

        if (state.equalsIgnoreCase("Wisconsin") || state.equalsIgnoreCase("Illinois")) {
            System.out.println("The tax is $" + (tax * 100.0) / 100.0);
            System.out.println("The total is $" + (total * 100.0) / 100.0);
        } else {
            System.out.println("The total is $" + (total * 100.0) / 100.0);
        }

    }
}
