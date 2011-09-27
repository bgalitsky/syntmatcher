package opennlp.tools.similarity.apps;

import java.util.ArrayList;
import java.util.List;

public class BingResponse
{
	List<HitBase> hits;

	int responseCode;

	String nextPageUrl;

	int totalHits;

	int deepHits;

	int startIndex;

	int pageSize;

	public BingResponse()
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

	public int getResponseCode()
	{
		return responseCode;
	}

	public void setResponseCode(int responseCode)
	{
		this.responseCode = responseCode;
	}

	public String getNextPageUrl()
	{
		return nextPageUrl;
	}

	public void setNextPageUrl(String nextPageUrl)
	{
		this.nextPageUrl = nextPageUrl;
	}

	public int getTotalHits()
	{
		return totalHits;
	}

	public void setTotalHits(int totalHits)
	{
		this.totalHits = totalHits;
	}

	public int getDeepHits()
	{
		return deepHits;
	}

	public void setDeepHits(int deepHits)
	{
		this.deepHits = deepHits;
	}

	public int getStartIndex()
	{
		return startIndex;
	}

	public void setStartIndex(int startIndex)
	{
		this.startIndex = startIndex;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

}
