import java.util.Scanner;
public class Main {
    public static void main (String[]args){

        int i;
        String name;
        double price;
        String model;
        int year;
        String weightUnit;
        int weight;
        String size;
        String fabric;

        System.out.println("Welcome to the shopping cart");
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("What would you like to do(pick a number)");
            System.out.println("1. Add item");
            System.out.println("2. Check shopping cart");
            System.out.println("3. Continue to checkout");
            i = sc.nextInt();

            if (i == 1){
                System.out.println("Which Item would you like to add?");
                System.out.println("1. Electronics");
                System.out.println("2. Food");
                System.out.println("3. Dress");
                System.out.println("4. Other");
                i = sc.nextInt();
                if (i == 1){
                    Electronics e = new Electronics();
                    System.out.println("Enter Name: ");
                    name = sc.nextLine();
                    System.out.println("Enter Price: ");
                    price = sc.nextDouble();
                    System.out.println("Enter Model: ");
                    model = sc.nextLine();
                    System.out.println("Enter Year: ");
                    year = sc.nextInt();
                }
            }


        }


    }
}
