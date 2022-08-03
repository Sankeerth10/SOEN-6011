package utility;

import ui.UIMessages;

public class ValidationUtility {
    /**
     * This method verifies if the input is within the range
     * of what the function can handle.
     * @param input
     * @return result
     */
    public static boolean validateInputRange(final double input) {
        boolean result = true;
        if (input > Double.MAX_VALUE) {
            result = false;
        } else if (input < -Double.MAX_VALUE) {
            result = false;
        }
        return result;
    }

    /**
     * This method checks if the output value is out of range.
     * @param output
     * @return result
     */

    public static boolean validateOutputRange(final double output) {
        boolean result = true;
        if (output == Double.POSITIVE_INFINITY) {
            System.out.println(UIMessages.ERROR_MESSAGE_OUT_OF_RANGE_MAX);
            result = false;
        } else if (output == Double.NEGATIVE_INFINITY) {
            System.out.println(UIMessages.ERROR_MESSAGE_OUT_OF_RANGE_MIN);
            result = false;
        }
        return result;
    }


}

