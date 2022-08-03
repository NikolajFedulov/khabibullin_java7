package listing_02_01;
/**
 * function f(x)=x^3-3*x^2+3 on the segment [a; b] has only one root
 */

public class Bisection2 {

    private static final double EPS = 1e-8;
    private double a = 0.0;
    private double b = 1.5;
    private double root;

    public double getRoot() {
        return root;
    }

    private double f(double x) {
        return x*x*x - 3*x*x + 3;
    }

    private void bisect(){
        double y = 0.0;
        do {
            root = (a + b) / 2;
            y = f(root);
            if (Math.abs(y) < EPS) {
                break;
            }
            if (f(a) * y < 0.0) {
                b = root;
            }
            else {
                a = root;
            }
        } while(Math.abs(b-a) >= EPS);
    }

    public static void main(String[] args){
        Bisection2 bisection2 = new Bisection2();
        bisection2.bisect();
        System.out.println("x = " + bisection2.getRoot() + ", f(x) = " + bisection2.f(bisection2.getRoot()));
    }
}
