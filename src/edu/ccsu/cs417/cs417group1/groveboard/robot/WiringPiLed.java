package edu.ccsu.cs417.cs417group1.groveboard.robot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import edu.ccsu.cs417.cs417group1.groveboard.PinDNEException;

/**
 * class adapter that interfaces with command line program WiringPi
 * to turn on a LED attached to a gpio pin
 * @author Matt Rusczyk
 */
public class WiringPiLed extends Led { // TODO gotta change these names so they are less confusing

    public WiringPiLed(int p) throws PinDNEException
    {
        super(p);
    }
   
    @Override
   public void setPinOut() throws IOException {
        String pinN = "" + pin;
        List<String> command = new ArrayList();
        command.add("gpio");
        command.add("mode");
        command.add(pinN);
        command.add("out");

        sendCommand(command);

        out = true;
    }

   @Override
    public void setPinIn() throws IOException {
        String pinN = "" + pin;
        List<String> command = new ArrayList();
        command.add("gpio");
        command.add("mode");
        command.add(pinN);
        command.add("in");
        sendCommand(command);

       out = false;
    }

    public void turnOn() throws IOException{
        String pinN = "" + pin;
        List<String> command = new ArrayList();

        command.add("gpio");

        command.add("write");
        command.add(pinN);
        command.add("0");

        sendCommand(command);

        on = true;
    }

    public void turnOff() throws IOException{
        if (pin > 29 || pin < 0) {}
        String pinN = "" + pin;
        List<String> command = new ArrayList();
        command.add("gpio");
        command.add("write");
        command.add(pinN);
        command.add("1");

        sendCommand(command);
        on = false;
    }
}
