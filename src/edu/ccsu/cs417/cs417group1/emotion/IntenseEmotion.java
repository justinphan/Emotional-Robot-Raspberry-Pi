package edu.ccsu.cs417.cs417group1.emotion;

public class IntenseEmotion extends EmotionDecorator
{
    final private String DESCRIPTION = "Intense";
    public IntenseEmotion(IEmotion wrappedInstance,double intensity){
        super(wrappedInstance,intensity);
    }
    public double getIntensity(){
        return INTENSITY_MODIFIER * INSTANCE.getIntensity();
    }
    public String getDescription(){
        return DESCRIPTION+" "+INSTANCE.getDescription();
    }
}
