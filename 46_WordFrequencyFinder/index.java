import java.io.*;
import java.util.*;

public class index {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            Map<String, Integer> wordCount = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[^a-z]", "");
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            reader.close();

            wordCount.entrySet().stream()
                    .sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + "*".repeat(entry.getValue())));

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
