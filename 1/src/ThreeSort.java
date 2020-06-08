public class ThreeSort
{
    public static void main(String[] args)
    {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);

        int minimum = Math.min(num1, num2);
        minimum = Math.min(minimum, num3);

        int maximum = Math.max(num1, num2);
        maximum = Math.max(maximum, num3);

        int middle = num1 + num2 + num3 - minimum - maximum;

        System.out.println(minimum);
        System.out.println(middle);
        System.out.println(maximum);
    }
}
