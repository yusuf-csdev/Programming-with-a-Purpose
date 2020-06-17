public class MaximumSquareSubmatrix
{
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a)
    {
        int [][] b = new int[a.length][a.length];

        for (int i = 0; i < a.length; i++)
        {
            b[0][i] = a[0][i];
            b[i][0] = a[i][0];
        }

        for (int i = 1; i < a.length; i++)
        {
            for (int j = 1; j < a.length; j++)
            {
                if (a[i][j] == 1)
                {
                    int x = i;
                    int y = j;

                    int prevSize = b[i - 1][j - 1];

                    boolean square = true;

                    while (x > 0 && prevSize > 0)
                    {
                        x--;
                        prevSize--;
                        if (a[x][y] != 1)
                        {
                            square = false;
                            break;
                        }
                    }

                    prevSize = b[i - 1][j - 1];
                    x = i;

                    while (y > 0 && prevSize > 0)
                    {
                        y--;
                        prevSize--;
                        if (a[x][y] != 1)
                        {
                            square = false;
                            break;
                        }
                    }

                    if (square && b[i - 1][j - 1] > 0)
                    {
                        b[i][j] += b[i - 1][j - 1];
                        b[i][j]++;
                    }
                    else
                    {
                        b[i][j] = 1;
                    }
                }

            }
        }

        int max = 1;

        for (int i = 0; i < b.length; i++)
        {
            for (int j = 0; j < b.length; j++)
            {
                if (b[i][j] > max)
                {
                    max = b[i][j];
                }

            }
        }

        return max;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args)
    {
        int n = StdIn.readInt();

        int [][] a = new int[n][n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (!StdIn.isEmpty())
                {
                    a[i][j] = StdIn.readInt();
                }
            }
        }

        StdOut.println(size(a));
    }
}
