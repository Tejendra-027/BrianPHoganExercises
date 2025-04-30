import java.util.*;
public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the length of the room in feet? ");
        float length = sc.nextFloat();

        System.out.print("What is the width of the room in feet? ");
        float width = sc.nextFloat();

        System.out.println("You entered dimensions of " +length+ " feet by " +width+ " feet. ");

        float area = length * width;

        float SquareMeter = area * (0.09290304f) ;

        System.out.println("The area is");

        System.out.println(area + " square feet");

        System.out.println(SquareMeter + " square meters");
    }
}
