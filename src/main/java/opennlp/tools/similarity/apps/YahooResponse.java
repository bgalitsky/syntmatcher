package opennlp.tools.similarity.apps;

import java.util.ArrayList;
import java.util.List;

public class YahooResponse extends YahooResponseBase
{
	private List<HitBase> hits;

	public YahooResponse()
	{
		hits = new ArrayList<HitBase>();
	}

	public void appendHits(HitBase hit)
	{
		hits.add(hit);
	}

	public List<HitBase> getHits()
	{
		return hits;
	}

	public void setHits(List<HitBase> hits)
	{
		this.hits = hits;
	}

}
