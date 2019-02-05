public class NewtonsMethod_Problem1 {

    private static int[] TOL = {1, 3, 5, 7, 11};
    private static double p0 = 1.5;

    public static void main(String[] args) {
        System.out.println("Here we go");
        for (int i = 0; i < TOL.length; i++) {
            newtonsMethod(i);
        }
    }

    private static void newtonsMethod(int a) {
        int i = 1;
        double p = p0 - (function(p0) / functionPrime(p0));
        double accuracy = Math.pow(10, -a);
        System.out.println(accuracy);
        int maxRuns = 200;
        while (i <= maxRuns) {
            if (Math.abs(p - p0) < accuracy) {
                System.out.println("Step" + i + ": " + p);
                break;
            }

            i = i + 1;
            p0 = p;
        }
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
