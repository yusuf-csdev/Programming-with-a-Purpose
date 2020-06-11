public class DiscreteDistribution
{
    public static void main(String[] args)
    {
        int m = Integer.parseInt(args[0]);
        int [] sums = new int[args.length];
        sums[0] = 0;


        for (int i = 1; i < args.length; i++)
        {
            sums[i] = sums[i - 1] + Integer.parseInt(args[i]);
        }

        for (int j = 0; j < m; j++)
        {
            int r = (int) (Math.random() * sums[args.length - 1]);

            for (int k = 1; k < sums.length; k++)
            {
                if (r < sums[k])
                {
                    System.out.print(k + " ");
                    if ((j + 1) % 25 == 0)
                    {
                        System.out.println();
                    }
                    break;
                }
            }
        }
    }
}
