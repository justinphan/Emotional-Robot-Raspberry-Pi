
package edu.ccsu.cs417.cs417group1.camera;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author phuphanmbp
 * Create a object type camera that can take a image and calculate the average color of a image
 */
public class Camera implements CameraInterface
{
   // Define the path to the raspistill executable.
   private final String _raspistillPath = "/opt/vc/bin/raspistill";
   // Define the amount of time that the camera will use to take a photo.
   private final int _picTimeout = 500;
   // Define the image quality.
   private final int _picQuality = 100;

   // Specify a default image width.
   private int _picWidth = 1024;
   // Specify a default image height.
   private int _picHeight = 768;
   // Specify a default image name.
   private String name = "example.jpg";
   // Specify a default image encoding.
   private String _picType = "jpg";

   // Picture object
   private Picture picture;

   // Default  constructor.
   public void Camera()
   {
   }

    /**
     * This method gets camera to take an image and save it by the name /home/pi/Desktop/surveillance.jpg
     * @return Average color of the image taken
     */
   @Override
   public String takePicture()
   {
      try
      {
         // Determine the image type based on the file extension (or use the default).
         if (name.indexOf('.')!=-1) _picType = name.substring(name.lastIndexOf('.')+1);

         // Create a new string builder with the path to raspistill.
         StringBuilder sb = new StringBuilder(_raspistillPath);

         // Add parameters for no preview and burst mode.
         sb.append(" -n -bm");
         // Configure the camera timeout.
         sb.append(" -t " + _picTimeout);
         // Configure the picture width.
         sb.append(" -w " + _picWidth);
         // Configure the picture height.
         sb.append(" -h " + _picHeight);
         // Configure the picture quality.
         sb.append(" -q " + _picQuality);
         // Specify the image type.
         sb.append(" -e " + _picType);
         // Specify the name of the image.
         sb.append(" -o " + name);

         // Invoke raspistill to take the photo.
         Runtime.getRuntime().exec(sb.toString());
         // Pause to allow the camera time to take the photo.
         Thread.sleep(_picTimeout);

      }
      catch (Exception e)
      {
         // Exit the application with the exception's hash code.
         System.exit(e.hashCode());
      }
return name;
   }

   // Overloaded method to take a photo using a specific value for the image name.
   public void takePicture(String name)
   {
      takePicture(name, _picWidth, _picHeight);
   }
   
   @Override
   public boolean equals(Object o)
   {
       if(this == o)
           return true;
       if((o == null) || (this.getClass() != o.getClass()))
           return false;

       return this.name.equals(((Camera)o).name);
   }

   @Override
   public int hashCode()
   {
       return (this.name.hashCode());
   }

   @Override
   public String toString()
   {
       return ("This camera saves to the file " + this.name);
   }

   /**
   * Inner class
   * @author Sonia Leonato
   * Creates an object of type Picture which stores the attributes of the image taken with the camera
   */
   protected class Picture{

	   protected Color color;
	   protected String path;


	   public Color getColor(){
		   return color;
	   }
	   public void setColor(Color newColor){
		   color = newColor;
	   }
	   public String getPath(){
		   return path;
	   }
	   public void setPath(String newPath){
		   path = newPath;
	   }

	   /**
	     * Get the file specified by the input path
	     * @param the path of the image
	     * @return image file
	     */
	   public BufferedImage getImage(String inputFile){
		   try {
			return ImageIO.read(new File(inputFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return null;
	   }

   }


}
