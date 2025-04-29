package BrianPHoganExercises.Mad_Lib_04;
import java.util.*;

public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a noun : ");
        String noun = sc.nextLine();

        System.out.print("Enter a verb : ");
        String verb = sc.nextLine();

        System.out.print("Enter a adjective : ");
        String adjective = sc.nextLine();

        System.out.print("Enter a adverb : ");
        String adverb = sc.nextLine();

        System.out.println("Do you " + verb + " your " + adjective + " " + noun + " " + adverb + "? That's hilarious!");

    }
}
