import java.net.URI;
import java.net.http.*;
import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Where are you? ");
        String city = scanner.nextLine();
        String apiKey = "1812867bd1179f5dbfab7b5630a8ec84"; 
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=imperial"; 

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body();
            String temp = responseBody.split("\"temp\":")[1].split(",")[0];
            System.out.println(city + " weather:\n" + temp + " degrees Fahrenheit");
        } else {
            System.out.println("Could not retrieve temperature for " + city + ".");
        }

        scanner.close();
    }
}
