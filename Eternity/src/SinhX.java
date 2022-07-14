import java.util.Scanner;

public class SinhX {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a value:");
            String s = scan.nextLine();
            System.out.println();
            if(s.compareTo("EXIT") == 0)
                break;
            // convert the string input to double
            double x = Double.parseDouble(s);
            // get the hyperbolic sine of the user input
            double accurateV = Math.sinh(x);
            System.out.println("Accurate Hyperbolic Sine of " + s + " is " + accurateV);
            double sinehValue = SineHyperbolic(x);
            System.out.println("Hyperbolic Sine of " + s + " is " + sinehValue);
        }
    }

    private static double SineHyperbolic(double x){

        double result = (eRaisedTo(x) - eRaisedTo(-x))/2;
        return result;
    }

    private static double eRaisedTo(double x){
        final double E = 2.7182818284590452354;
        double result = E;
        if(x>0) {
            for (double i = 1; i < x; i++) {
                result = result * E;
            }
        }
        else if(x<0){
            double y = -x;
            for (double i = 1; i < y; i++) {
                result = result * E;
            }
            result =1/result;
        }
        else{
            result = 1;
        }
        return result;
    }


}
