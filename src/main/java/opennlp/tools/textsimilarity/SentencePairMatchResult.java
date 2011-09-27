package opennlp.tools.textsimilarity;

import java.util.List;

import org.apache.commons.lang.StringUtils;

public class SentencePairMatchResult
{
	public List<List<ParseTreeChunk>> matchResult;

	public List<List<ParseTreeChunk>> getMatchResult()
	{
		return matchResult;
	}

	public void setMatchResult(List<List<ParseTreeChunk>> matchResult)
	{
		this.matchResult = matchResult;
	}

	public List<LemmaPair> getResForMinedSent1()
	{
		return resForMinedSent1;
	}

	public void setResForMinedSent1(List<LemmaPair> resForMinedSent1)
	{
		this.resForMinedSent1 = resForMinedSent1;
	}

	public boolean isVerbExists()
	{
		return verbExists;
	}

	public void setVerbExists(boolean verbExists)
	{
		this.verbExists = verbExists;
	}

	public boolean isImperativeVerb()
	{
		return imperativeVerb;
	}

	public void setImperativeVerb(boolean imperativeVerb)
	{
		this.imperativeVerb = imperativeVerb;
	}

	private List<LemmaPair> resForMinedSent1;

	public boolean verbExists = false;

	public boolean imperativeVerb = false;

	public SentencePairMatchResult(List<List<ParseTreeChunk>> matchResult, List<LemmaPair> resForMinedSent1)
	{
		super();
		verbExists = false;
		imperativeVerb = false;
		System.out.println("Assessing sentence for inclusion " + resForMinedSent1);
		this.matchResult = matchResult;
		this.resForMinedSent1 = resForMinedSent1;
		for (LemmaPair word : resForMinedSent1)
		{
			if (word.getPOS().startsWith("VB") && word.getLemma().length() > 2 && StringUtils.isAlpha(word.getLemma()))
			{// || word.getPOS().startsWith("VP"))
				verbExists = true;
				System.out.println("Found verb=" + word);
			}
		}
		// various form of sales pitch: 'get something', or 'we offer'
		if (resForMinedSent1.get(1).getLemma().startsWith("We") || resForMinedSent1.get(2).getLemma().startsWith("We"))
			imperativeVerb = true;
		for (LemmaPair word : resForMinedSent1)
		{
			if (word.getPOS().startsWith("VB") && word.getStartPos() < 1 && word.getEndPos() < 1)
			{
				imperativeVerb = true;
				System.out.println("Found imperative verb=" + word);
			}
		}

	}

}
