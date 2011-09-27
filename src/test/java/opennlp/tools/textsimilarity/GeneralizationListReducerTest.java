package opennlp.tools.textsimilarity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GeneralizationListReducerTest
{
	private GeneralizationListReducer generalizationListReducer = new GeneralizationListReducer();

	@Test
	public void test()
	{
		ParseTreeChunk ch1 = new ParseTreeChunk("VP", new String[] { "run", "around", "tigers", "zoo" }, new String[] {
			"VB", "IN", "NP", "NP" });

		ParseTreeChunk ch2 = new ParseTreeChunk("NP", new String[] { "run", "around", "tigers" }, new String[] { "VB",
			"IN", "NP", });

		ParseTreeChunk ch3 = new ParseTreeChunk("NP", new String[] { "the", "tigers" }, new String[] { "DT", "NP", });

		ParseTreeChunk ch4 = new ParseTreeChunk("NP", new String[] { "the", "*", "flying", "car" }, new String[] {
			"DT", "NN", "VBG", "NN" });

		ParseTreeChunk ch5 = new ParseTreeChunk("NP", new String[] { "the", "*" }, new String[] { "DT", "NN", });

		// [DT-the NN-* VBG-flying NN-car ], [], [], [DT-the NN-* ]]

		List<ParseTreeChunk> inp = new ArrayList<ParseTreeChunk>();
		inp.add(ch1);
		inp.add(ch2);
		inp.add(ch5);
		inp.add(ch3);
		inp.add(ch2);
		inp.add(ch2);
		inp.add(ch3);
		inp.add(ch4);

		Boolean b = ch1.isASubChunk(ch2);
		b = ch2.isASubChunk(ch1);
		b = ch5.isASubChunk(ch4);
		b = ch4.isASubChunk(ch5);

		List<ParseTreeChunk> res = generalizationListReducer.applyFilteringBySubsumption(inp);
		System.out.println(res);

	}
}
