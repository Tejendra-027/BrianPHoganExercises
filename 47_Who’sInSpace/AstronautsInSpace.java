import java.net.URI;
import java.net.http.*;
import java.util.regex.*;

public class AstronautsInSpace {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.open-notify.org/astros.json"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        
        Pattern numberPattern = Pattern.compile("\"number\"\\s*:\\s*(\\d+)");
        Matcher numMatcher = numberPattern.matcher(json);
        if (numMatcher.find()) {
            int count = Integer.parseInt(numMatcher.group(1));
            System.out.println("There are " + count + " people in space right now:");
        }

       
        System.out.println("Name                 | Craft");
        System.out.println("---------------------|--------");

        
        Pattern personPattern = Pattern.compile("\"craft\"\\s*:\\s*\"([^\"]+)\",\\s*\"name\"\\s*:\\s*\"([^\"]+)\"");
        Matcher matcher = personPattern.matcher(json);
        while (matcher.find()) {
            String craft = matcher.group(1);
            String name = matcher.group(2);
            System.out.printf("%-21s | %s%n", name, craft);
        }
    }
}
