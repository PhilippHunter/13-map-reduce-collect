package ohm.softa.a13.tweets;

import ohm.softa.a13.model.Tweet;
import org.apache.commons.lang3.NotImplementedException;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author Peter Kurfer
 */
public class TrumpTweetStats {

	public static Map<String, Long> calculateSourceAppStats(Stream<Tweet> tweetStream) {
		/* TODO group the tweets by the `sourceApp` they were created with and count how many it were per `sourceApp` */
		return tweetStream
			.collect(groupingBy(Tweet::getSourceApp, counting()));
	}

	public static Map<String, Set<Tweet>> calculateTweetsBySourceApp(Stream<Tweet> tweetStream) {
		/* TODO group the tweets by the `sourceApp`
		 * collect the tweets in `Set`s for each source app */
		return tweetStream
			.collect(groupingBy(Tweet::getSourceApp, toSet()));
	}

	public static Map<String, Long> calculateWordCount(Stream<Tweet> tweetStream, List<String> stopWords) {
		/* Remark: implement this method at last */
		/* TODO split the tweets, lower them, trim them, remove all words that are in the `stopWords`,
		 * reduce the result to a Map<String, Integer> to count how often each word were in the tweets
		 * optionally you could filter for all words that were used more than 10 times */

		return tweetStream
			.map(tweet -> tweet.getText().split("( )+"))
			.flatMap(Arrays::stream)
			.filter(stopWords::contains)
			.collect(groupingBy(Function.identity(), counting()));
	}
}
