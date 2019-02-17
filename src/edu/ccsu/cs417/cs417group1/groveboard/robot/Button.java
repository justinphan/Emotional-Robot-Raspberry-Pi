package edu.ccsu.cs417.cs417group1.groveboard.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import edu.ccsu.cs417.cs417group1.groveboard.PinDNEException;

/**
 * Created by mattrusczyk on 11/28/16.
 */
public class Button extends Led {

    public Button (int pin) throws PinDNEException {
        super(pin);
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

    /**
     * This method reads the input from the button attached to this pin
     * returns true if returned value from Pi is 0. Meaning button is pushed
     * returns false if returned value from Pi is 1, meaning button is raised.
     * @return pushed tells if button is pushed or not
     * @throws IOException
     */
    public boolean readInput() throws IOException {
        String pinN = "" + pin;
        boolean pushed;

        setPinIn();
        List<String> command = new ArrayList();
        command.add("gpio");
        command.add("read");
        command.add(pinN);
        String s = sendCommandAndReadOutput(command);

        return s.equals("0");
    }

    /**
     * Sends command to shell enviroment and returns the output from the shell
     * @param command List of commands to send to shell
     * @return  output
     * @throws IOException
     */
    private String sendCommandAndReadOutput(List<String> command) throws IOException {
        String output;
        pb = new ProcessBuilder(command);
        pb.redirectErrorStream(true);

        Process p = pb.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

        output = br.readLine();
        return output;

    }
}
