package org.hillcrest.chapter6.password;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriteriaCheckerTest {

    @Test
    public void testWeakPassword() {
        assertEquals(1, CriteriaChecker.evaluateCriteria("12345"));
        assertEquals("Weak", CriteriaChecker.determineStrength(1));
    }

    @Test
    public void testModeratePassword() {
        assertEquals(3, CriteriaChecker.evaluateCriteria("password123"));
        assertEquals("Moderate", CriteriaChecker.determineStrength(3));
    }

    @Test
    public void testStrongPassword() {
        assertEquals(5, CriteriaChecker.evaluateCriteria("Secure@2024"));
        assertEquals("Strong", CriteriaChecker.determineStrength(5));
    }
}

