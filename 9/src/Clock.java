public class Clock
{
    private int myH;
    private int myM;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m)
    {
        if (h < 0 || h > 23 || m < 0 || m > 59)
        {
            throw new IllegalArgumentException("Numbers are out of bounds");
        }

        myH = h;
        myM = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s)
    {
        if (s.length() != 5 || !s.contains(":"))
            throw new IllegalArgumentException("Not in correct format");

        int hour = Integer.parseInt(s.substring(0, 2));
        int minute = Integer.parseInt(s.substring(3, 5));

        if (hour < 0 || hour > 23 || minute < 0 || minute > 59)
        {
            throw new IllegalArgumentException("Numbers are out of bounds");
        }

        myH = hour;
        myM = minute;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString()
    {
        String min = "";
        String hour = "";

        if (myM < 10)
            min = "0" + myM;
        else
            min = "" + myM;
        if (myH < 10)
            hour = "0" + myH;
        else
            hour = "" + myH;

        return (hour + ":" + min);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that)
    {
        if (this.myH < that.myH)
        {
            return true;
        }
        else if ((this.myH == that.myH) && (this.myM < that.myM))
        {
            return true;
        }
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic()
    {
        if (myM == 59)
        {
            myM = 0;
            myH += 1;

            if (myH == 24)
                myH = 0;
        }
        else
        {
            myM += 1;
        }

        return;
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta)
    {
        if (delta < 0)
            throw new IllegalArgumentException("Delta cannot be negative");

        int d = delta;

        while (d != 0)
        {
            tic();
            d--;
        }
    }

    // Test client (see below).
    public static void main(String[] args)
    {
        Clock firstClock = new Clock(10, 23);
        Clock secondClock = new Clock("23:59");

        StdOut.println(firstClock);
        StdOut.println(firstClock.isEarlierThan(secondClock));
        secondClock.tic();

        StdOut.println(secondClock);
        firstClock.toc(97);
        StdOut.println(firstClock);
    }
}
