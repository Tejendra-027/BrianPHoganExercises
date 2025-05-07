import java.util.Scanner;

public class index {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter the ZIP code: ");
        String zip = scanner.nextLine();

        System.out.print("Enter an employee ID: ");
        String id = scanner.nextLine();

        String result = validateInput(firstName, lastName, zip, id);
        System.out.println(result);
    }

    public static String validateInput(String firstName, String lastName, String zip, String id) {
        String errors = "";

        if (firstName.length() == 0) {
            errors += "The first name must be filled in.\n";
        } else if (firstName.length() < 2) {
            errors += "\"" + firstName + "\" is not a valid first name. It is too short.\n";
        }

        if (lastName.length() == 0) {
            errors += "The last name must be filled in.\n";
        } else if (lastName.length() < 2) {
            errors += "\"" + lastName + "\" is not a valid last name. It is too short.\n";
        }

        if (!isNumber(zip)) {
            errors += "The ZIP code must be numeric.\n";
        }

        if (!isValidId(id)) {
            errors += id + " is not a valid ID.\n";
        }

        if (errors.equals("")) {
            return "There were no errors found.";
        } else {
            return errors;
        }
    }

    public static boolean isNumber(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidId(String id) {
        if (id.length() != 7) return false;
        if (!Character.isLetter(id.charAt(0)) || !Character.isLetter(id.charAt(1))) return false;
        if (id.charAt(2) != '-') return false;

        for (int i = 3; i < 7; i++) {
            if (!Character.isDigit(id.charAt(i))) return false;
        }
        return true;
    }
}
