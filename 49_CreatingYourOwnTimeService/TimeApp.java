import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeApp {

    public static class TimeServer {
        public static void main(String[] args) throws IOException {
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext("/time", (HttpExchange exchange) -> {
                String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                String response = currentTime;
                exchange.getResponseHeaders().set("Content-Type", "text/plain");
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            });
            server.setExecutor(null);
            System.out.println("Server running at http://localhost:8000/time");
            server.start();
        }
    }

    public static class TimeClient {
        public static void main(String[] args) {
            try {
                URI uri = new URI("http://localhost:8000/time");
                URL url = uri.toURL();
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String response = in.readLine();
                in.close();

                String[] parts = response.split(" ");
                String time = parts[1];
                String date = parts[0];

                System.out.println("The current time is " + time + " UTC " + formatDate(date));
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        private static String formatDate(String date) {
            String[] parts = date.split("-");
            int month = Integer.parseInt(parts[1]);
            String[] months = {
                "", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
            };
            return months[month] + " " + parts[2] + " " + parts[0];
        }
    }
}
