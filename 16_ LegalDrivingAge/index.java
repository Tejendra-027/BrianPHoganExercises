import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("What is your age? ");
        int age = sc.nextInt();
        String message;
        if (age >= 16) {
            message = "You are old enough to legally drive.";
        } else {
            message = "You are not old enough to legally drive.";
        }
        System.out.println(message);
    }
}
