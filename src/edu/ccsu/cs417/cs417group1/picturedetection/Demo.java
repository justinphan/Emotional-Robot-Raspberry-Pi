package edu.ccsu.cs417.cs417group1.picturedetection;

public class Demo {
	public static void main(String[] args) {
	      Context context = new Context(new LabelDetection());		
	      System.out.println(context.getObject("data/towerwithcats.jpeg"));
	      System.out.println(context.getColorAvg("data/towerwithcats.jpeg"));
	      
	      context = new Context(new LandmarkDetection());		
	      System.out.println(context.getObject("data/towerwithcats.jpeg"));
	      System.out.println(context.getColorAvg("data/towerwithcats.jpeg"));

	   }
}
