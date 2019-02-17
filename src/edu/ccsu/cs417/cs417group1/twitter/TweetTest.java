package edu.ccsu.cs417.cs417group1.twitter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.ccsu.cs417.cs417group1.twitter.Tweet.TweetBuilder;

/**
 *
 * @author Sonia Leonato
 * Test Class for Tweet.java
 */

public class TweetTest {

	Tweet tweet;
	Tweet.TweetBuilder builder;
	private String vision = "vision";
	private String feeling = "feeling";
	FeelingIntensity intensity;
	
	@Before 
	public void setup() {
		builder = new TweetBuilder(vision, feeling);
	}
	
	// Check if the vision and the feeling are not null
	@Test
	public void builderCompleteTest() {
		assertTrue(builder.builderComplete());
		
		builder = new TweetBuilder(null, feeling);
		assertFalse(builder.builderComplete());
		builder = new TweetBuilder(vision, null);
		assertFalse(builder.builderComplete());
		builder = new TweetBuilder(null, null);
		assertFalse(builder.builderComplete());
	}
	
	// Builder completed
	@Test
	public void buildTweetTest() {
		assertNotNull(builder.buildTweet());
	}
	
	// Builder not completed -> exception
	@Test (expected=RuntimeException.class)
	public void buildEsceptionTest()  {
		builder = new TweetBuilder(null, null);
		assertNotNull(builder.buildTweet());
	}
	
	// Check if the builder has set the intensity
	@Test
	public void setIntensityTest() {
		assertNotNull(builder.setFeelingIntensity(intensity));
	}

}
