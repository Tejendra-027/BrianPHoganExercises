import java.util.Scanner;

public class index {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your balance? ");
        double balance = scanner.nextDouble();

        System.out.print("What is the APR on the card (as a percent)? ");
        double aprPercent = scanner.nextDouble();

        System.out.print("What is the monthly payment you can make? ");
        double monthlyPayment = scanner.nextDouble();

        int months = calculateMonthsUntilPaidOff(balance, aprPercent, monthlyPayment);

        System.out.println("It will take you " + months + " months to pay off this card.");
    }

    
    public static int calculateMonthsUntilPaidOff(double balance, double aprPercent, double monthlyPayment) {
        double dailyRate = (aprPercent / 100) / 365;

        double numerator = Math.log(1 + (balance / monthlyPayment) * (1 - Math.pow(1 + dailyRate, 30)));
        double denominator = Math.log(1 + dailyRate);

        double months = -(1.0 / 30.0) * (numerator / denominator);

        return (int) Math.ceil(months); 
    }
}
