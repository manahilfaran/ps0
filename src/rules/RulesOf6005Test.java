/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class RulesOf6005Test {

    @Test
    public void testMayUseCodeInAssignment() {
        assertTrue("Expected true: self-written code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
        assertTrue("Expected true: publicly-available, cited, not required",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }

    @Test
    public void testPublicCitedCodeAllowed() {
        assertTrue("Expected true: cited public code that is not required",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }

    @Test
    public void testCourseWorkFromOthersNotAllowed() {
        assertFalse("Expected false: someone else's 6.005 course work",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }

    @Test
    public void testImplementationRequiredNotAllowed() {
        assertFalse("Expected false: assignment requires your own implementation",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, true));
    }

    @Test
    public void testUncitedCodeNotAllowed() {
        assertFalse("Expected false: source not cited",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
    }

    @Test
    public void testNonPublicCodeNotAllowed() {
        assertFalse("Expected false: code is not publicly available",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, true, false));
    }
}