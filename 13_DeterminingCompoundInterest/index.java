import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the principal amount? ");
        double principal = sc.nextDouble();

        System.out.print("What is the rate? ");
        double rate = sc.nextDouble();

        System.out.print("What is the number of years? ");
        int years = sc.nextInt();

        System.out.print("What is the number of times the interest is compounded per year? ");
        int times = sc.nextInt();

        
        double r = rate / 100;

     
        double amount = principal * Math.pow((1 + r / times), times * years);

        
        double roundedAmount = (amount * 100) / 100;

        
        System.out.println("$" + principal + " invested at " + rate + "% for " + years +
            " years compounded " + times + " times per year is $" + roundedAmount + ".");

    }
}

