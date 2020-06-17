public class Ramanujan
{
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n)
    {
        long a = 1;
        long b = (long) (Math.cbrt(n - a * a * a));
        int count = 0;

        while (b > a)
        {
            if ((a * a * a + b * b * b == n) && (a != b))
            {
                count++;
            }

            a++;
            b = (long) (Math.cbrt(n - a * a * a));
        }

        return count >= 2;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args)
    {
        long n = Long.parseLong(args[0]);

        StdOut.println(isRamanujan(n));
    }
}
