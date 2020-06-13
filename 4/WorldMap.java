public class WorldMap
{
    public static void main(String[] args)
    {
        int witdth = StdIn.readInt();
        int height = StdIn.readInt();

        StdDraw.setCanvasSize(witdth, height);
        StdDraw.setXscale(0, witdth);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty())
        {
            String region = StdIn.readString();

            int numOfVertices = StdIn.readInt();
            double [] xCoordinates = new double[numOfVertices];
            double [] yCoordinates = new double[numOfVertices];

            for (int i = 0; i < numOfVertices; i++)
            {
                xCoordinates[i] = StdIn.readDouble();
                yCoordinates[i] = StdIn.readDouble();
            }

            StdDraw.polygon(xCoordinates, yCoordinates);
        }
    }
}
