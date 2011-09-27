/*
 * Copyright Information
 *
 * This code copyright 2007, Masala, Inc.
 *
 * This code contains proprietary information which is a trade secret of Masala, Inc.
 * and also is protected as an unpublished work under applicable copyright law. 
 * Recipients are to retain this code in confidence and are not permitted to use or
 * make copies thereof other than as permitted in a written agreemnet with Masala, Inc.
 *
 */

package opennlp.tools.textsimilarity;

import java.util.Comparator;

public class TokenObject
{
	private String token;

	private String stem;

	private int docFreq;

	private int freq;

	private float tfidf;

	boolean stopWord;

	public TokenObject()
	{
	}

	public TokenObject(String token, String stem, int freq, int docFreq, float tfidf)
	{
		this.token = token;
		this.stem = stem;
		this.freq = freq;
		this.docFreq = docFreq;
		this.tfidf = tfidf;
		this.stopWord = false;
	}

	public TokenObject(String token, String stem)
	{
		this.token = token;
		this.stem = stem;
		this.freq = 0;
		this.docFreq = 0;
		this.tfidf = 0;
	}

	public boolean isStopWord()
	{
		return this.stopWord;
	}

	public void setIsStopWord(boolean val)
	{
		this.stopWord = val;
	}

	public String getToken()
	{
		return this.token;
	}

	public String getStem()
	{
		return this.stem;
	}

	public int getDocFreq()
	{
		return this.docFreq;
	}

	public int getFreq()
	{
		return this.freq;
	}

	public float getTFIDF()
	{
		return this.tfidf;
	}

	public void setDocFreq(int val)
	{
		this.docFreq = val;
	}

	public void setFreq(int val)
	{
		this.freq = val;
	}

	public void setTFIDF(float val)
	{
		this.tfidf = val;
	}

	@Override
	public boolean equals(Object obj)
	{
		return (obj instanceof TokenObject && ((TokenObject) obj).getStem().equals(getStem()));
	}

	public static class sortByDocFreq implements Comparator<TokenObject>
	{
		public int compare(TokenObject a, TokenObject b)
		{

			if (a.docFreq > b.docFreq)
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
	}

	public static class sortByTFIDF implements Comparator<TokenObject>
	{
		public int compare(TokenObject a, TokenObject b)
		{

			if (a.tfidf < b.tfidf)
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
	}
}
