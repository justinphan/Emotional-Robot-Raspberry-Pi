package edu.ccsu.cs417.cs417group1.twitter;

import edu.ccsu.cs417.cs417group1.twitter.Tweet.TweetBuilder;
import twitter4j.TwitterException;
/**
 * Example Main for Tweet used as example for actual Main
 * @author Jeremy Dube
 */
public class test {

	public static void main(String[] args) throws TwitterException {
		TweetBuilder builder = new Tweet.TweetBuilder("bear", "frightened");
		builder.setFeelingIntensity(FeelingIntensity.FIVE);
		Tweet firsttweet = builder.buildTweet();
		firsttweet.PublishTweet();
	}

}
