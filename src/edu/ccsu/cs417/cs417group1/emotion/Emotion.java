 package edu.ccsu.cs417.cs417group1.emotion;

public abstract class Emotion implements IEmotion
{
    protected final double INTENSITY;
    protected final String DESCRIPTION;
    
    public Emotion(double intensity, String desc)
    {
        this.INTENSITY = intensity;
        this.DESCRIPTION = desc;
    }
    
    @Override
    abstract public void express();
    @Override
    abstract public void addComponent(IEmotion e);
    @Override
    abstract public IEmotion removeComponent(String desc);
    @Override
    abstract public IEmotion getChild(String desc);
    @Override
    public double getIntensity(){
        return INTENSITY;
    }
    @Override
    abstract public String getDescription();
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        
        Emotion that = (Emotion) o;
        
        return this.getDescription().equals(that.getDescription());
    }
    
    @Override
    public int hashCode()
    {
        return this.getDescription().hashCode();
    }
    
    
    @Override
    public String toString()
    {
        return "This emotion is " + this.getIntensity();
    }
}
