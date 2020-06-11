public class RandomWalker
{
    public static void main(String[] args)
    {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int steps = 0;

        System.out.println("(" + x + ", " + y + ")");

        double randNum = Math.random();

        if(randNum < 0.25 && Math.abs(x) < r)
            x++;
        else if(randNum < 0.50 && Math.abs(y) < r )
            y--;
        else if(randNum < 0.75 && Math.abs(x) < r)
            x--;
        else if(Math.abs(y) < r)
            y++;

        if(r != 0)
        {
            System.out.println("(" + x + ", " + y + ")");
            steps++;
        }

        while((Math.abs(x) + Math.abs(y)) != r)
        {
            randNum = Math.random();

            if(randNum < 0.25 && Math.abs(x) < r)
                x++;
            else if(randNum < 0.50 && Math.abs(y) < r )
                y--;
            else if(randNum < 0.75 && Math.abs(x) < r)
                x--;
            else if(Math.abs(y) < r)
                y++;

            System.out.println("(" + x + ", " + y + ")");
            steps++;
        }

        System.out.println("steps = " + steps);
    }
}
