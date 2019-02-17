package edu.ccsu.cs417.cs417group1.groveboard.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import edu.ccsu.cs417.cs417group1.groveboard.PinDNEException;

/**
 * abstract class that gives a framework to interface with the raspberry pi gpio pins through
 * the WiringPi command line interface
 * @author Matt Rusczyk
 */
public abstract class Led { // TODO gotta change these names so they are less confusing
    protected int pin;
    protected ProcessBuilder pb;
    protected boolean on, out;
    
    public Led(int p) throws PinDNEException
    {
        if (p >29 || p < 0)
            throw new PinDNEException();
        this.pin = p;
    }
    
    public abstract void setPinOut() throws IOException;
    public abstract void setPinIn() throws IOException;
    public void turnOn() throws IOException { }
    public void turnOff() throws IOException{ }
    
    public int getPin()
    {
        return pin;
    }
    public boolean isOn() {
        return on;
    }
    public boolean isOut() {
        return out;
    }

    /**
     * sends a command to the linux shell
     * ProcessBuilder sends a command to the shell by taking each member of 'command'
     * and turning it into a command that any linux shell can understand
     * @param command the command to be executed
     * @throws IOException
     */


    public void sendCommand(List<String> command) throws IOException {
        pb = new ProcessBuilder(command);
        pb.redirectErrorStream(true);

        Process p = pb.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Led that = (Led) o;

        return getPin() == that.getPin();
    }
    
    @Override
    public int hashCode() {
        return getPin();
    }

    public String toString() {
        return "This component is attached to pin " + pin;
    }
}
