public class NewtonsMethod_Problem1 {

    private static int[] TOL = {1, 3, 5, 7, 11};
    private int i = 1;

    public static void main(String[] args) {
        newtonsMethod(TOL[0]);
    }

    private static void newtonsMethod(int TOL) {
        double q = function(1);
        System.out.print(q);
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
}
