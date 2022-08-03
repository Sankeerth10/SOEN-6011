package test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import sinhx.SinhX;
import ui.UIMessages;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 This is test case class for the sinhX class
 */
public class SinhXTest {
    private final ByteArrayOutputStream outData = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outData));
        SinhX.maxSteps = 20;
    }

    @After
    public void TearDownStreams() {
        System.setOut(originalOut);
    }

    /**
     This test is to verify the Value of the Euler's Number.
     */
    @Test
    public void testERaisedToX() {
        SinhX Sinhx = new SinhX();
        double result = Sinhx.eRaisedTo(1.0);
        Assert.assertEquals(result, 2.718281828459045, 0.0);
        Assert.assertFalse(Double.isNaN(result) && Double.isInfinite(result)); // The result should not be infinite
    }



    /**
     This test verifies if the function is returning a proper error message when the user provides an input a value that can not be handled by it.
     */
    @Test
    public void testInvalidUpperBoundInput() {
        SinhX sinhFunction = new SinhX();
        ByteArrayInputStream input = new ByteArrayInputStream(
                String.valueOf(2 * Double.MAX_VALUE).getBytes());
        System.setIn(input);
        sinhFunction.setup();
        Assert.assertEquals("Value should be more than 4.9E-324 and less than 1.7976931348623157E308", UIMessages.ERROR_MESSAGE_RANGE);

    }

    /**
     This test verifies if the function is returning a proper error message when the user provides an invalid value (alphabets/special characters).
     */
    @Test
    public void testInvalidInput() {
        SinhX sinhFunction = new SinhX();
        ByteArrayInputStream input = new ByteArrayInputStream(
                "This is non number invalid input".getBytes());
        System.setIn(input);
        sinhFunction.setup();
        Assert.assertEquals("Given input is invalid, Input should only be a number",
                UIMessages.ERROR_MESSAGE);
    }

    /**
     This test verifies if the function is returning a valid calculated value when the user inputs valid number.
     */
    @Test
    public void testValidInput() {
        SinhX sinhFunction = new SinhX();
        ByteArrayInputStream input = new ByteArrayInputStream(
                "1".getBytes());//input will be passed as number , not string
        System.setIn(input);
        double epowerX = sinhFunction.eRaisedTo(1.0);
        double epowerMinusX = sinhFunction.eRaisedTo(-1.0);
        double expectedResult = 1.1752011936438014;
        Assert.assertEquals(expectedResult,sinhFunction.sinhX(epowerX, epowerMinusX),1e-15);
        System.setIn(System.in);
    }

    /**
     This test verifies if the function is taking only the first 15 decimal points as significant decimal points if the user inputs valid value but decimal points are more than 15.
     */
    @Test
    public void testSignificantDecimalPoints() {
        SinhX sinhFunction = new SinhX();
        ByteArrayInputStream input = new ByteArrayInputStream(
                "1.11111111111111120202"
                        .getBytes());//input will be passed as number , not string
        System.setIn(input);
        sinhFunction.setup();
        Assert.assertTrue(outData.toString().trim().contains("1.111111111111111"));
        Assert.assertFalse(outData.toString().trim().contains("20202"));
        System.setIn(System.in);
    }

    /**
     This test is to verify the value of sinhX function with a valid input.
     */
    @Test
    public void testSinhX() {
        SinhX Sinhx = new SinhX();
        double eRaisedToX = Sinhx.eRaisedTo(2.0);
        double eRaisedToXMinusX = Sinhx.eRaisedTo(-2.0);
        double expectedResult = 3.6268604078469773;
        Assert.assertEquals(expectedResult, Sinhx.sinhX(eRaisedToX, eRaisedToXMinusX), 0.0);
    }

}