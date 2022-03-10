package part1.ch3_lambda_expressions;

import java.util.function.DoubleFunction;

public class ExampleLambda {

    // example of a linear function: f(x) = x + 10
    public static double f1(double x) {
        return x + 10;
    }

    // this does not work (it's a shame):
    // double integrate((double -> double) f, double a, double b)
    // because lambda expressions can only be used in a context expecting a functional interface, like this:
    public static double integrate(DoubleFunction<Double> f, double a, double b) {
        return (f.apply(a) + f.apply(b)) * (b - a) / 2.0;
    }

    public static void main(String[] args) {
        double c;
        c = integrate((x) -> f1(x), 3, 7);
        // or:
        c = integrate((x) -> x + 10, 3, 7);
        System.out.println("Integrate f(x) = x + 10 , 3, 7 = " + c);
    }
}
