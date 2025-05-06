import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your gender (M/F): ");
        String gender = sc.next();
        double r = 0;

        if (gender.equalsIgnoreCase("M")) {
            r = 0.73;
        } else if (gender.equalsIgnoreCase("F")) {
            r = 0.66;
        } else {
            System.out.println("Invalid gender input.");
        }

        System.out.print("Enter your weight : ");
        double weight = sc.nextDouble();

        System.out.print("Enter number of drinks: ");
        int drinks = sc.nextInt();

        System.out.print("Enter alcohol per drink : ");
        double alcohol = sc.nextDouble();

        System.out.print("Enter hours since last drink: ");
        double hours = sc.nextDouble();

        double A = drinks * alcohol;
        double bac = (A * 5.14 / (weight * r)) - 0.015 * hours;
        bac = (bac * 1000.0) / 1000.0;

        System.out.println("Your BAC is " + bac);

        if (bac >= 0.08) {
            System.out.println("It is not legal for you to drive.");
        } else {
            System.out.println("It is legal for you to drive.");
        }

       
    }
}
