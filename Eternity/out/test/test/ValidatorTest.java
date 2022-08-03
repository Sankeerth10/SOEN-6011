package test;

import utility.ValidationUtility;
import org.junit.Assert;

/**
 This is a test class for the validationUtility class
 */
public class ValidatorTest {

    /**
     This test is to verify if the function is returning false when user inputs valid input but the value is not within range of datatype.
     */
    @org.junit.Test
    public void testInvalidInputRange() {
        double input = 2 * Double.MAX_VALUE;
        double negativeInput = -2 * Double.MAX_VALUE;
        Assert.assertFalse(ValidationUtility.validateInputRange(input));
        Assert.assertFalse(ValidationUtility.validateInputRange(negativeInput));
    }

    /**
     * This test to verify if the function is returning false When user inputs valid input and input is with in range of datatype , but output returned by function is more/less than datatype can store.
     */
    @org.junit.Test
    public void testOutputRange() {
        Assert.assertFalse(ValidationUtility.validateOutputRange(Double.NEGATIVE_INFINITY));
        Assert.assertFalse(ValidationUtility.validateOutputRange(Double.POSITIVE_INFINITY));
    }
}