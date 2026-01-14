package org.hillcrest.chapter6.password;

/**
 * password strength based on a criteria.
 */
public class CriteriaChecker {

    /**
     * Evaluates the password against five criteria
     * @param password the password to evaluate
     * @return number of criteria met (0–5)
     */
    public static int evaluateCriteria(String password) {
        int score = 0;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Length check
        if (password.length() >= 8) {
            score++;
        }

        // Loop through characters (REQUIRED)
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if ("!@#$%^&*()-+=".indexOf(ch) >= 0) {
                hasSpecial = true;
            }
        }

        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        return score;
    }

    /**
     * Determines password strength based on score.
     *
     * @param score criteria score
     * @return Weak, Moderate, or Strong
     */
    public static String determineStrength(int score) {
        if (score <= 2) {
            return "Weak";
        } else if (score == 3) {
            return "Moderate";
        } else {
            return "Strong";
        }
    }
}

