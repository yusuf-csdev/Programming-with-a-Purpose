public class UniformRandomNumbers
{
    public static void main(String[] args)
    {
        double r1 = Math.random();
        double r2 = Math.random();
        double r3 = Math.random();
        double r4 = Math.random();
        double r5 = Math.random();

        System.out.println("Five random numbers between 0 and 1 are: ");
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);

        double average = (r1 + r2 + r3 + r4 + r5) / 5.0;
        System.out.println("The average of five numbers is: " + average);

        double minimum = Math.min(r1, r2);
        minimum = Math.min(r3, minimum);
        minimum = Math.min(r4, minimum);
        minimum = Math.min(r5, minimum);
        System.out.println("The minimum of five numbers is: " + minimum);

        double maximum = Math.max(r1, r2);
        maximum = Math.max(r3, maximum);
        maximum = Math.max(r4, maximum);
        maximum = Math.max(r5, maximum);
        System.out.println("The maximum of five numbers is: " + maximum);
    }
}
