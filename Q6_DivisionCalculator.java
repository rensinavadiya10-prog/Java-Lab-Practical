
import java.util.Scanner;

public class Q6_DivisionCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            int result = a / b;

            System.out.println("Division Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Please enter valid numbers.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Thank you!");
            sc.close();
        }
    }
}
