package opennlp.tools.textsimilarity;

import java.util.Comparator;

public class ParseTreeChunkComparable implements Comparator<ParseTreeChunk>
{
	public int compare(ParseTreeChunk ch1, ParseTreeChunk ch2)
	{
		for (int i = 0; i < ch1.getLemmas().size() && i < ch2.getLemmas().size(); i++)
		{
			if (!(ch1.getLemmas().get(i).equals(ch2.getLemmas().get(i)) && ch1.getPOSs().get(i)
				.equals(ch2.getPOSs().get(i))))
				return -1;
		}
		return 0;

	}
}
