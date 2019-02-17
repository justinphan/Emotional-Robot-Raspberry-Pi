package edu.ccsu.cs417.cs417group1.twitter;

/**
 * Creates Feeling Intensityto be used by Tweet.java
 * @author Jeremy Dube
 */

public enum FeelingIntensity {

	//not very, somewhat, blank, quite, very
	ONE("not very"),
	TWO("somewhat"),
	THREE(""),
	FOUR("quite"),
	FIVE("very");
	
	private final String description;
	
	/**
	 * Assigns String description to FeelingIntensity
	 * @param description
	 */
	
	private FeelingIntensity(String description) {
		this.description = description;
	}
 	
	@Override
	public String toString() {
		return description;
	}
}
