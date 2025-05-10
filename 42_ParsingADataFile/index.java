import java.io.*;
import java.util.*;

public class index {
    public static void main(String[] args) {
        List<String[]> records = new ArrayList<>();
        String filePath = "data.csv"; 

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                records.add(fields);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        
        int maxLastNameLength = "Last".length();
        int maxFirstNameLength = "First".length();
        int maxSalaryLength = "Salary".length();

        for (String[] record : records) {
            maxLastNameLength = Math.max(maxLastNameLength, record[0].length());
            maxFirstNameLength = Math.max(maxFirstNameLength, record[1].length());
            maxSalaryLength = Math.max(maxSalaryLength, record[2].length());
        }

        
        System.out.printf("%-" + (maxLastNameLength + 1) + "s%-" + (maxFirstNameLength + 1) + "s%-" + (maxSalaryLength + 1) + "s%n",
                "Last", "First", "Salary");
        System.out.println("-".repeat(maxLastNameLength + maxFirstNameLength + maxSalaryLength + 3));

        
        for (String[] record : records) {
            System.out.printf("%-" + (maxLastNameLength + 1) + "s%-" + (maxFirstNameLength + 1) + "s%-" + (maxSalaryLength + 1) + "s%n",
                    record[0], record[1], record[2]);
        }
    }
}
