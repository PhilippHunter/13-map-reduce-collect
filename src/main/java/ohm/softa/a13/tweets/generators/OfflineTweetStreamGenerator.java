package ohm.softa.a13.tweets.generators;

import com.google.gson.Gson;
import ohm.softa.a13.model.Tweet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.stream.Stream;

public class OfflineTweetStreamGenerator implements TweetStreamGenerator {

	private final Gson gson;
	private final String tweetLocation = "/trump_tweets.json";

	public OfflineTweetStreamGenerator() {
		gson = new Gson();
	}

	@Override
	public Stream<Tweet> getTweetStream() {
		Reader reader = new InputStreamReader(getClass().getResourceAsStream(tweetLocation));

		return Arrays.stream(gson.fromJson(reader, Tweet[].class));
	}
}
