import java.util.ArrayList;
import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<String> employees = new ArrayList<>();
        employees.add("John Smith");
        employees.add("Jackie Jackson");
        employees.add("Chris Jones");
        employees.add("Amanda Cullen");
        employees.add("Jeremy Goodwin");

        System.out.println("There are " + employees.size() + " employees:");
        for (String name : employees) {
            System.out.println(name);
        }

        System.out.print("\nEnter an employee name to remove: ");
        String nameToRemove = input.nextLine();

        employees.remove(nameToRemove);

        System.out.println("\nThere are " + employees.size() + " employees:");
        for (String name : employees) {
            System.out.println(name);
        }
    }
}
