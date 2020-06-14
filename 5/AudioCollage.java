public class AudioCollage
{
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha)
    {
        double [] b = new double[a.length];

        for (int i = 0; i < a.length; i++)
        {
            b[i] = a[i] * alpha;
        }

        return b;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a)
    {
        double [] b = new double[a.length];

        for (int i = 0; i < a.length; i++)
        {
            b[i] = a[a.length - i - 1];
        }

        return b;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b)
    {
        double [] c = new double[a.length + b.length];

        for (int i = 0; i < a.length; i++)
        {
            c[i] = a[i];
        }

        for (int i = 0; i < b.length; i++)
        {
            c[i + a.length] = b[i];
        }

        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b)
    {
        if (a.length < b.length)
        {
            double [] c = new double[b.length];
            double [] d = new double[b.length];

            for (int i = 0; i < a.length; i++)
            {
                c[i] = a[i];
            }

            for (int j = 0; j < b.length; j++)
            {
                d[j] = b[j] + c[j];
            }

            return d;
        }
        if (a.length > b.length)
        {
            double [] c = new double[a.length];
            double [] d = new double[a.length];

            for (int i = 0; i < b.length; i++)
            {
                c[i] = b[i];
            }

            for (int j = 0; j < a.length; j++)
            {
                d[j] = a[j] + c[j];
            }

            return d;
        }
        double [] d = new double[b.length];

        for (int i = 0; i < a.length; i++)
        {
            d[i] = a[i] + b[i];
        }

        return d;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha)
    {
        double [] b = new double[(int) (a.length / alpha)];

        for (int i = 0; i < b.length; i++)
        {
            b[i] = a[(int) (i * alpha)];
        }

        return b;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args)
    {
        double[] sample1 = amplify(StdAudio.read("cow.wav"), 5);
        if (sample1.length >= 441000 && sample1.length <= 2646000)
        {
            boolean inRange = true;
            for (int i = 0; i < sample1.length; i++)
            {
                if (Math.abs(sample1[i]) > 1)
                {
                    inRange = false;
                    break;
                }
            }

            if (inRange)
                StdAudio.play(sample1);
        }


        double[] sample2 = reverse(StdAudio.read("piano.wav"));
        if (sample2.length >= 441000 && sample2.length <= 2646000)
        {
            boolean inRange = true;
            for (int i = 0; i < sample2.length; i++)
            {
                if (Math.abs(sample2[i]) > 1)
                {
                    inRange = false;
                    break;
                }
            }

            if (inRange)
                StdAudio.play(sample2);
        }

        double[] sample3 = merge(StdAudio.read("singer.wav"), StdAudio.read("buzzer.wav"));
        if (sample3.length >= 441000 && sample3.length <= 2646000)
        {
            boolean inRange = true;
            for (int i = 0; i < sample3.length; i++)
            {
                if (Math.abs(sample3[i]) > 1)
                {
                    inRange = false;
                    break;
                }
            }

            if (inRange)
                StdAudio.play(sample3);
        }

        double[] sample4 = mix(StdAudio.read("dialup.wav"), StdAudio.read("scratch.wav"));
        if (sample4.length >= 441000 && sample4.length <= 2646000)
        {
            boolean inRange = true;
            for (int i = 0; i < sample4.length; i++)
            {
                if (Math.abs(sample4[i]) > 1)
                {
                    inRange = false;
                    break;
                }
            }

            if (inRange)
                StdAudio.play(sample4);
        }

        double[] sample5 = changeSpeed(StdAudio.read("piano.wav"), 0.50);
        if (sample5.length >= 441000 && sample5.length <= 2646000)
        {
            boolean inRange = true;
            for (int i = 0; i < sample5.length; i++)
            {
                if (Math.abs(sample5[i]) > 1)
                {
                    inRange = false;
                    break;
                }
            }

            if (inRange)
                StdAudio.play(sample5);
        }
    }
}
