import java.util.*;
public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the principal: ");
        double principal = sc.nextDouble();

        System.out.print("Enter the rate of interest: ");
        double rate = sc.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = sc.nextInt();

        double amount = principal * (1 + (rate / 100) * years);
        double roundedAmount = (amount * 100) / 100;

        System.out.println("After " + years + " years at " + rate + "%, the investment will be worth $" + roundedAmount);

        
    }
}
