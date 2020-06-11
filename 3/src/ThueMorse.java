public class ThueMorse
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int [] morseArray = new int[n];

        for (int i = 0; i < n; i++)
        {
            if (i == 0)
                morseArray[i] = 0;
            else if (i % 2 == 0)
                morseArray[i] = morseArray[i/2];
            else
                morseArray[i] = 1 - morseArray[i - 1];
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (morseArray[i] == morseArray[j])
                {
                    System.out.print("+  ");
                }
                else
                {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}
