import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the number of the month: ");
        int monthNumber = scanner.nextInt();

        String result;
        switch (monthNumber) {
            case 1: result = "The name of the month is January."; break;
            case 2: result = "The name of the month is February."; break;
            case 3: result = "The name of the month is March."; break;
            case 4: result = "The name of the month is April."; break;
            case 5: result = "The name of the month is May."; break;
            case 6: result = "The name of the month is June."; break;
            case 7: result = "The name of the month is July."; break;
            case 8: result = "The name of the month is August."; break;
            case 9: result = "The name of the month is September."; break;
            case 10: result = "The name of the month is October."; break;
            case 11: result = "The name of the month is November."; break;
            case 12: result = "The name of the month is December."; break;
            default: result = "Error: Invalid month number. Please enter a number from 1 to 12.";
        }

        System.out.println(result);
    }
}

