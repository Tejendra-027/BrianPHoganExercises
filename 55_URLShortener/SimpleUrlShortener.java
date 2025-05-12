import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;
import com.sun.net.httpserver.*;

public class SimpleUrlShortener {

    private static final String DATA_FILE = "urls.txt";
    private static final Map<String, String> urlDatabase = new ConcurrentHashMap<>();
    private static final Map<String, Integer> visitCounts = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        loadUrlsFromFile();
        
        
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new RequestHandler());
        server.setExecutor(null); 
        System.out.println("Server started at http://localhost:8080");
        server.start();
    }

   
    static class RequestHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String path = exchange.getRequestURI().getPath();

            if (path.equals("/")) {
                
                String response = "<html><body>" +
                        "<h2>Enter a URL to shorten</h2>" +
                        "<form method='POST' action='/shorten'>" +
                        "<input type='text' name='longUrl' required placeholder='Enter long URL'>" +
                        "<input type='submit' value='Shorten'>" +
                        "</form></body></html>";
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();

            } else if (path.startsWith("/shorten")) {
                
                String longUrl = getQueryParam(exchange, "longUrl");

                if (isValidUrl(longUrl)) {
                    String shortUrl = generateShortUrl();
                    urlDatabase.put(shortUrl, longUrl);
                    visitCounts.put(shortUrl, 0);
                    saveUrlsToFile();

                    String response = "Shortened URL: <a href='/"+shortUrl+"'>/" + shortUrl + "</a>";
                    exchange.getResponseHeaders().set("Content-Type", "text/html");
                    exchange.sendResponseHeaders(200, response.getBytes().length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                } else {
                    // Invalid URL
                    String response = "Invalid URL. Please try again.";
                    exchange.getResponseHeaders().set("Content-Type", "text/html");
                    exchange.sendResponseHeaders(400, response.getBytes().length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                }

            } else if (path.startsWith("/stats")) {
               
                String shortUrl = path.split("/")[2];
                if (urlDatabase.containsKey(shortUrl)) {
                    String longUrl = urlDatabase.get(shortUrl);
                    int visits = visitCounts.get(shortUrl);
                    String response = "Short URL: /" + shortUrl + "<br>Long URL: " + longUrl + "<br>Visits: " + visits;
                    exchange.getResponseHeaders().set("Content-Type", "text/html");
                    exchange.sendResponseHeaders(200, response.getBytes().length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                } else {
                    String response = "Short URL not found.";
                    exchange.getResponseHeaders().set("Content-Type", "text/html");
                    exchange.sendResponseHeaders(404, response.getBytes().length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                }

            } else {
               
                String shortUrl = path.substring(1);
                if (urlDatabase.containsKey(shortUrl)) {
                    String longUrl = urlDatabase.get(shortUrl);
                    visitCounts.put(shortUrl, visitCounts.get(shortUrl) + 1);
                    exchange.getResponseHeaders().set("Location", longUrl);
                    exchange.sendResponseHeaders(302, -1); 
                } else {
                    String response = "Short URL not found.";
                    exchange.getResponseHeaders().set("Content-Type", "text/html");
                    exchange.sendResponseHeaders(404, response.getBytes().length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                }
            }
        }
    }

   
    private static String getQueryParam(HttpExchange exchange, String param) {
        String query = exchange.getRequestURI().getQuery();
        for (String pair : query.split("&")) {
            String[] keyValue = pair.split("=");
            if (keyValue[0].equals(param)) {
                return URLDecoder.decode(keyValue[1], StandardCharsets.UTF_8);
            }
        }
        return "";
    }

    private static boolean isValidUrl(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static String generateShortUrl() {
        return "abc" + UUID.randomUUID().toString().substring(0, 6);  // Simple short URL generation
    }

    private static void loadUrlsFromFile() {
        File file = new File(DATA_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    if (parts.length == 2) {
                        String shortUrl = parts[0];
                        String longUrl = parts[1];
                        urlDatabase.put(shortUrl, longUrl);
                        visitCounts.put(shortUrl, 0);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void saveUrlsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (Map.Entry<String, String> entry : urlDatabase.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
