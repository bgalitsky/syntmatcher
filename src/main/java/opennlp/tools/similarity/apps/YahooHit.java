package opennlp.tools.similarity.apps;

public class YahooHit extends HitBase implements Comparable<YahooHit>
{

	public YahooHit(String orig, String[] generateds)
	{
		super(orig, generateds);

	}

	int originalRank = -1;

	int taxoScore = 0;

	public YahooHit()
	{
	};

	public int getOriginalRank()
	{
		return originalRank;
	}

	public void setOriginalRank(int originalRank)
	{
		this.originalRank = originalRank;
	}

	public String processSnapshotForMatching(String snapshot)
	{
		snapshot = snapshot.replace("<b>...</b>", ". ").replace("<b>", "").replace("</b>", "").replace(". . ", " ")
			.replace(" . . . ", " ").replace("...", " ").replace(",..", " ").replace("&amp;", " ").replace("  ", " ");
		snapshot = snapshot.replace('\'', ' ').replace('-', ' ');

		return snapshot;
	}

	public int getTaxoScore()
	{
		return taxoScore;
	}

	public void setTaxoScore(int taxoScore)
	{
		this.taxoScore = taxoScore;
	}

	@Override
	public int compareTo(YahooHit obj)
	{
		YahooHit tmp = (YahooHit) obj;
		if (this.taxoScore > tmp.taxoScore)
		{
			return -1;
		}
		else if (this.taxoScore < tmp.taxoScore)
		{
			return 1;
		}
		return 0;
	}

}
