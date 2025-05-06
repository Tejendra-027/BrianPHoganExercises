import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double weight, height, bmi;

        
        System.out.print("Enter your weight in pounds: ");
        weight = sc.nextDouble();

      
        System.out.print("Enter your height in inches: ");
        height = sc.nextDouble();

       
        bmi = (weight / (height * height)) * 703;

        
        System.out.println("Your BMI is " + bmi);

        if (bmi >= 18.5 && bmi <= 25) {
            System.out.println("You are within the ideal weight range.");
        } else if (bmi < 18.5) {
            System.out.println("You are underweight. You should see your doctor.");
        } else {
            System.out.println("You are overweight. You should see your doctor.");
        }

    }
}
