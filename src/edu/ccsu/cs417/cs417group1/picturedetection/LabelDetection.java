package edu.ccsu.cs417.cs417group1.picturedetection;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Class that have a method to implement Google Vision API Label Detection
 * @author Phu Phan
 */
public class LabelDetection implements Detection {
	 @Override
	 /*
	  * @param imagepath the path of the image 
	  * @return return a string describe what is inside the image using Google Vision API Label Detection method
	  */
	 public String getObject(String imagepath) {
		String s = null;
		try {
		    final Process proc = Runtime.getRuntime().exec("java -cp data/vision-label-1.0-SNAPSHOT-jar-with-dependencies.jar com.google.cloud.vision.samples.label.LabelApp "+ imagepath);
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
