package batch_17_project;

public class Task3 {
    public static void main(String[] args) {
        double dollarAmount = 2.36;

        int totalCents = (int) (dollarAmount * 100);

        int quarters = totalCents / 25;
        totalCents = totalCents % 25;

        int dimes = totalCents / 10;
        totalCents = totalCents % 10;

        int nickels = totalCents / 5;
        totalCents = totalCents % 5;

        int pennies = totalCents;

        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);
        System.out.println("Pennies: " + pennies);
    }
}
