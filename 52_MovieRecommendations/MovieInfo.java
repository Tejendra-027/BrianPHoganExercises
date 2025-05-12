import java.net.*;
import java.io.*;
import java.util.Scanner;

public class MovieInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter movie name: ");
        String title = sc.nextLine();

        try {
            String apiKey = "61faa3ca"; // Your OMDb API key
            String urlStr = "http://www.omdbapi.com/?t=" + URLEncoder.encode(title, "UTF-8") + "&apikey=" + apiKey;
            URL url = URI.create(urlStr).toURL(); // Avoid deprecated constructor

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line, json = "";
            while ((line = br.readLine()) != null) json += line;
            br.close();

            System.out.println("Title: " + get(json, "Title"));
            System.out.println("Year: " + get(json, "Year"));
            System.out.println("Rating: " + get(json, "Rated"));
            System.out.println("Runtime: " + get(json, "Runtime"));
            System.out.println("Description: " + get(json, "Plot"));

            String scoreStr = get(json, "Rotten Tomatoes");
            if (!scoreStr.equals("N/A")) {
                int score = Integer.parseInt(scoreStr.replace("%", ""));
                if (score >= 80)
                    System.out.println("You should watch this movie right now!");
                else if (score < 50)
                    System.out.println("Avoid this movie at all costs.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static String get(String json, String key) {
        if (key.equals("Rotten Tomatoes")) {
            int idx = json.indexOf("Rotten Tomatoes");
            if (idx == -1) return "N/A";
            int percent = json.indexOf("%", idx);
            if (percent == -1) return "N/A";
            int start = json.lastIndexOf(":", percent) + 2;
            return json.substring(start, percent + 1).replace("\"", "");
        }
        int i = json.indexOf("\"" + key + "\":");
        if (i == -1) return "N/A";
        int start = json.indexOf("\"", i + key.length() + 3) + 1;
        int end = json.indexOf("\"", start);
        return json.substring(start, end);
    }
}
