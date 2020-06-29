public class ColorHSB
{
    private static final int ARCH_FULL_CIRCLE = 360;
    private final int hue, saturation, brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b)
    {
        if (0 > h || h >= ARCH_FULL_CIRCLE || 0 > s || s > 100 || 0 > b || b > 100)
        {
            throw new IllegalArgumentException("Please check the format of input");
        }
        hue = h;
        saturation = s;
        brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString()
    {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale()
    {
        return this.brightness == 0 || this.saturation == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that)
    {
        if (that == null)
        {
            throw new IllegalArgumentException();
        }

        int h2 = that.hue;
        int s2 = that.saturation;
        int b2 = that.brightness;

        int h1 = this.hue;
        int s1 = this.saturation;
        int b1 = this.brightness;

        return Math.min((h1 - h2) * (h1 - h2), (ARCH_FULL_CIRCLE - Math.abs(h1 - h2)) * (ARCH_FULL_CIRCLE - Math.abs(h1 - h2)))
                + (s1 - s2) * (s1 - s2) + (b1 - b2) * (b1 - b2);
    }

    // Sample client (see below).
    public static void main(String[] args)
    {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        ColorHSB color = new ColorHSB(h, s, b);

        int minDistance = ARCH_FULL_CIRCLE * ARCH_FULL_CIRCLE + 100 * 100 * 2;
        String closetColorName = "";
        ColorHSB closestColor = color;

        while (!StdIn.isEmpty())
        {
            String name = StdIn.readString();
            int h2 = StdIn.readInt();
            int s2 = StdIn.readInt();
            int b2 = StdIn.readInt();
            ColorHSB currentColor = new ColorHSB(h2, s2, b2);

            int distance = color.distanceSquaredTo(currentColor);

            if (distance < minDistance)
            {
                minDistance = distance;
                closetColorName = name;
                closestColor = currentColor;
            }
        }

        StdOut.println(closetColorName + " " + closestColor);
    }
}
