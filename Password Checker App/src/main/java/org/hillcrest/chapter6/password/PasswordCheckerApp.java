package org.hillcrest.chapter6.password;
import java.util.Scanner;

/**

 * prompts the user for a password and evaluates its strength

 */
public class PasswordCheckerApp {

    /**
     * Entry point of the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for password
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        // Evaluate password criteria
        int score = CriteriaChecker.evaluateCriteria(password);
        String strength = CriteriaChecker.determineStrength(score);

        // Output strength
        System.out.println("\nPassword Strength: " + strength + " (" + score + "/5)");

        // Generate feedback if needed
        if (!strength.equals("Strong")) {
            System.out.println("Suggestions to improve your password:");
            System.out.println(FeedbackGenerator.generateFeedback(password));
        }

        scanner.close();
    }
}
