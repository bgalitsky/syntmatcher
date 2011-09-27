package opennlp.tools.similarity.apps;

import java.util.Comparator;

public class YahooHitComparable implements Comparator<YahooHit>
{
	@Override
	public int compare(YahooHit o1, YahooHit o2)
	{
		return (o1.getGenerWithQueryScore() > o2.getGenerWithQueryScore() ? -1 : (o1 == o2 ? 0 : 1));
	}
}