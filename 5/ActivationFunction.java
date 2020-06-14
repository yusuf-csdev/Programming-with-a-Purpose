public class ActivationFunction
{
    // Returns the Heaviside function of x.
    public static double heaviside(double x)
    {
        if (Double.isNaN(x))
            return 0.0 / 0.0;
        if (x < 0)
            return 0.0;
        if (x == 0)
            return 0.5;
        return 1.0;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x)
    {
        if (Double.isNaN(x))
            return 0.0 / 0.0;
        return 1.0 / (1 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x)
    {
        if (Double.isNaN(x))
            return 0.0 / 0.0;
        if (x >= 20)
            return 1.0;
        if (x <= -20)
            return -1.0;
        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x)
    {
        if (Double.isNaN(x))
            return 0.0 / 0.0;
        if (x == Double.POSITIVE_INFINITY)
            return 1.0;
        if (x == Double.NEGATIVE_INFINITY)
            return -1.0;
        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x)
    {
        if (Double.isNaN(x))
            return 0.0 / 0.0;
        if (x <= -2)
            return -1;
        else if (x < 0)
            return x + Math.pow(x, 2) / 4;
        else if (x < 2)
            return x - Math.pow(x, 2) / 4;
        return 1;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args)
    {
        double x = Double.parseDouble(args[0]);

        StdOut.println("heaviside(" + x + ") = " + heaviside(x));
        StdOut.println("sigmoid(" + x + ") = " + sigmoid(x));
        StdOut.println("tanh(" + x + ") = " + tanh(x));
        StdOut.println("softsign(" + x + ") = " + softsign(x));
        StdOut.println("sqnl(" + x + ") = " + sqnl(x));

    }
}
