import java.util.*;

public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the ceiling in feet: ");
        float length = sc.nextFloat();

        System.out.print("Enter the width of the ceiling in feet: ");
        float width = sc.nextFloat();

        float area = length * width;

        int gallons =  (int) Math.ceil(area / 350) ;

        System.out.println("\nYou will need to purchase " + gallons +
                " gallons of paint to cover " + (int)area + " square feet.");
    }
}
