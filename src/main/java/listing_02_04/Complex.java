package listing_02_04;

public class Complex {
    private static final double EPS = 1e-12;
    private double re;
    private double im;

    Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    Complex(double re) {
        this(re, 0.0);
    }

    Complex() {
        this(0.0, 0.0);
    }

    Complex(Complex z) {
        this(z.re, z.im);
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public Complex getZ() {
        return new Complex(re, im);
    }

    public void setRe(double re) {
        this.re = re;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public void setZ(Complex z) {
        this.re = z.re;
        this.im = z.im;
    }

    public double mod() {
        return Math.sqrt(re * re + im * im);
    }

    public double arg() {
        return Math.atan2(im, re);
    }

    public boolean isReal() {
        return Math.abs(im) < EPS;
    }

    public void pr() {
        System.out.println(re + (im < 0.0 ? "" : "+") + im + "i");
    }

    public boolean equals(Complex z) {
        return Math.abs(re - z.re) < EPS && Math.abs(im - z.im) < EPS;
    }

    public String toString() {
        return "Complex: " + re + " " + im;
    }

    public void add(Complex z) {
        this.re += z.re;
        this.im += z.im;
    }

    public void sub(Complex z) {
        this.re -= z.re;
        this.im -= z.im;
    }

    public void mul(Complex z) {
        double re = this.re * z.re - this.im * z.im;
        this.im = this.re * z.im + this.im * z.re;
        this.re = re;
    }

    public void div(Complex z) {
        double denominator = z.re * z.re + z.im * z.im;
        double numeratorOfRe = this.re * z.re + this.im * z.im;
        this.im = (this.im * z.re - this.re * z.im) / denominator;
        this.re = numeratorOfRe / denominator;
    }

    public Complex plus(Complex z) {
        return new Complex(this.re + z.re, this.im + z.im);
    }

    public Complex minus(Complex z) {
        return new Complex(this.re - z.re, this.im - z.im);
    }

    public Complex asterisk(Complex z) {
        return new Complex( this.re * z.re - this.im * z.im, this.re * z.im + this.im * z.re);
    }

    public Complex slash(Complex z) {
        double denominator = z.re * z.re + z.im * z.im;
        return new Complex(
                (this.re * z.re + this.im * z.im) / denominator,
                (this.im * z.re - this.re * z.im) / denominator);
    }
}