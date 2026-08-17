import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example exchange rates (you can update these)
        double usdToInr = 83.0;
        double eurToInr = 90.0;
        double gbpToInr = 105.0;

        while (true) {
            System.out.println("\n--- Currency Converter ---");
            System.out.println("1. USD to INR");
            System.out.println("2. EUR to INR");
            System.out.println("3. GBP to INR");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount in USD: ");
                    double usd = sc.nextDouble();
                    System.out.println("INR: " + (usd * usdToInr));
                    break;
                case 2:
                    System.out.print("Enter amount in EUR: ");
                    double eur = sc.nextDouble();
                    System.out.println("INR: " + (eur * eurToInr));
                    break;
                case 3:
                    System.out.print("Enter amount in GBP: ");
                    double gbp = sc.nextDouble();
                    System.out.println("INR: " + (gbp * gbpToInr));
                    break;
                case 4:
                    System.out.println("Thank you for using the converter!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

