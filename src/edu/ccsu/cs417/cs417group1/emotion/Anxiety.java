package edu.ccsu.cs417.cs417group1.emotion;

public class Anxiety extends Emotion
{
    
    public Anxiety()
    {
        super(-5, "Anxious");
    }
    
    @Override
    public void express(){
        //Do something related to the LED
    }

    /** 
     * Returns the INTENSITY of the current emotion
     * @author Cameron Sonido
     */
    @Override
    public double getIntensity(){
        return INTENSITY;
    }
    
    /** 
     * The following 3 functions lack implementation to safely execute the decorator pattern 
     * @author Cameron Sonido
     */
    @Override
    public void addComponent(IEmotion e){
    }
    @Override
    public IEmotion removeComponent(String desc){
        return null;
    }
    @Override
    public IEmotion getChild(String desc){
        return null;
    }
    
    /** 
     * Returns the leaf's DESCRIPTION
     *  @author Cameron Sonido
     */
    public String getDescription(){
        return DESCRIPTION;
    }
}
