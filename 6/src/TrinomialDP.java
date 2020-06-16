public class TrinomialDP
{
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k)
    {
        k = Math.abs(k);

        long[][] computed = new long[n + 2][k + n + 1];

        computed[0][0] = 1;
        computed[1][0] = 1;

        for (int i = 1; i <= n; i++)
        {
            for (int j = 0; j <= k + (n - i); j++)
            {
                if (j > i)
                {
                    computed[i][j] = 0;
                    continue;
                }

                computed[i][j] = computed[i - 1][Math.abs(j - 1)] + computed[i - 1][j] + computed[i - 1][j + 1];
            }
        }
        return computed[n][k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        StdOut.println(trinomial(n, k));
    }
}
