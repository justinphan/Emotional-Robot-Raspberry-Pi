package edu.ccsu.cs417.cs417group1.picturedetection;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Class that have a method to implement Google Vision API Landmark Detection
 * @author Phu Phan
 */
public class LandmarkDetection implements Detection {
	/*
	 * @param imagepath the path of the image 
	 * @return return a string describe what is inside the image using Google Vision API Landmark detection
	 */
	 @Override
	 public String getObject(String imagepath) {
		String s = null;
		try {
			String command = "java -cp data/vision-landmark-detection-1.0-SNAPSHOT-jar-with-dependencies.jar com.google.cloud.vision.samples.landmarkdetection.DetectLandmark "+imagepath;
		    final Process proc = Runtime.getRuntime().exec(command);
	    	BufferedReader stdInput = new BufferedReader(new 
	    	     InputStreamReader(proc.getInputStream()));
	    	s = stdInput.readLine(); 
    	}
		catch(Throwable t)
          	{
            	t.printStackTrace();
          	}
    	return s;
	}
}
