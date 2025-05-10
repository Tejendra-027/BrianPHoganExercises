import java.util.*;

public class index {
    public static void main(String[] args) {
        List<Map<String, String>> employees = new ArrayList<>();

        employees.add(createEmployee("John", "Johnson", "Manager", "2016-12-31"));
        employees.add(createEmployee("Tou", "Xiong", "Software Engineer", "2016-10-05"));
        employees.add(createEmployee("Michaela", "Michaelson", "District Manager", "2015-12-19"));
        employees.add(createEmployee("Jake", "Jacobson", "Programmer", ""));
        employees.add(createEmployee("Jacquelyn", "Jackson", "DBA", ""));
        employees.add(createEmployee("Sally", "Weber", "Web Developer", "2015-12-18"));

        // Sort by last name
        employees.sort(Comparator.comparing(e -> e.get("lastName")));

        // Print header
        System.out.printf("%-20s | %-18s | %-15s%n", "Name", "Position", "Separation Date");
        System.out.println("---------------------|--------------------|----------------");

        // Print each employee
        for (Map<String, String> emp : employees) {
            String name = emp.get("firstName") + " " + emp.get("lastName");
            String position = emp.get("position");
            String sepDate = emp.get("separationDate");
            System.out.printf("%-20s | %-18s | %-15s%n", name, position, sepDate);
        }
    }

    // Helper method to create employee entries
    public static Map<String, String> createEmployee(String firstName, String lastName, String position, String separationDate) {
        Map<String, String> employee = new HashMap<>();
        employee.put("firstName", firstName);
        employee.put("lastName", lastName);
        employee.put("position", position);
        employee.put("separationDate", separationDate);
        return employee;
    }
}
