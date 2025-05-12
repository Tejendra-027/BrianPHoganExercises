import java.net.*;
import java.io.*;
import java.util.Scanner;

public class MyNotes {
    private static final String API_KEY = "YOUR_FIREBASE_API_KEY"; 
    private static final String DATABASE_URL = "https://your-database-name.firebaseio.com/notes.json?auth=" + API_KEY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (args.length == 0) {
            System.out.println("Usage: mynotes new <note> | mynotes show");
            return;
        }

        if (args[0].equals("new") && args.length > 1) {
            String note = String.join(" ", args, 1, args.length);
            saveNote(note);
        } else if (args[0].equals("show")) {
            showNotes();
        } else {
            System.out.println("Invalid command");
        }
    }

    private static void saveNote(String note) {
        String timestamp = System.currentTimeMillis() / 1000 + ""; 
        String json = "{\"" + timestamp + "\":{\"note\":\"" + note + "\"}}";

        try {
            URL url = new URL(DATABASE_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PATCH");
            conn.setDoOutput(true);
            conn.getOutputStream().write(json.getBytes("UTF-8"));
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Your note was saved.");
            } else {
                System.out.println("Failed to save note.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void showNotes() {
        try {
            URL url = new URL(DATABASE_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line, json = "";
            while ((line = br.readLine()) != null) json += line;
            br.close();
            System.out.println("Notes: " + json);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
