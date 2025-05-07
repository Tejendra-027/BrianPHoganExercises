import java.util.Scanner;

public class index {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int strength = passwordValidator(password);

        String message;
        switch (strength) {
            case 1:
                message = "very weak";
                break;
            case 2:
                message = "weak";
                break;
            case 3:
                message = "strong";
                break;
            case 4:
                message = "very strong";
                break;
            default:
                message = "of unknown strength";
        }

        System.out.printf("The password '%s' is a %s password.%n", password, message);
    }


    public static int passwordValidator(String password) {
        boolean hasLetter = password.matches(".*[a-zA-Z].*");
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
        int length = password.length();

        if (length < 8) {
            if (password.matches("\\d+")) {
                return 1; 
            } else if (password.matches("[a-zA-Z]+")) {
                return 2; 
            }
        } else {
            if (hasLetter && hasNumber && hasSpecial) {
                return 4; 
            } else if (hasLetter && hasNumber) {
                return 3; 
            }
        }
        return 0; 
    }
}

