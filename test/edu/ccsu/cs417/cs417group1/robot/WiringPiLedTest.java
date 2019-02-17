package edu.ccsu.cs417.cs417group1.robot;

import edu.ccsu.cs417.cs417group1.groveboard.robot.WiringPiLed;
import edu.ccsu.cs417.cs417group1.groveboard.robot.Led;
import edu.ccsu.cs417.cs417group1.groveboard.PinDNEException;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * Test Class written for WiringPiLed.java
 * @author Jeremy Dube
 */

public class WiringPiLedTest {

	Led red;
	@Before
	public void setup() throws PinDNEException {
		Led red = new WiringPiLed(0);
	}
	
	@Test
	public void setPinOutTest() throws IOException {
		red.setPinOut();
		assertEquals(red.isOut(),true);
	}
	
	@Test
	public void setPinInTest() throws IOException {
		red.setPinIn();
		assertEquals(red.isOut(),false);
	}
	
	@Test
	public void turnOnTest() throws IOException {
		red.turnOn();
		assertEquals(red.isOn(),true);
	}
	
	@Test
	public void turnOffTest() throws IOException {
		red.turnOff();
		assertEquals(red.isOn(),false);
	}

}
