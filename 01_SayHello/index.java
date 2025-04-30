import java.util.*;

public class index{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name");
        String name = sc.nextLine();
        
        String message;
        if (name.equals("Abhijeet")) {
            message = "Hey Abhijeet! You're awesome!";
        } else if (name.equals("Yuvraj")) {
            message = "Hi Yuvraj, welcome back!";
        } else {
            message = "Hello" + name + " nice to meet you!";
        }

        System.out.println(message);

    }
}

