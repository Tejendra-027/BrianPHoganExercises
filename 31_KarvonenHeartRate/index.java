import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int age = 0;
        int restingHeartRate = 0;

        while (age <= 0) {
            System.out.print("Enter your age: ");
            if (input.hasNextInt()) {
                age = input.nextInt();
                if (age <= 0) {
                    System.out.println("Sorry. That's not a valid input.");
                }
            } else {
                System.out.println("Sorry. That's not a valid input.");
                input.next();
            }
        }

        while (restingHeartRate <= 0) {
            System.out.print("Enter your resting heart rate: ");
            if (input.hasNextInt()) {
                restingHeartRate = input.nextInt();
                if (restingHeartRate <= 0) {
                    System.out.println("Sorry. That's not a valid input.");
                }
            } else {
                System.out.println("Sorry. That's not a valid input.");
                input.next();
            }
        }

        System.out.println();
        System.out.println("Resting Pulse: " + restingHeartRate + "    Age: " + age);
        System.out.println("Intensity | Rate");
        System.out.println("----------|--------");

        for (int i = 55; i <= 95; i += 5) {
            double targetRate = (((220 - age) - restingHeartRate) * (i / 100.0)) + restingHeartRate;
            System.out.printf("%d%%        | %d bpm\n", i, Math.round(targetRate));
        }
    }
}
