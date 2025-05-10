import java.io.*;
import java.util.*;

public class index {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("names.txt"))) {
            while (scanner.hasNextLine()) {
                names.add(scanner.nextLine().trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        Collections.sort(names);

        try (PrintWriter writer = new PrintWriter("sorted_names.txt")) {
            writer.println("Total of " + names.size() + " names");
            writer.println("-----------------");
            for (String name : names) {
                writer.println(name);
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}

