package edu.ccsu.cs417.cs417group1.picturedetection;

import static org.junit.Assert.*;

import org.junit.Test;

/*
* @author Sonia Leonato
* Test for Detection class
*/
public class DetectionTest {
	
	Detection detection;

	@Test
	public void test() {
		assertNotNull(detection.getObject("path"));
	}

}
