import java.util.*;
public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many people? ");
        int people = sc.nextInt();

        System.out.print("How many pizzas do you have? ");
        int pizzas = sc.nextInt();

        System.out.print("How many slices per pizza? ");
        int slicesPerPizza = sc.nextInt();

        int totalSlice = pizzas * slicesPerPizza;

        int slicesPerPerson = totalSlice / people;

        int leftoverSlices = totalSlice % people;

        System.out.println("\n" + people + " people with " + pizzas + " pizzas");
        System.out.println("Each person gets " + slicesPerPerson + " pieces of pizza.");
        System.out.println("There are " + leftoverSlices + " leftover pieces.");
    }
}
