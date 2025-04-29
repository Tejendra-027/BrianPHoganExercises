package BrianPHoganExercises.Simple_Math_05;
import java.util.*;

public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What is the first number?");
        int a = sc.nextInt();
        System.out.println("What is the second number?");
        int b = sc.nextInt();
        int add = a + b;
        int sub = a - b;
        int multi = a * b;
        int divide = a / b;
        System.out.println(a+" + "+b+ " = " +add);
        System.out.println(a+" - "+b+ " = " +sub);
        System.out.println(a+" * "+b+ " = " +multi);
        System.out.println(a+" / "+b+ " = " +divide);

    }
}
