package opennlp.tools.textsimilarity;

/**
 * 
 * @author Albert-Jan de Vries
 * 
 */
public class LemmaPair
{
	private String POS;

	private String lemma;

	private int startPos;

	int endPos;

	public LemmaPair(String POS, String lemma, int startPos)
	{

		this.POS = POS;
		this.lemma = lemma;
		this.startPos = startPos;
	}

	public LemmaPair(String POS, String lemma)
	{
		this.POS = POS;
		this.lemma = lemma;
	}

	public String getPOS()
	{
		return POS;
	}

	public void setPOS(String pOS)
	{
		POS = pOS;
	}

	public String getLemma()
	{
		return lemma;
	}

	public void setLemma(String lemma)
	{
		this.lemma = lemma;
	}

	public int getStartPos()
	{
		return startPos;
	}

	public void setStartPos(int startPos)
	{
		this.startPos = startPos;
	}

	public int getEndPos()
	{
		return endPos;
	}

	public void setEndPos(int endPos)
	{
		this.endPos = endPos;
	}

	public String toString()
	{
		return this.getStartPos() + "(" + POS + "-" + lemma + ")";
	}
}
