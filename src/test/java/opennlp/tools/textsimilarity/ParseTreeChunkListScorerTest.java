package opennlp.tools.textsimilarity;

import java.util.List;

import org.junit.Test;

public class ParseTreeChunkListScorerTest
{
	private ParseTreeChunkListScorer parseTreeChunkListScorer = new ParseTreeChunkListScorer();

	private ParseTreeChunk parseTreeChunk = new ParseTreeChunk();

	@Test
	public void test()
	{
		List<List<ParseTreeChunk>> chs = parseTreeChunk
			.obtainParseTreeChunkListByParsingList("[[ [NN-* IN-in NP-israel ],  [NP-* IN-in NP-israel ],  [NP-* IN-* TO-* NN-* ],  [NN-visa IN-* NN-* IN-in ]],"
				+ " [ [VB-get NN-visa IN-* NN-* IN-in .-* ],  [VBD-* IN-* NN-* NN-* .-* ],  [VB-* NP-* ]]]");

		double sc = parseTreeChunkListScorer.getParseTreeChunkListScore(chs);

	}
}
