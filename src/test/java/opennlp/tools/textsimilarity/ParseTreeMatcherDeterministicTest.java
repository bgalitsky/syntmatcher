package opennlp.tools.textsimilarity;

import org.junit.Test;

public class ParseTreeMatcherDeterministicTest
{

	private ParseTreeMatcherDeterministic parseTreeMatcherDeterministic = new ParseTreeMatcherDeterministic();

	@Test
	public void test()
	{

		ParseTreeChunk ch1 = new ParseTreeChunk("NP", new String[] { "love", "to", "run", "around", "zoo", "with",
			"tigers" }, new String[] { "VBP", "TO", "VB", "IN", "NP", "IN", "NP" });

		ParseTreeChunk ch2 = new ParseTreeChunk("VP", new String[] { "run", "to", "the", "tiger", "zoo" },
			new String[] { "VBP", "TO", "DT", "NN", "NN" });
		/*
		 * System.out.println(ParseTreeMatcherDeterministic.generalizeTwoGroupedPhrasesDeterministic(ch1, ch2));
		 * 
		 * ch1 = ParseTreeChunk.obtainParseTreeChunkListByParsingList(
		 * "[[[DT-all NNS-children WHNP-who VBP-are CD-four NNS-years JJ-old IN-on CC-or IN-before NP-September ]]]"
		 * ).get(0).get(0); ch2 = ParseTreeChunk.obtainParseTreeChunkListByParsingList(
		 * "[[[NP-Children CD-four NNS-years JJ-old ]]]").get(0).get(0);
		 * System.out.println(ParseTreeMatcherDeterministic.generalizeTwoGroupedPhrasesDeterministic(ch1, ch2));
		 * 
		 * ch1 = new ParseTreeChunk("NP", new String[]{"great", "unsecured", "loan", "deals"}, new String[]{"JJ", "JJ",
		 * "NN", "NNS"}) ; ch2 = new ParseTreeChunk("NP", new String[]{"great", "pizza", "deals"}, new String[]{"JJ",
		 * "NN", "NNS"}) ;
		 * System.out.println(ParseTreeMatcherDeterministic.generalizeTwoGroupedPhrasesDeterministic(ch1, ch2));
		 * 
		 * ch1= ParseTreeChunk.obtainParseTreeChunkListByParsingList(
		 * "[[[NN-visa IN-for JJ-foreign NNS-nationals VBG-traveling TO-to DT-the NNS-Peoples NN-Republic IN-of NP-China]]]"
		 * ).get(0).get(0); ch2= ParseTreeChunk.obtainParseTreeChunkListByParsingList(
		 * "[[[DT-a NN-visa IN-for CD-12 NNS-months TO-to NNS-peoples NN-republic IN-of NP-china IN-in NNP-San NNP-Francisco ]]]"
		 * ).get(0).get(0);
		 * 
		 * System.out.println(ParseTreeMatcherDeterministic.generalizeTwoGroupedPhrasesDeterministic(ch1, ch2)); ch1=
		 * ParseTreeChunk.obtainParseTreeChunkListByParsingList(
		 * "[[[VBG-fixing DT-the NN-damage DT-the JJ-rear NN-Passenger NN-tire WHADVP-where NP-it VBD-was VP-hit VBZ-seems ADJP-uneven ]]]"
		 * ).get(0).get(0); ch2= ParseTreeChunk.obtainParseTreeChunkListByParsingList(
		 * "[[[VBG-fixing DT-the NN-damage DT-the JJ-rear NN-passenger NN-tire ]]]").get(0).get(0);
		 * System.out.println(ParseTreeMatcherDeterministic.generalizeTwoGroupedPhrasesDeterministic(ch1, ch2));
		 */

		// ch1= ParseTreeChunk.obtainParseTreeChunkListByParsingList(
		// "[[NNP-Terrafugia NN-Transition NN-World POS-'s JJ-First NN-Flying NN-Car ]]]").get(0).get(0);
		//

		ParseTreeChunk parseTreeChunk = new ParseTreeChunk();
		ch1 = parseTreeChunk.obtainParseTreeChunkListByParsingList("[[DT-the VBG-flying NN-car ]]").get(0).get(0);
		;
		ch2 = parseTreeChunk
			.obtainParseTreeChunkListByParsingList("[[DT-the NN-world POS-'s JJ-first VBG-flying NN-car ]]]").get(0)
			.get(0);

		System.out.println(parseTreeMatcherDeterministic.generalizeTwoGroupedPhrasesDeterministic(ch1, ch2));
	}
}
