public class Birthday
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int r;

        int[] count = new int[100];

        for (int k = 0; k < trials; k++)
        {
            int[] array = new int[100];
            int stop = array.length;
            array[0] = (int) (Math.random() * (n - 1));

            for (int i = 0; i < stop; i++)
            {
                r = (int) (n * Math.random());
                for (int j = 0; j < i; j++)
                {
                    if (array[j] == r)
                    {
                        stop = 0;
                        count[i] += 1;
                        break;
                    }
                    else
                    {
                        array[i] = r;
                    }
                }
            }

        }

        double fraction = 0;

        for (int i = 1; fraction < 0.5; i++)
        {
            fraction += (double) count[i - 1] / trials;
            System.out.println(i + "\t" + count[i - 1] + "\t" + fraction);
        }
    }
}
