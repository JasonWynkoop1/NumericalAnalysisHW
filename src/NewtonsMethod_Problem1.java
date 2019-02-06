/**
 * Jason Wynkoop
 * Due 02/06
 * <p>
 * Problem 1 / Exercise 6a / Page 74
 * <p>
 * Show all steps of all iterations in tables.
 * Run the algo for all the tolerances 10^-k where k = 1, 3, 5, 7, 11
 * Comment on the number of steps needed to see a new significant digit in the approximate solution.
 * Conclude if the step-counting result justifies linear or quadratic convergence.
 */
public class NewtonsMethod_Problem1 {

    private static int[] TOL = {1, 3, 5, 7, 11};
    private static double p0 = 1.5;

    public static void main(String[] args) {

        for (int i = 0; i < TOL.length; i++) {

            System.out.printf("%4s  %5s  %10s%n", "i", "p0", "p");
            System.out.println("ZERO APPROXIMATION FOUND AT: " + newtonsMethod(TOL[i])
                    + "\nWITH ACCURACY OF: " + Math.pow(10, -TOL[i]) + "\n");
        }

    }

    private static double newtonsMethod(int accuracy) {

        int i = 1;

        int maxRuns = 200;
        while (i <= maxRuns) {
            double p = p0 - (function(p0) / functionPrime(p0));
            String format = "%4d  %4f  %4f%n";
            if (Math.abs(p - p0) <= Math.pow(10, -accuracy)) {
                System.out.format(format, i, p0, p);
                p0 = 1.5;
                return p;
            } else {
                System.out.format(format, i, p0, p);
                i++;
                p0 = p;
            }


        }
        return -1;
    }

    /**
     * Function --> e^x + 2^-x + 2cos(x) - 6 = 0
     *
     * @param x - variable
     * @return - function in terms of x
     */
    private static double function(double x) {
        return Math.exp(x) + 2 * (Math.exp(-x)) + 2 * (Math.cos(x)) - 6;
    }

    /**
     * Function --> e^x - ln(2) * 2^-x -2sin(x) = 0
     *
     * @param x - variable
     * @return - function in terms of x
     */
    private static double functionPrime(double x) {
        return Math.exp(x) - Math.log(2) * Math.pow(2, -x) - 2 * Math.sin(x);
    }
}
