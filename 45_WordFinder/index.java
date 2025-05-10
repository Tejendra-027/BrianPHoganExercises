import java.io.*;
import java.util.Scanner;

public class index {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the input file name: ");
        String inputFileName = scanner.nextLine();
        System.out.print("Enter the output file name: ");
        String outputFileName = scanner.nextLine();

        
        try {
            String content = readFile(inputFileName);
            String modifiedContent = content.replaceAll("\\butilize\\b", "use");

            
            writeFile(outputFileName, modifiedContent);

            System.out.println("The modified content has been written to " + outputFileName);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        scanner.close();
    }

    
    private static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }

    
    private static void writeFile(String fileName, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(content);
        writer.close();
    }
}
