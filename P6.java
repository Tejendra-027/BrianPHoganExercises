package BrianPHoganExercises;
import java.time.Year;
import java.util.*;

public class P6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("what is your current age");
        String currentAgeInput = sc.nextLine();
        System.out.println("At what age would you like to retire?");
        String retireAgeInput = sc.nextLine();

        int currentAge = Integer.parseInt(currentAgeInput);
        int retireAge = Integer.parseInt(retireAgeInput);

        int currentYear = Year.now().getValue();

        int yearsleft = retireAge - currentAge;
        int retireYear = currentYear + yearsleft;
        
        System.out.println(
            "You have " + yearsleft + " years left until you can retire.\n" +
            "It's " + currentYear + ", so you can retire in " + retireYear + "."
        );
    }
}
