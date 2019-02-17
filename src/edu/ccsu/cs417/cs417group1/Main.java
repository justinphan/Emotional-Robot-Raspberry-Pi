package edu.ccsu.cs417.cs417group1;

import edu.ccsu.cs417.cs417group1.camera.Camera;
import edu.ccsu.cs417.cs417group1.emotion.*;
import edu.ccsu.cs417.cs417group1.groveboard.robot.Button;
import edu.ccsu.cs417.cs417group1.groveboard.PinDNEException;
import edu.ccsu.cs417.cs417group1.groveboard.robot.Led;
import edu.ccsu.cs417.cs417group1.groveboard.robot.RGBLed;
import edu.ccsu.cs417.cs417group1.groveboard.robot.WiringPiLed;
import edu.ccsu.cs417.cs417group1.picturedetection.Context;
import edu.ccsu.cs417.cs417group1.picturedetection.Detection;
import edu.ccsu.cs417.cs417group1.picturedetection.LabelDetection;
import edu.ccsu.cs417.cs417group1.picturedetection.LandmarkDetection;
import edu.ccsu.cs417.cs417group1.twitter.FeelingIntensity;
import edu.ccsu.cs417.cs417group1.twitter.Tweet;
import twitter4j.TwitterException;
import java.util.Properties;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

import static edu.ccsu.cs417.cs417group1.Properties.*;

/**
 * Created by mattrusczyk on 12/1/16.
 */
public class Main {
    public static void main(String[] args) {
        gatherProps();

        try {

            Led red = new WiringPiLed(RED), blue = new WiringPiLed(BLUE), green = new WiringPiLed(GREEN);
            RGBLed rgb = new RGBLed(red,green,blue);

            if (!buttonConnected) {
                if (RGB) {

                    for (int i = 0; i < 3; i++) { //three count for picture being taken
                        rgb.turnOnGreen();
                        System.out.println(3 - i);
                        Thread.sleep(100);
                        rgb.turnOff();
                        Thread.sleep(900);
                    }

                    System.out.println("Say Cheese");

                    sendTweet();
                }
                else {
                    for (int i = 0; i < 3; i++) { //three count for picture being taken
                        System.out.println(3 - i);
                        Thread.sleep(1000);
                    }

                    System.out.println("Say Cheese");

                    sendTweet();
                }
            }

            else {
                Button pushButton = new Button(BUTTON);
                while (true) {
                    if (pushButton.readInput()) {

                        if (RGB) {

                            for (int i = 0; i < 3; i++) { //three count for picture being taken
                                rgb.turnOnGreen();
                                System.out.println(3 - i);
                                Thread.sleep(100);
                                rgb.turnOff();
                                Thread.sleep(900);
                            }

                            System.out.println("Say Cheese");

                            sendTweet();
                        }
                        else {
                            for (int i = 0; i < 3; i++) { //three count for picture being taken
                                System.out.println(3 - i);
                                Thread.sleep(1000);
                            }

                            System.out.println("Say Cheese");

                            sendTweet();
                        }
                    }
                }
            }
        }
        catch (PinDNEException e) {
            System.out.println("The requested pin does not exist");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendTweet() throws TwitterException, InterruptedException {
        Camera camera = new Camera();
        String pictureName = camera.takePicture();
        Detection detection;
        AbstractFactory emotionFactory;
        AbstractProduct feeling;
        Tweet.TweetBuilder tweet;

        if (landmark)
            detection = new LandmarkDetection();
        else
            detection = new LabelDetection();

        Context googleAPI = new Context(detection);

        String objectSeen = googleAPI.getObject(pictureName);
        Color color = googleAPI.getColorAvg(pictureName);

        if (optimist)
            emotionFactory = new OptimistFactory();

        else
            emotionFactory = new PessimistFactory();

        feeling = emotionFactory.produceEmotion(color);

System.out.println(pictureName);

        tweet = new Tweet.TweetBuilder(objectSeen, feeling.getDescription());
        if (feeling.getDescription().equals("cripplingly depressed"))
	    tweet.setFeelingIntensity(FeelingIntensity.THREE);
	else if (feeling.getIntensity() <= -50)
            tweet.setFeelingIntensity(FeelingIntensity.ONE);
        else if (feeling.getIntensity() < 0)
            tweet.setFeelingIntensity(FeelingIntensity.TWO);
        else if (feeling.getIntensity() == 0)
            tweet.setFeelingIntensity(FeelingIntensity.THREE);
        else if (feeling.getIntensity() <= 50)
            tweet.setFeelingIntensity(FeelingIntensity.FOUR);
        else
            tweet.setFeelingIntensity(FeelingIntensity.FIVE);

        Tweet firstTweet = tweet.buildTweet();
	firstTweet.PublishTweet();


    }

    private static void gatherProps() {
        FileInputStream environmentProperties;
        try {
            environmentProperties = new FileInputStream("config/environment.properties");
            Properties props = new Properties();
            props.load(environmentProperties);

            if (props.containsKey(RED_PORT))
                RED = Integer.parseInt(props.getProperty(RED_PORT));
            if (props.containsKey(GREEN_PORT))
                GREEN = Integer.parseInt(props.getProperty(GREEN_PORT));
            if (props.containsKey(BLUE_PORT))
                BLUE = Integer.parseInt(props.getProperty(BLUE_PORT));
            if (props.containsKey(RGB_CONNECTED))
                RGB = Boolean.parseBoolean(props.getProperty(RGB_CONNECTED));
            if (props.containsKey(BUTTON_PORT))
                BUTTON = Integer.parseInt(props.getProperty(BUTTON_PORT));
            if (props.containsKey(OPTIMIST))
                optimist = Boolean.parseBoolean(props.getProperty(OPTIMIST));
            if (props.containsKey(LANDMARK))
                landmark = Boolean.parseBoolean(props.getProperty(LANDMARK));
            if (props.containsKey(BUTTON_CONNECTED))
                buttonConnected = Boolean.parseBoolean(props.getProperty(BUTTON_CONNECTED));
            if (props.containsKey(RGB_CONNECTED))
                RGB = Boolean.parseBoolean(props.getProperty(RGB_CONNECTED));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    private final static String RGB_CONNECTED = "RGB_CONNECTED";
    private final static String RED_PORT = "RED_PORT";
    private final static String GREEN_PORT = "GREEN_PORT";
    private final static String BLUE_PORT = "BLUE_PORT";
    private final static String OPTIMIST = "OPTIMIST";
    private final static String LANDMARK = "LANDMARK";
    private final static String BUTTON_PORT = "BUTTON_PORT";
    private final static String BUTTON_CONNECTED = "BUTTON_CONNECTED";

}
