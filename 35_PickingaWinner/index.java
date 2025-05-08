import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class index {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        String name;

        while (true) {
            System.out.print("Enter a name: ");
            name = input.nextLine();

            if (name.equals("")) {
                break; 
            }

            names.add(name);
        }

        if (names.size() > 0) {
            Random random = new Random();
            int winnerIndex = random.nextInt(names.size());
            String winner = names.get(winnerIndex);
            System.out.println("The winner is... " + winner + ".");
        } else {
            System.out.println("No names were entered.");
        }
    }
}
