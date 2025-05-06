import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the order amount? ");
        double orderAmount = sc.nextDouble();

        System.out.print("What is the state? ");
        String state = sc.next();

        double tax = 0;
        double total = orderAmount;

        if (state.equals("WI")) { // .equal is to compare two string
            tax = orderAmount * 0.055;
            total = orderAmount + tax;
        }

        tax = (tax * 100) / 100;
        total = (total * 100) / 100;

        if (state.equals("WI")) {
            System.out.println("The subtotal is $" + orderAmount + ".");
            System.out.println("The tax is $" + tax + ".");
            System.out.println("The total is $" + total + ".");
        } else {
            System.out.println("The total is $" + total + ".");
        }

    }
}

