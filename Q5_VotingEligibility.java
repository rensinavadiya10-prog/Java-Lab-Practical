
import java.util.Scanner;

class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

public class Q5_VotingEligibility {

    static void checkAge(int age)
            throws InvalidAgeException {

        if (age < 18) {
            throw new InvalidAgeException(
                "You are not eligible for voting!"
            );
        } else {
            System.out.println("You are eligible for voting.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            checkAge(age);

        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Please enter a valid age.");

        } finally {
            System.out.println("Program completed.");
            sc.close();
        }
    }
}
