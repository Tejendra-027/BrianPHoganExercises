import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter the third number: ");
        int num3 = scanner.nextInt();

        
        if (num1 == num2 || num1 == num3 || num2 == num3) {
            System.out.println("Numbers are not all different. Exiting program.");
            return; 
        }

        
        int largest = num1; 
        if (num2 > largest) {
            largest = num2;
        }
        if (num3 > largest) {
            largest = num3;
        }

        
        System.out.println("The largest number is " + largest + ".");
    }
}
