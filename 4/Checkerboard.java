public class Checkerboard
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if ((j % 2 == 0 && i % 2 == 0) || (j % 2 == 1 && i % 2 == 1))
                {
                    // StdOut.println("i = " + i + " j = " + j + " color = blue");
                    StdDraw.setPenColor(StdDraw.BLUE);
                }
                else
                {
                    // StdOut.println("i = " + i + " j = " + j + " color = gray");
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
        }
    }
}
