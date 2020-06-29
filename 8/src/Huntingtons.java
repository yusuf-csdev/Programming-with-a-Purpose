public class Huntingtons
{
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna)
    {
        int maxRepeats = 0;

        for (int i = 0; i < dna.length() - 2; i++)
        {
            int repeats = 0;
            String codon = dna.substring(i, i + 3);

            if (codon.equals("CAG"))
            {
                repeats++;

                for (int j = i + 3; j < dna.length() - 2; j += 3)
                {
                    String codonNext = dna.substring(j, j + 3);

                    if (codonNext.equals("CAG"))
                    {
                        repeats++;
                    }
                    else
                    {
                        break;
                    }
                }
                if(repeats > maxRepeats)
                    maxRepeats = repeats;
            }
        }

        return maxRepeats;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s)
    {
        s = s.replace(" ", "");
        s = s.replace("\n", "");
        s = s.replace("\t", "");
        return s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats)
    {
        if (maxRepeats < 10)
            return "not human";
        if (maxRepeats < 36)
            return "normal";
        if (maxRepeats < 40)
            return "high risk";
        if (maxRepeats < 181)
            return "Huntington\'s";
        return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        String dna = in.readAll();
        dna = removeWhitespace(dna);
        int maxRepeats = maxRepeats(dna);
        String diagnose = diagnose(maxRepeats);
        StdOut.println("max repeats = " + maxRepeats);
        StdOut.println(diagnose);
    }
}
