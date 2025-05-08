import java.util.Scanner;
import java.util.Random;

public class index {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String[] responses = {
            "Yes.",
            "No.",
            "Maybe.",
            "Ask again later."
        };

        System.out.print("What's your question? ");
        String question = input.nextLine();  

        int randomIndex = random.nextInt(responses.length);
        System.out.println(responses[randomIndex]);
    }
}
