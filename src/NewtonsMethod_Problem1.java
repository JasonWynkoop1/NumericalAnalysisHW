public class NewtonsMethod_Problem1 {

    private static int[] TOL = {1, 3, 5, 7, 11};
    private static double p0 = 1.2;
    private static String tableFormat = "|  %-4s   | %-4f  |   %-4f   |%n";
    private static int maxRuns = 200;

    public static void main(String[] args) {

        for (int i = 0; i < TOL.length; i++) {
            System.out.println("ZERO FOUND AT: " + newtonsMethod(TOL[i])
                    + " WITH ACCURACY OF: " + Math.pow(10, -TOL[i]) + "\n");
        }

    }

    private static double newtonsMethod(int accuracy) {

        int i = 1;

        while (i <= maxRuns) {
            double p = p0 - (function(p0) / functionPrime(p0));
            if (Math.abs(p - p0) < Math.pow(10, -accuracy)) {
                return p;
            } else {
                System.out.println(i + ")" + p);
                i++;
                p0 = p;
            }
        }
        return -1;
    }

    /**
     * Function --> e^x + 2^-x + 2cos(x) - 6 = 0
     *
     * @param x
     * @return
     */
    private static double function(double x) {
        return Math.exp(x) + 2 * (Math.exp(-x)) + 2 * (Math.cos(x)) - 6;
    }

    /**
     * Function --> e^x - ln(2) * 2^-x -2sin(x) = 0
     *
     * @param x
     * @return
     */
    private static double functionPrime(double x) {
        return Math.exp(x) - Math.log(2) * Math.pow(2, -x) - 2 * Math.sin(x);
    }
}
