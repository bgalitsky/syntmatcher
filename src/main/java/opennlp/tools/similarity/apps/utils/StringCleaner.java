package opennlp.tools.similarity.apps.utils;

public class StringCleaner
{
	public static String processSnapshotForMatching(String snapshot)
	{
		snapshot = snapshot.replace("<b>...</b>", ". ").replace("<b>", "").replace("</b>", "").replace(". . ", " ")
			.replace(" . . . ", " ").replace("...", " ").replace(",..", " ").replace("&amp;", " ").replace('\"', ' ')
			.replace("  ", " ");
		snapshot = snapshot.replace('\'', ' ').replace('-', ' ');

		return snapshot;
	}
}