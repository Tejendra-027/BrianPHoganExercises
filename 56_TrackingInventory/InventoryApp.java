import java.io.*;
import java.util.*;

public class InventoryApp {

    static class Item {
        String name;
        String serial;
        double value;

        Item(String name, String serial, double value) {
            this.name = name;
            this.serial = serial;
            this.value = value;
        }

        @Override
        public String toString() {
            return name + "," + serial + "," + value;
        }

        String toHtmlRow() {
            return "<tr><td>" + name + "</td><td>" + serial + "</td><td>$" + String.format("%.2f", value) + "</td></tr>";
        }
    }

    static final String INVENTORY_FILE = "inventory.txt";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Item> items = loadInventory();

        while (true) {
            System.out.println("1. Add item");
            System.out.println("2. Export to CSV");
            System.out.println("3. Export to HTML");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Item name: ");
                    String name = sc.nextLine();
                    System.out.print("Serial number: ");
                    String serial = sc.nextLine();
                    System.out.print("Estimated value: ");
                    double value = Double.parseDouble(sc.nextLine());

                    items.add(new Item(name, serial, value));
                    saveInventory(items);
                    break;

                case 2:
                    exportCSV(items);
                    System.out.println("Exported to report.csv");
                    break;

                case 3:
                    exportHTML(items);
                    System.out.println("Exported to report.html");
                    break;

                case 4:
                    System.out.println("Exiting.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static List<Item> loadInventory() throws IOException {
        List<Item> items = new ArrayList<>();
        File file = new File(INVENTORY_FILE);
        if (!file.exists()) return items;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                items.add(new Item(parts[0], parts[1], Double.parseDouble(parts[2])));
            }
        }
        reader.close();
        return items;
    }

    static void saveInventory(List<Item> items) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(INVENTORY_FILE));
        for (Item item : items) {
            writer.println(item);
        }
        writer.close();
    }

    static void exportCSV(List<Item> items) throws IOException {
        PrintWriter writer = new PrintWriter("report.csv");
        writer.println("Name,Serial Number,Value");
        for (Item item : items) {
            writer.println(item.name + "," + item.serial + ",$" + String.format("%.2f", item.value));
        }
        writer.close();
    }

    static void exportHTML(List<Item> items) throws IOException {
        PrintWriter writer = new PrintWriter("report.html");
        writer.println("<html><body>");
        writer.println("<h2>Inventory Report</h2>");
        writer.println("<table border='1'>");
        writer.println("<tr><th>Name</th><th>Serial Number</th><th>Value</th></tr>");
        for (Item item : items) {
            writer.println(item.toHtmlRow());
        }
        writer.println("</table></body></html>");
        writer.close();
    }
}
