package opennlp.tools.textsimilarity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class ParseTreeChunkTest
{
	private ParseTreeMatcherDeterministic parseTreeMatcher = new ParseTreeMatcherDeterministic();

	private ParseTreeChunk parseTreeChunk = new ParseTreeChunk();

	private ParseTreeChunkListScorer parseTreeChunkListScorer = new ParseTreeChunkListScorer();

	@Test
	public void test()
	{
		ParseTreeChunk ch1, ch2;
		List<List<ParseTreeChunk>> chRes;

		ch1 = parseTreeChunk
			.obtainParseTreeChunkListByParsingList(
				"[[ [NN-* IN-in NP-israel ],  [NP-* IN-in NP-israel ],  [NP-* IN-* TO-* NN-* ],  [NN-visa IN-* NN-* IN-in ]], [ [VB-get NN-visa IN-* NN-* IN-in .-* ],  [VBD-* IN-* NN-* NN-* .-* ],  [VB-* NP-* ]]]")
			.get(0).get(0);
		;

		// NP [JJ-great JJ-unsecured NN-loan NNS-deals ]
		// NP [JJ-great NN-pizza NNS-deals ]
		ch1 = new ParseTreeChunk("NP", new String[] { "great", "unsecured", "loan", "deals" }, new String[] { "JJ",
			"JJ", "NN", "NNS" });
		ch2 = new ParseTreeChunk("NP", new String[] { "great", "pizza", "deals" }, new String[] { "JJ", "NN", "NNS" });
		assertEquals(parseTreeMatcher.generalizeTwoGroupedPhrasesDeterministic(ch1, ch2).toString(),
			"[ [JJ-great NNS-deals ]]");

		ch1 = new ParseTreeChunk("NP", new String[] { "great", "unsecured", "loan", "of", "jambo" }, new String[] {
			"JJ", "JJ", "NN", "IN", "NN" });

		ch2 = new ParseTreeChunk("NP", new String[] { "great", "jambo", "loan" }, new String[] { "JJ", "NN", "NN" });
		assertEquals(parseTreeMatcher.generalizeTwoGroupedPhrasesDeterministic(ch1, ch2).toString(),
			"[ [JJ-great NN-loan ],  [NN-jambo ]]");

		ch1 = new ParseTreeChunk("NP", new String[] { "I", "love", "to", "run", "around", "zoo", "with", "tigers" },
			new String[] { "NP", "VBP", "TO", "VB", "IN", "NP", "IN", "NP" });

		ch2 = new ParseTreeChunk("NP", new String[] { "I", "like", "it", "because", "it", "is", "loud" }, new String[] {
			"NP", "IN", "NP", "IN", "NP", "VBZ", "ADJP" });
		assertEquals(parseTreeMatcher.generalizeTwoGroupedPhrasesDeterministic(ch1, ch2).toString(), "[ [NP-i ]]");

		ch1 = new ParseTreeChunk("NP", new String[] { "love", "to", "run", "around", "zoo", "with", "tigers" },
			new String[] { "VBP", "TO", "VB", "IN", "NP", "IN", "NP" });

		ch2 = new ParseTreeChunk("VP", new String[] { "run", "to", "the", "tiger", "zoo" }, new String[] { "VBP", "TO",
			"DT", "NN", "NN" });
		assertEquals(parseTreeMatcher.generalizeTwoGroupedPhrasesDeterministic(ch1, ch2).toString(),
			"[ [VBP-* TO-to ],  [VB-run IN-* NP-zoo ],  [NP-tigers ]]");

		ch1 = new ParseTreeChunk("VP", new String[] { "love", "to", "run", "around", "tigers", "zoo" }, new String[] {
			"VBP", "TO", "VB", "IN", "NP", "NP" });
		ch2 = new ParseTreeChunk("VP", new String[] { "run", "to", "the", "tiger", "zoo" }, new String[] { "VBP", "TO",
			"DT", "NN", "NN" });
		assertEquals(parseTreeMatcher.generalizeTwoGroupedPhrasesDeterministic(ch1, ch2).toString(),
			"[ [VBP-* TO-to ],  [VB-run IN-* NP-tigers NP-zoo ]]");
		ch1 = new ParseTreeChunk("VP", new String[] { "run", "around", "tigers", "zoo" }, new String[] { "VB", "IN",
			"NP", "NP" });

		ch2 = new ParseTreeChunk("NP", new String[] { "run", "to", "the", "tiger", "zoo" }, new String[] { "VBP", "TO",
			"DT", "NN", "NN" });

		assertEquals(parseTreeMatcher.generalizeTwoGroupedPhrasesDeterministic(ch1, ch2).toString(),
			"[ [VB-run IN-* NP-tigers NP-zoo ]]");

		List<List<ParseTreeChunk>> lch1 = parseTreeChunk
			.obtainParseTreeChunkListByParsingList("[[[DT-all NNS-children WHNP-who VBP-are CD-four NNS-years JJ-old IN-on CC-or IN-before NP-September ]]]");
		List<List<ParseTreeChunk>> lch2 = parseTreeChunk
			.obtainParseTreeChunkListByParsingList("[[[NP-Children CD-four NNS-years JJ-old ]]]");

		chRes = parseTreeMatcher.matchTwoSentencesGroupedChunksDeterministic(lch1, lch2);
		System.out.println("generalization result = " + chRes + " score  ="
			+ parseTreeChunkListScorer.getParseTreeChunkListScore(chRes));
		assertEquals(chRes.toString(), "[[ [NNS-children CD-four NNS-years JJ-old ]]]");
		assertTrue(parseTreeChunkListScorer.getParseTreeChunkListScore(chRes) > 3);

	}

}
