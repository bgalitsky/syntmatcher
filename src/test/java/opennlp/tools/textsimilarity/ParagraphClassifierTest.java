package opennlp.tools.textsimilarity;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ParagraphClassifierTest
{

	private ParagraphClassifier paragraphClassifier = new ParagraphClassifier();

	@Test
	public void test()
	{

		Map<String, List<LemmaPair>> sentence_bestClassRep = paragraphClassifier
			.findMappingBetweenSentencesOfAParagraphAndAClassReps(
				"I will recommend to the post members this camera because it has a great zoom. ",
				// confidence set 1-5 beginner, 6-10 expert
				"I will recommend this camera because it is nice. " + "I will advice to use it since it is great. "
					+ "Members are asking. " + "I know what to recommend. "

			/*
			 * "I want this nice radio thing. " + "I like it because radio is loud. " +
			 * "Nice to hear interesting programs about animals. " + "Animals run to the tiger zoo. "+
			 * "I enjoyed the digital zoom of this camera because I can quickly adjust for shots far away. "+
			 * "I removed abberation by digital zoom increase by performance limitation of filters of my camera. "+
			 * "I have to frequently change batteries in digital camera. " +
			 * "I told my wife to film me at a speed while on a boat. " +
			 * "This digital camera nicely fits in my palm and the body is not heavy. "+
			 * "I can easily connect this digital camera to my desktop computer to copy images. "+
			 * "In this digital camera you can turn your lcd screen away from the scene.",
			 * 
			 * "You would want this nice thing. "+ "Everyone likes this radio because of its loudness. "+
			 * "I am happy to hear very long programs from animals. " + "I love to run around zoo with tigers. "+
			 * "I used a lot the auto focus of this digital camera because I could get high resolution shots. "+
			 * "I can increase digital zoom performance by adding filters to my camera. "+
			 * "My digital camera batteries only last short time. "+
			 * "My wife wanted to film me when we were sailing at a high speed. "+
			 * "The digital camera of my wife is a good fit to my palm. "+
			 * "I connected this digital camera to my desctop computer and copy images. "+
			 * "You can turn your lcd screen away from the scene because there is a special installation."
			 */);
		System.out.println(sentence_bestClassRep);
	}

}
