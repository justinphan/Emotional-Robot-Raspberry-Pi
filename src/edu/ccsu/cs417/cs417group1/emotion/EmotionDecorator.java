package edu.ccsu.cs417.cs417group1.emotion;

// Decorator
public abstract class EmotionDecorator implements IEmotion
{
    final protected IEmotion INSTANCE;
    final protected double INTENSITY_MODIFIER;
    
    /**
    * Constructor
    * @param wrappedInstance - Emotion INSTANCE to be wrapped
    * @param intensity - multiplier to be used in intensity calculations 
    * @author Cameron Sonido
    */
    public EmotionDecorator(IEmotion wrappedInstance,double intensity){
        INTENSITY_MODIFIER = intensity;
        INSTANCE = wrappedInstance;
    }
    
    
    /**
    * Non-functional - to avoid deviating from the Decorator pattern, returns the wrapped INSTANCE
    * @param s - useless String
    * @author Cameron Sonido
    */
    @Override
    public IEmotion getChild(String s){
        return INSTANCE;
    }

    /**
    * Passes method to wrapped INSTANCE
    * @author Cameron Sonido
    */
    //Developer note: depending on pi implementation we could perform express based on intensity modifier
    @Override
    public void express() {
        INSTANCE.express();
    }

    /**
    * Passes method to wrapped INSTANCE
    * @param e - Emote to add to wrapped emotion
    * @author Cameron Sonido
    */
    @Override
    public void addComponent(IEmotion e) {
        INSTANCE.addComponent(e);
    }

    /**
    * Passes method to wrapped INSTANCE
    * @param desc - desc to be passed to wrapped INSTANCE
    * @author Cameron Sonido
    */
    @Override
    public IEmotion removeComponent(String desc) {
        return INSTANCE.removeComponent(desc);
    }
    
    /**
     * Returns the description of the INSTANCE, in addition to the modifier
     * @author Cameron Sonido
     */
    abstract public String getDescription();
    
    /**
     * Returns the net intensity of all emotions composing this object 
     * @author Cameron Sonido
     */
    @Override
    abstract public double getIntensity();
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        
        EmotionDecorator that = (EmotionDecorator) o;
        
        return (this.INSTANCE.getDescription().equals(that.INSTANCE.getDescription()))
                && (this.INSTANCE.getIntensity() == that.INSTANCE.getIntensity());
    }
    
    @Override
    public int hashCode()
    {
        return this.INSTANCE.hashCode();
    }
    
    
    @Override
    public String toString()
    {
        return this.INSTANCE.toString() + this.INSTANCE.getDescription();
    }
}
