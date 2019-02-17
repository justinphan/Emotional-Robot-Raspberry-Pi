package edu.ccsu.cs417.cs417group1.picturedetection;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/* 
 * @author Phu Phan
 * Context objects maintain a reference to a Detection object
 * and is configured with a specific type of detection.
 * also includes a method to get the average Color object.
 */
public class Context {
   private Detection detection;
   //contructor
   public Context(Detection detection){
      this.detection = detection;
   }

   public String getObject(String imgpath){
      return detection.getObject(imgpath);
   }
   
   /*
    * @param imagepath the path of the image 
    * @return return an average color of the image by an Object typed Color 
    */
   public Color getColorAvg(String imgpath){
	   BufferedImage img = null;
       try {
           img = ImageIO.read(new File(imgpath));
       } 
       catch (IOException e) { }
       
       int red = 0, green = 0, blue = 0;
       int pixelCount = 0;
       
       for (int y = 0; y < img.getHeight(); y++)
       {
           for (int x = 0; x < img.getWidth(); x++)
               {
                   int pixel = img.getRGB(x, y);
                   pixelCount++;
                   red += pixel>>16&0xFF;
                   green += pixel>>8&0xFF;
                   blue += pixel&0xFF;
               }
       }
       System.out.println("Returned color");
       return new Color(red / pixelCount, green / pixelCount, blue / pixelCount);      
   }
}