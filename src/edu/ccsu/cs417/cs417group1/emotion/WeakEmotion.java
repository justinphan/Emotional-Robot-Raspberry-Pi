package edu.ccsu.cs417.cs417group1.emotion;

//@author Cameron Sonido
public class WeakEmotion extends EmotionDecorator
{
    final private String DESCRIPTION = "Weak";
    public WeakEmotion(IEmotion wrappedInstance,double intensity){
        super(wrappedInstance,intensity);
    }
    
    /**
     * Returns a double representing the intensity of the wrapped object divided by the modifier
     * @author Cameron Sonido
     */
    public double getIntensity(){
        return INSTANCE.getIntensity() / INTENSITY_MODIFIER;
    }
    
    /**
     * Returns the decorator's DESCRIPTION appended to the DESCRIPTION of the wrapped INSTANCE
     *  @author Cameron Sonido
     */
    public String getDescription(){
        return DESCRIPTION+" "+INSTANCE.getDescription();
    }
}
