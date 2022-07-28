package listing_01_04;
/**
 * a*x^2 + b*x + c = 0
 * a, b, c - coefficients
 * eps - calculation accuracy
 * d - discriminant
 */

public class QuadraticEquation {
    public static void main(String[] args) {
        double a = 0.5;
        double b = -2.7;
        double c = 3.5;
        double d;
        double eps = 1e-8;

        if (Math.abs(a) < eps) {
            if (Math.abs(b) < eps) {
                if (Math.abs(c) < eps) {
                    System.out.println("Solution - any number");
                }
                else {
                    System.out.println("No solutions");
                }
            }
            else {
                System.out.println("x1 = x2 = " + (-c / b));
            }
        }
        else {
            if ((d = b * b - 4 * a * c) <  0.0) {
                d = 0.5 * Math.sqrt(-d) / a;
                a = -0.5 * b / a;
                System.out.println("x1 = " + a + " + i" + d + ", x2 = " + a + " – i" + d);
            }
            else {
                d = 0.5 * Math.sqrt(d) / a;
                a = -0.5 * b / a;
                System.out.println("x1 = " +(a + d)+ ", x2 = " +(a - d));
            }
        }
    }
}
