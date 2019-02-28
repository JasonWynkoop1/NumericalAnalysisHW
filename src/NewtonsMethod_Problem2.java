/**
 * Use Newton's Method to approximate 10^-4, the value of x that produces the point on the
 * graph y = 1/x that is closest to (2, 1).
 * <p>
 * Problem 2 / Exercise 20 / Page 76
 */
public class NewtonsMethod_Problem2 {

    private static int i = 1;
    private static double p0 = 2;

    public static void main(String[] args) {
        System.out.println("VALUE OF X: " + newtonsMethod());
    }


    /**
     * Newton's Method
     * @param accuracy - tolerance
     * @return - zero
     */
    private static double newtonsMethod() {
        int maxRuns = 200;
        while (i < maxRuns) {
            double p = p0 - (function(p0) / functionPrime(p0));
            if (Math.abs(p - p0) < Math.pow(10, -4)) {
                System.out.println("STEP: " + i + " (" + p + ", " + 1 / p + ")");
                return p;
            }
            System.out.println("STEP: " + i + " (" + p + ", " + 1 / p + ")");
            p0 = p;
            i++;
        }
        return -1;
    }

    private static double function(double x) {

        return Math.pow(x, 4) - 2 * Math.pow(x, 3) + x - 1;
    }

    private static double functionPrime(double x) {

        return Math.pow(x, 4) - 2 * x + 3;
    }
}
