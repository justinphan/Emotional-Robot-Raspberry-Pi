package edu.ccsu.cs417.cs417group1.robot;

import edu.ccsu.cs417.cs417group1.groveboard.robot.RGBLed;
import edu.ccsu.cs417.cs417group1.groveboard.robot.Led;
import edu.ccsu.cs417.cs417group1.groveboard.PinDNEException;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Test Class written for RGBLed.java
 * @author Jeremy Dube
 */

public class RGBLedTest {

	Led red, green, blue;
	RGBLed newLed = new RGBLed(red, green, blue);
	
	
	@Test
	public void NewRGBLedtest() {
		assertEquals(red,newLed.getRed());
		assertEquals(green,newLed.getGreen());
		assertEquals(blue,newLed.getBlue());
	}
	
	@Test
	public void turnOnTest() throws IOException, PinDNEException {
		newLed.turnOn();
		assertEquals(newLed.getRed().isOn(),true);
		assertEquals(newLed.getGreen().isOn(),true);
		assertEquals(newLed.getBlue().isOn(),true);
	}
	
	@Test
	public void turnOffTest() throws IOException, PinDNEException {
		newLed.turnOn();
		newLed.turnOff();
		assertEquals(newLed.getRed().isOut(),false);
		assertEquals(newLed.getGreen().isOut(),false);
		assertEquals(newLed.getBlue().isOut(),false);
	}
}
