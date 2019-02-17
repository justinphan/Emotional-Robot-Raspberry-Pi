package edu.ccsu.cs417.cs417group1.twitter;

import edu.ccsu.cs417.cs417group1.twitter.Tweet.TweetBuilder;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * Builder Creational Pattern
 * Creates object (Tweet) and allows for additional attributes to be attached
 * @author Jeremy Dube
 */

public class Tweet {

	private final String vision;
	private final String feeling;
	private final FeelingIntensity intensity;

	/**
	 * Creates a Tweet object linking to class private attributes

	 * @param builder the {@link edu.ccsu.cs417.cs417group1.twitter.Tweet.TweetBuilder} used to be associated with builder object
	 */
	
	private Tweet(TweetBuilder builder) {
		this.vision = builder.vision;
		this.feeling = builder.feeling;
		this.intensity = builder.intensity;
	}
	
	/**
	 * Used to publish information built with TweetBuilder to twitter.com/cs417group1
	 * 
	 * @throws TwitterException
	 */
	
	public void PublishTweet() throws TwitterException{
		Twitter twitter = TwitterFactory.getSingleton();
		String newTweet = "I see a " + vision + " and it makes me feel " + intensity.toString() + " " + feeling;
		Status status = twitter.updateStatus(newTweet);
	    System.out.println("Successfully updated the status to [" + status.getText() + "].");
	}
        
        @Override
        public boolean equals(Object o)
        {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            
            Tweet that = (Tweet) o;
            
            return (this.vision.equals(that.vision)) && (this.feeling.equals(that.feeling)) && (this.intensity.equals(that.intensity));
        }
        
        @Override
        public int hashCode()
        {
            return (this.vision.hashCode() + this.feeling.hashCode() + this.intensity.hashCode()) / 3;
        }
        
        @Override
        public String toString()
        {
            return "Current vision: " + this.vision + "\nCurrent feeling: " + this.feeling;
        }
	
	/**
	 * Creates TweetBuilder used to assign values to Tweet object
	 * @author Jeremy Dube
	 */

	public static class TweetBuilder {
		private String vision = null;
		private String feeling = null;
		private FeelingIntensity intensity = null;

		/**
		 * Creates TweetBuilder
		 * 
		 * @param vision
		 * @param feeling
		 */
		
		public TweetBuilder(String vision, String feeling) {
			this.vision = vision;
			this.feeling = feeling;
		}

		/**
		 * Assembles Tweet given that TweetBuilder has all required values
		 * 
		 * @return
		 */
		
		public Tweet buildTweet() {
			if (!builderComplete()) {
				throw new RuntimeException("Not full Tweet");
			}
			return new Tweet(this);
		}

		/**
		 * Verifies whether or not TweetBuilder has all required attributes
		 * 
		 * @return
		 */
		
		public boolean builderComplete() {
			if ((vision != null) && (feeling != null) && (intensity != null)) {
				return true;
			} 
			else {
				return false;
			}
		}

		/**
		 * Creates and attaches FeelingIntensity to the TweetBuilder object
		 * 
		 * @param intensity
		 * @return
		 */
		
		public TweetBuilder setFeelingIntensity(FeelingIntensity intensity) {
			this.intensity = intensity;
			return this;
		}
		
		public String getVision() {
			return vision;
		}
		
		public String getFeeling() {
			return feeling;
		}
		
		@Override
		public String toString() {
			String s = "Current vision: " + vision;
			s += "\nCurrent feeling: " + feeling;
			return s;
		}

	}
}