public class NewtonsMethod_Problem2 {

    private static int i = 1;
    private static double p0 = 2;
    private static int maxRuns = 200;

    public static void main(String[] args) {

        System.out.println("(" + newtonsMethod() + ", " + 1 / newtonsMethod() + ")");
    }

    private static double newtonsMethod() {
        while (i < maxRuns) {
            double p = p0 + (function(p0) / functionPrime(p0));
            if (Math.abs(p - p0) < Math.pow(10, -4)) {
                return p;
            }
            System.out.println("STEP: " + i + "(" + p + ", " + 1 / p + ")");
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
