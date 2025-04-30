import java.util.*;

public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("what is your input strings");
        String name = sc.nextLine();

        if(name.isEmpty()){
            System.out.println("You must enter something");
        } else {
            System.out.println("String is " + name + " String length is " + name.length() );
        }
    }
}
