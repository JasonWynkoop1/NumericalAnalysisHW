/**
 * Jason Wynkoop
 * CS 384
 * HW-2 Problem 1 (Pg 53 Book Problem 5b)
 * Using the Bisection Method to solve the equation: e^x-x^2+3x-2=0
 */
class BisectionMethod_Problem1 {

    private static int i = 1;

    /**
     *
     * @param args - console output
     */
    public static void main(String[] args){
        if (args.length < 3) {
            System.out.println("Enter an interval and then an accuracy to find root!");
            System.exit(0);
        } else {
            double initial_a = Double.parseDouble(args[0]);
            double initial_b = Double.parseDouble(args[1]);
            double accuracy = Double.parseDouble(args[2]);

            if((function(initial_a) * function(initial_b)) > 0){
                System.out.println("Your current interval results in f(a) * f(b) > 0...please try a different one.");
                System.exit(0);
            }
            System.out.println("The approximate solution using the interval [" + initial_a + ", " + initial_b
                    + "] and an accuracy of " + accuracy + " is "
                    + bisection(initial_a, initial_b, accuracy)
                    + " after " + i + " iterations.");
        }
    }

    /**
     *
     * @param a - initial  a
     * @param b - initial  b
     * @param c - accuracy given
     * @return - Approximation for the solution
     */
    private static double bisection(double a, double b, double c){

        double FA = function(a);
        int maxRuns = 100;
        while( i <= maxRuns){
            double p = a + (b - a) / 2;

            double FP = function(p);
            if (FP == 0 || (Math.abs((b - a)) <= c)) {
                return p;
            }

            i++;

            if((FA * FP) > 0){
                a = p;
            }else{
                b = p;
            }

            System.out.println("[" + a + ", " + b + "]");
        }

        System.out.println("Method failed after " + maxRuns + " iterations.");

        return -1;
    }

    private static double function(double x){
        return Math.exp(x) - Math.pow(x, 2) + (3 * x) - 2;
    }

}
