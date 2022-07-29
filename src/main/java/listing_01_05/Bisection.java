package listing_01_05;
/**
 * function f(x) on the segment [a; b] has only one root
 */

public class Bisection {
    static double f (double x) {
        return x*x*x - 3*x*x + 3;
    }

    public static void main(String[] args){
        double a = 0.0;
        double b = 1.5;
        double c;
        double y;
        double eps = 1e-8;

        do{
            // Point c is in the middle of the segment [a; b]
            c = (a + b) / 2;
            y = f(c);
            // If the value of the function is less than the allowable accuracy, then the solution has been found.
            // Exiting the cycle
            if (Math.abs(y) < eps) break;
            // If at the ends of the segment [a; c] the value of the function has different signs,
            // which means that the root of the equation is on the segment [a; c].
            // Moving point b to point c
            if (f(a) * y < 0.0) b = c;
            // Otherwise, move point a to point c
            else a = c;
            // We continue until the segment [a; b] will not become less than the allowable accuracy
        } while(Math.abs(b-a) >= eps);
        System.out.println("x = " + c + ", f(" + c + ") = " + y);
    }
}
