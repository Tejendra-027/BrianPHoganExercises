import java.util.*;
public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many euros are you exchanging? :- ");
        double euros = sc.nextDouble();

        System.out.print("What is the exchange rate? :- ");
        double exchangeRate = sc.nextDouble();

        double usd = euros * (exchangeRate / 100);

        System.out.println(euros+ " euros at an exchange rate of " +exchangeRate+ " is " +usd+ " U.S. dollars.");

    }
}
