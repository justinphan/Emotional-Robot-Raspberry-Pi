package edu.ccsu.cs417.cs417group1.groveboard.robot;

import edu.ccsu.cs417.cs417group1.groveboard.PinDNEException;
import java.io.IOException;
/**
 *
 * @author Simon Yawin
 */
public class Main {
    
    public static void main(String args[]) throws InterruptedException, IOException, PinDNEException
    {
        Led red = new WiringPiLed(0), green = new WiringPiLed(1), blue = new WiringPiLed(2);
	RGBLed Rgb = new RGBLed(red,green,blue);

	Rgb.turnOnRed();
	Thread.sleep(1000);
	Rgb.turnOnBlue();
	Thread.sleep(1000);
	Rgb.turnOnGreen();
	Thread.sleep(1000);
	Rgb.turnOnYellow();
	Thread.sleep(1000);
	Rgb.turnOnCyan();
	Thread.sleep(1000);
	Rgb.turnOnViolet();
	Thread.sleep(1000);
	Rgb.turnOn();
	Thread.sleep(1000);
	Rgb.turnOff();

    }
    
}
