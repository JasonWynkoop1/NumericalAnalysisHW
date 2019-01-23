/**
 * Jason Wynkoop
 * CS 384
 * HW-2 Problem 1 (Pg 53 Book Problem 5b)
 * Using the Bisection Method to solve the equation: e^x-x^2+3x-2=0
 */
class BisectionMethod_Problem1 {

    private static int i = 1;

    public static void main(String[] args){

        if(args.length == 0){
            System.out.println("NEED INTERVAL AND ACCURACY AS INPUTS");
            System.exit(0);
        }

        System.out.println("Getting initial interval using the given interval of ["
                + args[0] + ", " + args[1] + "].\n");

        System.out.println("The approximate solution is: "
                + bisection(Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2])) + " after " + i + " iterations.");
    }

    private static double bisection(double a, double b, double c){

        double TOL = c;

        double FA = Math.exp(a) - Math.pow(a, 2) + (3 * a) - 2;
        int maxRuns = 100;
        while( i <= maxRuns){
            double p = a + (b - a) / 2;

            double FP = Math.exp(p) - Math.pow(p, 2) + (3 * p) - 2;
            if(FP == 0 || (Math.abs((b-a)) <= TOL)){
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
