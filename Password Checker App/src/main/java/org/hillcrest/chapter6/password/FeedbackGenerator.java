package org.hillcrest.chapter6.password;

/**
 * to improve a password's strength.
 */
public class FeedbackGenerator {

    /**
     * @param password the password to analyze
     * @return feedback string with suggestions
     */
    public static String generateFeedback(String password) {
        String feedback = "";

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        if (password.length() < 8) {
            feedback += "- Increase the length to at least 8 characters.\n";
        }

        // Loop through characters
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if ("!@#$%^&*()-+=".indexOf(ch) >= 0) hasSpecial = true;
        }

        if (!hasUpper) {
            feedback += "- Add at least one uppercase letter.\n";
        }
        if (!hasLower) {
            feedback += "- Add at least one lowercase letter.\n";
        }
        if (!hasDigit) {
            feedback += "- Add at least one number.\n";
        }
        if (!hasSpecial) {
            feedback += "- Include at least one special character.\n";
        }

        return feedback;
    }
}

