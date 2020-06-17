public class Inversions
{
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a)
    {
        long counter = 0;

        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                if ((i < j) && (a[i] > a[j]))
                {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static int [] switchNums(int[] a, int index_a, int index_b)
    {
        int temp = a[index_a];
        a[index_a] = a[index_b];
        a[index_b] = temp;

        return a;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k)
    {
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++)
        {
            a[i] = i;
        }

        int j = 0;
        int temp = 0;

        for (int i = 0; i < k; i++)
        {
            a = switchNums(a, a.length - j - 2, a.length - j - 1);
            j++;

            if (j > a.length - 2 - temp)
            {
                j = 0;
                temp++;
            }
        }

        return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        int [] a = generate(n, k);

        for (int i = 0; i < n; i++)
        {
            StdOut.print(a[i] + " ");
        }

        StdOut.println();

        // StdOut.println(count(a));
    }
}
