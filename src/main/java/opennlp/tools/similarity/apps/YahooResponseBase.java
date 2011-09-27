package opennlp.tools.similarity.apps;

public class YahooResponseBase
{
	private int responseCode;

	private String nextPageUrl;

	private int totalHits;

	private int deepHits;

	private int startIndex;

	private int pageSize;

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
