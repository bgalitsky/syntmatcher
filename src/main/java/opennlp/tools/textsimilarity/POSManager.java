package opennlp.tools.textsimilarity;


public class POSManager
{
	public POSManager()
	{

	}

	public String similarPOS(String pos1, String pos2)
	{
		if ((pos1.startsWith("NN") && pos2.equals("NP") || pos2.startsWith("NN") && pos1.equals("NP")))
		{
			return "NN";
		}
		if ((pos1.startsWith("NN") && pos2.equals("VBG") || pos2.startsWith("VBG") && pos1.equals("NN")))
		{
			return "NN";
		}

		if ((pos1.startsWith("NN") && pos2.equals("ADJP") || pos2.startsWith("NN") && pos1.equals("ADJP")))
		{
			return "NN";
		}
		if ((pos1.equals("IN") && pos2.equals("TO") || pos1.equals("TO") && pos2.equals("IN")))
		{
			return "IN";
		}
		// VBx vs VBx = VB (does not matter which form for verb)
		if (pos1.startsWith("VB") && pos2.startsWith("VB"))
		{
			return "VB";
		}

		// ABx vs ABy always gives AB
		if (pos1.equalsIgnoreCase(pos2))
		{
			return pos1;
		}
		if (pos1.length() > 2)
		{
			pos1 = pos1.substring(0, 2);
		}

		if (pos2.length() > 2)
		{
			pos2 = pos2.substring(0, 2);
		}
		if (pos1.equalsIgnoreCase(pos2))
		{
			return pos1 + "*";
		}
		return null;
	}

}
