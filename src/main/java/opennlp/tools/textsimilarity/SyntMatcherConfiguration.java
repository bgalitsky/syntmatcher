package opennlp.tools.textsimilarity;


public class SyntMatcherConfiguration
{
	private String resourcesDir;

	public SyntMatcher syntMatcher()
	{
		return new SyntMatcher(resourcesDir);
	}
}
