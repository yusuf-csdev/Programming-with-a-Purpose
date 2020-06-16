public class RevesPuzzle
{
    private static void stewart(int n, String from, String temp1, String temp2, String to)
    {
        if (n == 0) return;
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

        stewart(k, from, to, temp2, temp1);
        hanoi(n, k, from, temp2, to);
        stewart(k, temp1, from, temp2, to);
    }

    private static void hanoi(int n, int k, String from, String temp, String to)
    {
        if (n == k) return;
        hanoi(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }


    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);

        stewart(n, "A", "B", "C", "D");
    }
}
