public class RandomWalkers
{
    public static void main(String[] args)
    {
        int r = Integer.parseInt(args[0]);
        int trails = Integer.parseInt(args[1]);
        double totalSteps = 0.0;
        int temp = trails;

        while(temp > 0)
        {
            int x = 0;
            int y = 0;
            int steps = 0;

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
                steps++;

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

                steps++;
            }

            totalSteps += steps;
            temp--;
        }

        System.out.println("average number of steps = " + totalSteps / trails);
    }
}
