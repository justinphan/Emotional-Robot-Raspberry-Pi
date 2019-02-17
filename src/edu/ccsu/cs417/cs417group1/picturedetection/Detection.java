package edu.ccsu.cs417.cs417group1.picturedetection;

/* interface class that have a method to return what inside a picture
 * @author Phu Phan
 */
public interface Detection {
	/*
     * @param imagepath the path of the image 
     * @return return a string describe what is inside the image
     */
   public String getObject(String imagepath);
}