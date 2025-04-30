import java.util.*;
public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the price of item 1: ");
        double price1 = sc.nextDouble();
        System.out.print("Enter the quantity of item 1: ");
        int qty1 = sc.nextInt();

        System.out.print("Enter the price of item 2: ");
        double price2 = sc.nextDouble();
        System.out.print("Enter the quantity of item 2: ");
        int qty2 = sc.nextInt();

        System.out.print("Enter the price of item 3: ");
        double price3 = sc.nextDouble();
        System.out.print("Enter the quantity of item 3: ");
        int qty3 = sc.nextInt();

        // === Calculations ===
        double subtotal = (price1 * qty1) + (price2 * qty2) + (price3 * qty3);
        double tax = subtotal * 0.055;
        double total = subtotal + tax;

        // === Output ===
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("Tax: $%.2f\n", tax);
        System.out.printf("Total: $%.2f\n", total);
    }
}
