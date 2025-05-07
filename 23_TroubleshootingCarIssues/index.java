import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Is the car silent when you turn the key? (y/n): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            System.out.print("Are the battery terminals corroded? (y/n): ");
            answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                System.out.println("Clean terminals and try starting again.");
            } else {
                System.out.println("Replace cables and try again.");
            }
        } else {
            System.out.print("Does the car make a clicking noise? (y/n): ");
            answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                System.out.println("Replace the battery.");
            } else {
                System.out.print("Does the car crank up but fail to start? (y/n): ");
                answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    System.out.println("Check spark plug connections.");
                } else {
                    System.out.print("Does the engine start and then die? (y/n): ");
                    answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("y")) {
                        System.out.print("Does your car have fuel injection? (y/n): ");
                        answer = scanner.nextLine();
                        if (answer.equalsIgnoreCase("y")) {
                            System.out.println("Get it in for service.");
                        } else {
                            System.out.println("Check to ensure the choke is opening and closing.");
                        }
                    } else {
                        System.out.println("This should not be possible.");
                    }
                }
            }
        }
    }
}
