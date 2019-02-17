package edu.ccsu.cs417.cs417group1.groveboard.robot;

import edu.ccsu.cs417.cs417group1.groveboard.PinDNEException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates an object that controls an RGB Led through the Raspberry Pi GPIO pins
 * Holds a list of {@link edu.ccsu.cs417.cs417group1} objects that make up the RGB Led
 * @author Matt Rusczyk
 */
public class RGBLed {
    List<Led> leds = new ArrayList();

    /**
     * Creates a WiringPiRGBLed Object by linking

     * @param red the {@link edu.ccsu.cs417.cs417group1.groveboard.robot.WiringPiLed} object that will be associated with red
     * @param green the {@link edu.ccsu.cs417.cs417group1.groveboard.robot.WiringPiLed} object that will be associated with green
     * @param blue the {@link edu.ccsu.cs417.cs417group1.groveboard.robot.WiringPiLed} object that will be associated with blue
     */
    public RGBLed(Led red, Led green, Led blue) {
        leds.add(red);
        leds.add(green);
        leds.add(blue);
    }

    /**
     * Turns on all leds to make a white light
     * @throws IOException
     * @throws PinDNEException
     */
    public void turnOn() throws IOException, PinDNEException {
        for (Led led: leds) {
            led.setPinOut();
            led.turnOn();
        }
    }

    /**
     * This method turns off all leds
     * @throws IOException
     * @throws PinDNEException
     */
    public void turnOff() throws IOException, PinDNEException {
        for (Led led: leds) {
            led.setPinIn(); //this is becasue some leds will still output light when set to 0 V
        }
    }

    /**
     * THis method turns off all leds and then turns on the red LED
     * @throws IOException
     * @throws PinDNEException
     */
    public void turnOnRed() throws IOException, PinDNEException {
        turnOff();
        leds.get(0).setPinOut();
        leds.get(0).turnOn();
    }

    /**
     * This method turns off all leds and then turns on the green led
     * @throws IOException
     * @throws PinDNEException
     */
    public void turnOnGreen() throws IOException, PinDNEException {
        turnOff();
        leds.get(1).setPinOut();
        leds.get(1).turnOn();
    }

    /**
     * This method turns off all leds and then turns on the blue led
     * @throws IOException
     * @throws PinDNEException
     */
    public void turnOnBlue() throws IOException, PinDNEException {
        turnOff();
        leds.get(2).setPinOut();
        leds.get(2).turnOn();
    }

    /**
     * THis method turns off all leds and then makes yellow by turning on both red and green leds
     * @throws IOException
     * @throws PinDNEException
     */
    public void turnOnYellow() throws IOException, PinDNEException {
        turnOff();
        leds.get(0).setPinOut();
        leds.get(0).turnOn();
        leds.get(1).setPinOut();
        leds.get(1).turnOn();
    }

    /**
     * This method turns off all leds and then makes cyan by turning on both green and blue leds
     * @throws IOException
     * @throws PinDNEException
     */
    public void turnOnCyan() throws IOException, PinDNEException {
        turnOff();
        leds.get(1).setPinOut();
        leds.get(1).turnOn();
        leds.get(2).setPinOut();
        leds.get(2).turnOn();
    }


    /**
     * This method turns off all leds and then makes violet by turning on both red and blue leds
     * @throws IOException
     * @throws PinDNEException
     */
    public void turnOnViolet() throws IOException, PinDNEException {
        turnOff();
        leds.get(0).setPinOut();
        leds.get(0).turnOn();
        leds.get(2).setPinOut();
        leds.get(2).turnOn();
    }

    public Led getRed() {
        return leds.get(0);
    }

    public Led getGreen() {
        return leds.get(1);

    }
    public Led getBlue() {
        return leds.get(2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        boolean red, blue, green;

        RGBLed that = (RGBLed) o;
        red = that.getRed().equals(getRed());
        green = that.getGreen().equals(getGreen());
        blue = that.getBlue().equals(getBlue());

        return (red && green && blue);
    }

    @Override
    public int hashCode() {
        return leds != null ? leds.hashCode() : 0;
    }

    @Override
    public String toString() {
        String s = "Red is attached to pin " + getRed();
        s += "\nGreen is attached to pin " +getGreen();
        s += "\nBlue is attached to pin " +getBlue();
        return s;
    }

}
