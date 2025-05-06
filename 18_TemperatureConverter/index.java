import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Press C to convert from Fahrenheit to Celsius.");
        System.out.println("Press F to convert from Celsius to Fahrenheit.");
        System.out.print("Your choice: ");
        String choice = sc.next();

        double temperature;
        double convertedTemperature;

        if (choice.equalsIgnoreCase("C")) {
            System.out.print("Please enter the temperature in Fahrenheit: ");
            temperature = sc.nextDouble();
            convertedTemperature = (temperature - 32) * 5 / 9;
            System.out.println("The temperature in Celsius is " + convertedTemperature + ".");
        } else if (choice.equalsIgnoreCase("F")) {
            System.out.print("Please enter the temperature in Celsius: ");
            temperature = sc.nextDouble();
            convertedTemperature = (temperature * 9 / 5) + 32;
            System.out.println("The temperature in Fahrenheit is " + convertedTemperature + ".");
        } else {
            System.out.println("Invalid choice. Please enter C or F.");
        }

    }
}
