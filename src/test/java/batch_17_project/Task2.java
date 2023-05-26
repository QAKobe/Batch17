package batch_17_project;

public class Task2 {
    public static void main(String[] args) {
        int quarters = 5;  // 5 * 25
        int dimes = 4; // 4 * 10
        int nickels = 3; // 3 * 5
        int pennies = 2; // Just plus pennies

        int totalCents = quarters * 25 + dimes * 10 + nickels * 5 + pennies;
        double totalDollars = totalCents / 100.0;

        System.out.println("The total in dollars is $ " + totalDollars);



    }
}
