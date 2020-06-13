public class ShannonEntropy
{
    public static void main(String[] args)
    {
        int m = Integer.parseInt(args[0]);
        int n = 0;
        double result = 0;
        int [] numbers = new int[m + 1];

        while (!StdIn.isEmpty())
        {
            int x = StdIn.readInt();

            if (x >= 1 && x <= m)
            {
                numbers[x]++;
                n++;
            }
        }

        for (int i = 1; i < m + 1; i++)
        {
            int xi = numbers[i];
            double pi = (double) xi / n;
            if (pi > 0)
            {
                result += (pi) * (Math.log(pi) / Math.log(2));
            }
        }

        result = -result;

        StdOut.printf("%.4f\n", result);
    }
}
