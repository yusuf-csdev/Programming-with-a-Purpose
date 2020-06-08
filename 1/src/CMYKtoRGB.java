public class CMYKtoRGB
{
    public static void main(String[] args)
    {
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);

        double white = 1.0 - black;
        long red = Math.round(255.0 * white * (1.0 - cyan));
        long green = Math.round(255.0 * white * (1.0 - magenta));
        long blue = Math.round(255.0 * white * (1.0 - yellow));

        System.out.println("red   = " + red);
        System.out.println("green = " + green);
        System.out.println("blue  = " + blue);
    }
}
