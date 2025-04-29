package BrianPHoganExercises;
import java.util.*;


public class P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("What is the quote?");
        String quote = sc.nextLine();

        System.out.print("Who said it? ");
        String author = sc.nextLine();

        System.out.println(author + " says, \"" + quote + "\"");
    }
}
