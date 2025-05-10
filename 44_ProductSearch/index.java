import java.io.*;
import java.util.Scanner;

public class index {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        String filePath = "products.txt";
        String[] products = readFile(filePath);

        while (true) {
            System.out.print("What is the product name? ");
            String productName = scanner.nextLine().trim();

            boolean productFound = false;

           
            for (String product : products) {
                String[] details = product.split(",");
                String name = details[0];
                double price = Double.parseDouble(details[1]);
                int quantity = Integer.parseInt(details[2]);

                if (name.equalsIgnoreCase(productName)) {
                    System.out.println("Name: " + name);
                    System.out.println("Price: $" + price);
                    System.out.println("Quantity on hand: " + quantity);
                    productFound = true;
                    break;
                }
            }

            if (!productFound) {
                System.out.println("Sorry, that product was not found in our inventory.");
            } else {
                break;
            }
        }

        scanner.close();
    }

    
    private static String[] readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return content.toString().split("\n");
    }
}
