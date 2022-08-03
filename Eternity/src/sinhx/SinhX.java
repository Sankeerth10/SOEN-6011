package sinhx;

import ui.UIMessages;
import utility.ValidationUtility;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This class implements the sine Hyperbolic function.
 * The readme file provides the details about the function.
 * @author : Sai Sankeerth Koduri
 */
public class SinhX {
    public static int maxSteps = 20;
    //divisor used in sinhX.
    private static final double DIVISOR = 2d;

    public void setup() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextDouble()){ double x = scanner.nextDouble();
            if (ValidationUtility.validateInputRange(x)) {
                //consider only first 15 decimal points from input.
                DecimalFormat df = new DecimalFormat(".###############");
                x = Double.parseDouble(df.format(x));
                double eRaisedToX = eRaisedTo(x);
                double eRaisedToNegativeX = eRaisedTo(-x);
                validateAndCalculateSinhx(x, eRaisedToX, eRaisedToNegativeX);
            } else {
                System.out.println(UIMessages.ERROR_MESSAGE_RANGE);
            }
        } else {
            System.out.println(UIMessages.ERROR_MESSAGE);
        }
    }

    /**
     *  This method validates the input values and then calls the Sinhx method.
     * @param x
     * @param eRaisedToX .
     * @param eRaisedToNegativeX .
     */
    public void validateAndCalculateSinhx(final double x,
                                          final double eRaisedToX,
                                          final double eRaisedToNegativeX) {
        if (ValidationUtility.validateOutputRange(eRaisedToX)
                && ValidationUtility.validateOutputRange(eRaisedToNegativeX)) {
            double result = sinhX(eRaisedToX, eRaisedToNegativeX);
            System.out.print(UIMessages.SUCCESS_MESSAGE + x + " is ");
            System.out.printf("%.15f", result);
        }
    }


    /**
     *This method calculates sinh(x) based on formula ,
     *  sinh(x) = (e^x - e^-x)/2.
     * @param eRaisedToX
     * @param eRaisedToNegativeX
     * @return
     */
    public double sinhX(final double eRaisedToX,
                        final double eRaisedToNegativeX) {
        return (eRaisedToX - eRaisedToNegativeX) / DIVISOR;
    }

    /**
     * This function calculate e raised to x based on Taylor series,
     * The first 20 steps of Taylor series will be considered
     * in order to calculate e raised to x with good accuracy.
     * @param x real number provided by user
     * @return calculated value of e raised to x
     */
    public double eRaisedTo(final double x) {
        double result = 1;
        for (int i = SinhX.maxSteps; i > 0; --i) {
            result = 1 + x * result / i;
        }
        return result;
    }

//    public double eRaisedTo(double x){
//        final double E = 2.7182818284590452354;
//        double result = E;
//        if(x>0) {
//            for (double i = 1; i < x; i++) {
//                result = result * E;
//            }
//        }
//        else if(x<0){
//            double y = -x;
//            for (double i = 1; i < y; i++) {
//                result = result * E;
//            }
//            result =1/result;
//        }
//        else{
//            result = 1;
//        }
//        return result;
//    }



}
