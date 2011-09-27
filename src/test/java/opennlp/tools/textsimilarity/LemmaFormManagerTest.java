package opennlp.tools.textsimilarity;

import org.junit.Test;

public class LemmaFormManagerTest
{

	private LemmaFormManager lemmaFormManager = new LemmaFormManager();

	@Test
	public void matches()
	{

		String res = lemmaFormManager.matchLemmas(null, "loud", "loudness", "NN");
		res = lemmaFormManager.matchLemmas(null, "24", "12", "CD");

		res = lemmaFormManager.matchLemmas(null, "loud", "loudly", "NN");
		res = lemmaFormManager.matchLemmas(null, "!upgrade", "upgrade", "NN");
		res = lemmaFormManager.matchLemmas(null, "!upgrade", "upgrades", "NN");
		res = lemmaFormManager.matchLemmas(null, "!upgrade", "get", "NN");

	}

}
