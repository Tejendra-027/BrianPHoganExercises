import java.util.*;

public class index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Map<String, String>> employees = new ArrayList<>();

        employees.add(createEmployee("John", "Johnson", "Manager", "2016-12-31"));
        employees.add(createEmployee("Tou", "Xiong", "Software Engineer", "2016-10-05"));
        employees.add(createEmployee("Michaela", "Michaelson", "District Manager", "2015-12-19"));
        employees.add(createEmployee("Jake", "Jacobson", "Programmer", ""));
        employees.add(createEmployee("Jacquelyn", "Jackson", "DBA", ""));
        employees.add(createEmployee("Sally", "Weber", "Web Developer", "2015-12-18"));

        System.out.print("Enter a search string: ");
        String search = scanner.nextLine().toLowerCase();

        System.out.println("Results:");
        System.out.printf("%-20s | %-18s | %-15s%n", "Name", "Position", "Separation Date");
        System.out.println("---------------------|--------------------|----------------");

        for (Map<String, String> emp : employees) {
            String first = emp.get("firstName").toLowerCase();
            String last = emp.get("lastName").toLowerCase();
            if (first.contains(search) || last.contains(search)) {
                String name = emp.get("firstName") + " " + emp.get("lastName");
                String position = emp.get("position");
                String date = emp.get("separationDate");
                System.out.printf("%-20s | %-18s | %-15s%n", name, position, date);
            }
        }
    }

    public static Map<String, String> createEmployee(String firstName, String lastName, String position, String separationDate) {
        Map<String, String> emp = new HashMap<>();
        emp.put("firstName", firstName);
        emp.put("lastName", lastName);
        emp.put("position", position);
        emp.put("separationDate", separationDate);
        return emp;
    }
}
