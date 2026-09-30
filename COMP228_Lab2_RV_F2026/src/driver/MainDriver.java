package driver;

import interest.Interest;
import java.math.BigDecimal;
import java.util.Scanner;

public class MainDriver {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        BigDecimal principal = null;
        BigDecimal rate = null;
        BigDecimal time = null;

        boolean valid = false;

        // Loop until valid input is provided
        while (!valid) {
            try {
                System.out.println("Enter Principal (decimal only): ");
                principal = input.nextBigDecimal();

                System.out.println("Enter Rate (decimal only): ");
                rate = input.nextBigDecimal();

                System.out.println("Enter Time (years): ");
                time = input.nextBigDecimal();

                // Try creating object (this triggers validation)
                Interest test = new Interest(principal, rate, time);

                valid = true; // If no exception, input is valid

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
                System.out.println("Please try again.\n");
                input.nextLine(); // Clear buffer
            }
        }

        // Create 5 objects
        Interest i1 = new Interest(principal, rate, time);
        Interest i2 = new Interest(new BigDecimal("1200.50"), new BigDecimal("0.05"), new BigDecimal("2"));
        Interest i3 = new Interest(new BigDecimal("5000.75"), new BigDecimal("0.07"), new BigDecimal("3"));
        Interest i4 = new Interest(new BigDecimal("900.99"), new BigDecimal("0.03"), new BigDecimal("1"));
        Interest i5 = new Interest(new BigDecimal("15000.25"), new BigDecimal("0.06"), new BigDecimal("4"));

        System.out.println("\n--- Simple Interest (BigDecimal) ---");
        System.out.println(i1.calculateSimpleInterest());

        System.out.println("\n--- Compound Interest (BigDecimal) ---");
        System.out.println(i1.calculateCompoundInterest());

        System.out.println("\n--- Simple Interest (double overload) ---");
        System.out.println(i1.calculateSimpleInterest(1000.5, 0.05, 2));

        System.out.println("\n--- Compound Interest (double overload) ---");
        System.out.println(i1.calculateCompoundInterest(1000.5, 0.05, 2));

        // Print results for all 5 objects
        System.out.println("\n--- Object 2 SI/CI ---");
        System.out.println(i2.calculateSimpleInterest());
        System.out.println(i2.calculateCompoundInterest());

        System.out.println("\n--- Object 3 SI/CI ---");
        System.out.println(i3.calculateSimpleInterest());
        System.out.println(i3.calculateCompoundInterest());

        System.out.println("\n--- Object 4 SI/CI ---");
        System.out.println(i4.calculateSimpleInterest());
        System.out.println(i4.calculateCompoundInterest());

        System.out.println("\n--- Object 5 SI/CI ---");
        System.out.println(i5.calculateSimpleInterest());
        System.out.println(i5.calculateCompoundInterest());

        input.close();
    }
}