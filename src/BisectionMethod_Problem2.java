/**
 * Jason Wynkoop
 * CS 384
 * HW-2 Problem 2 (Pg 53 Book Problem 14)
 * Using the Bisection Method to solve the equation: sqrt(3) approximate
 */
public class BisectionMethod_Problem2 {

    private static int i = 1;

    public static void main(String[] args){

        /*if(args.length == 0){
            System.out.println("NEED INTERVAL AND ACCURACY AS INPUTS");
            System.exit(0);
         } */

        if (args.length < 3) {
            double initial_a = 1.7;
            double initial_b = 1.75;
            double accuracy = .000001;
            System.out.println("USING DEFAULT INTERVAL OF [" + initial_a + ", " + initial_b + "]");
            System.out.println("Getting initial interval using the given interval of ["
                    + initial_a + ", " + initial_b + "].\n");

            System.out.println("The approximate solution is: "
                    + bisection(initial_a, initial_b, accuracy)
                    + " after " + i + " iterations.");
        } else {
            System.out.println("The approximate solution is: "
                    + bisection(Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]))
                    + " after " + i + " iterations.");
        }
    }

    /**
     *
     * @param a - initial point a
     * @param b - initial point b
     * @param c - accuracy given
     * @return - Approximation for the solution
     */
    private static double bisection(double a, double b, double c){
        //setting tolerance
        //getting sign for a
        double FA = Math.pow(a, 2) - 3;

        int maxRuns = 100;

        //while the number of run is less than the allotted amount
        while( i <= maxRuns){

            //setting midpoint
            double p = a + (b - a) / 2;

            double FP = Math.pow(p, 2) - 3;

            if ((FP == 0) || (Math.abs((b - a)) <= c)) {
                return p;
            }

            i++;

            if((FA * FP) > 0){
                a = p;
            }else{
                b = p;
            }

            System.out.println("New interval: [" + a + ", " + b + "]");
        }

        System.out.println("Method failed after " + maxRuns + " iterations.");

        return -1;
    }


}
