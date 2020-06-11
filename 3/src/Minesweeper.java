public class Minesweeper
{
    public static void main(String[] args)
    {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        String [][] table = new String[m][n];

        int numOfMines = k;

        while (numOfMines > 0)
        {
            int rowIndex = (int) (Math.random() * m);
            int colIndex = (int) (Math.random() * n);

            if(table[rowIndex][colIndex] != "*  ")
            {
                table[rowIndex][colIndex] = "*  ";
                numOfMines--;
            }
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (table[i][j] != "*  ")
                {
                    int count = 0;
                    if ((j + 1 < n) && table[i][j + 1] == "*  ") // right
                    {
                        count++;
                    }
                    if ((j + 1 < n) && (i + 1 < m) && table[i + 1][j + 1] == "*  ") // right below
                    {
                        count++;
                    }
                    if ((i + 1 < m) && table[i + 1][j] == "*  ") // below
                    {
                        count++;
                    }
                    if ((i + 1 < m) && (j - 1 > -1) && table[i + 1][j - 1] == "*  ") // left below
                    {
                        count++;
                    }
                    if ((j - 1 > -1) && table[i][j - 1] == "*  ") // left
                    {
                        count++;
                    }
                    if ((i - 1 > -1) && (j - 1 > -1) && table[i - 1][j - 1] == "*  ") // left above
                    {
                        count++;
                    }
                    if ((i - 1 > -1) && table[i - 1][j] == "*  ") // above
                    {
                        count++;
                    }
                    if ((i - 1 > -1) && (j + 1 < n) && table[i - 1][j + 1] == "*  ") // right above
                    {
                        count++;
                    }

                    table[i][j] = count + "  ";
                }
            }
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(table[i][j]);
            }

            System.out.println();
        }
    }
}
