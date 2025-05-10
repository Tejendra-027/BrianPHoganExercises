import java.io.*;
import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Site name: ");
        String siteName = scanner.nextLine();
        
        System.out.print("Author: ");
        String author = scanner.nextLine();
        
        System.out.print("Do you want a folder for JavaScript? (y/n): ");
        String jsFolderResponse = scanner.nextLine().toLowerCase();
        
        System.out.print("Do you want a folder for CSS? (y/n): ");
        String cssFolderResponse = scanner.nextLine().toLowerCase();

        File siteDir = new File(siteName);
        if (!siteDir.exists()) {
            siteDir.mkdir();
            System.out.println("Created ./" + siteName);
        }

        File indexFile = new File(siteDir, "index.html");
        try (PrintWriter writer = new PrintWriter(indexFile)) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html lang=\"en\">");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\">");
            writer.println("<meta name=\"author\" content=\"" + author + "\">");
            writer.println("<title>" + siteName + "</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>Welcome to " + siteName + "</h1>");
            writer.println("</body>");
            writer.println("</html>");
        } catch (IOException e) {
            System.out.println("Error creating index.html: " + e.getMessage());
        }
        System.out.println("Created ./" + siteName + "/index.html");

        if (jsFolderResponse.equals("y")) {
            File jsFolder = new File(siteDir, "js");
            if (!jsFolder.exists()) {
                jsFolder.mkdir();
                System.out.println("Created ./" + siteName + "/js/");
            }
        }

        if (cssFolderResponse.equals("y")) {
            File cssFolder = new File(siteDir, "css");
            if (!cssFolder.exists()) {
                cssFolder.mkdir();
                System.out.println("Created ./" + siteName + "/css/");
            }
        }
    }
}
