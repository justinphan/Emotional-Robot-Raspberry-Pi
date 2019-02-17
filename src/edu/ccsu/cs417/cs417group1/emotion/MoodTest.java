package edu.ccsu.cs417.cs417group1.emotion;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;
/**
 * Test class written for testing Composite pattern
 * implemented in the Mood class
 * @author Jeremy Dube
 *
 */
public class MoodTest {

	List<IEmotion> moods = new ArrayList<IEmotion>();
	
	@Test
	public void AddComponentTest() {
		moods.add(new Comfort());
		assertNotNull(moods.get(0));
	}

	@Test
	public void removeComponentTest() {
		moods.add(new Happiness());
		IEmotion hap = moods.get(1);
		hap.removeComponent("Happiness");
		assertNull(moods.get(1));
	}
	
	@Test
	public void getChildTest() {
		IEmotion com = moods.get(0);
		assertNotNull(com.getChild("Comfort"));
	}
	
	@Test
	public void getIntensityTest() {
		IEmotion com = moods.get(0);
		com.addComponent(new IntenseEmotion(new Joy(), 3.0));
		assertNotNull(com.getIntensity());
	}
	
	@Test
	public void getDescriptionTest() {
		IEmotion com = moods.get(0);
		assertNotNull(com.getDescription());
	}
}
