import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String correctPassword = "abc$123";  // Known password

        System.out.print("What is the password? ");
        String enteredPassword = sc.nextLine();

        if (enteredPassword.equals(correctPassword)) {
            System.out.println("Welcome!");
        } else {
            System.out.println("I don't know you.");
        }

    }
}

