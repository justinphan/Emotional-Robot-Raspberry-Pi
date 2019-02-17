package edu.ccsu.cs417.cs417group1.emotion;

//Abstract Composite
import java.util.*;
import java.util.NoSuchElementException;

public abstract class Mood extends Emotion
{
    protected EmotionCollection<IEmotion> emotes;
    protected String description;

    /* Perform express on all children of composite object
     * @author Cameron Sonido
     */
    @Override
    public void express(){
        emotes.express();
    }

    public Mood(double intensity, String desc){
        super(intensity, desc);
        emotes = new EmotionCollection<IEmotion>();
    }

    /**
     * Adds an emotion to the composite Emotion
     * @param e - The emotion to be appended
     * @author Cameron Sonido
     */
    @Override
    public void addComponent(IEmotion e){
        emotes.add(e);
    }

    /**
     * Removes an emotion from the composite Emotion
     * @param desc - Description of the emotion desired to be removed
     * from the composite
     * @author Cameron Sonido
     */
    @Override
    public IEmotion removeComponent(String desc){
        return emotes.remove(desc);
    } 

    /**
     * Gets an emotion from the composite Emotion by its description.
     * Returns null if no such element.
     * @param i - Index of child to be retrieved
     * from the composite
     * @author Cameron Sonido
     */
    @Override
    public IEmotion getChild(String desc){
        return emotes.get(desc);
    } 

    /**
     * Returns the net intensity of all emotions composing this object 
     * @author Cameron Sonido
     */
    @Override
    public double getIntensity(){
        return emotes.getIntensity();
    }

    /** Returns the description of this object, appended to the descriptions of its children
    * @author Cameron Sonido
    */  
    @Override
    public String getDescription(){
        return this.description + "- affected by: " + emotes.getDescription();
    }
}
