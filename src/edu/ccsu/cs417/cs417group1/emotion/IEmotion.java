package edu.ccsu.cs417.cs417group1.emotion;

public interface IEmotion extends AbstractProduct
{
    public void express();
    public void addComponent(IEmotion e);
    public IEmotion removeComponent(String desc);
    public IEmotion getChild(String desc);


    
   @Override
   public boolean equals(Object o);
   @Override
   public int hashCode();
   @Override
   public String toString();
}