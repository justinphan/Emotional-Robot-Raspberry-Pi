package edu.ccsu.cs417.cs417group1.emotion;

import java.awt.*;
public class OptimistFactory implements AbstractFactory
{
    /**
     * Returns an IEmotion product based on  
     * @param color: java.awt.Color object returned by the camera
     */
    public AbstractProduct produceEmotion(Color color){
        if(color.getBlue() > 100
            && color.getGreen() > 100
            && color.getRed() > 100){
            Comfort p = new Comfort();
            IEmotion a = new Joy();
            p.addComponent(a);
            p.addComponent(new WeakEmotion(new Joy(),5.0));
            return p;
        }
        if(color.getBlue() <= 100
            && color.getGreen() <= 100
            && color.getRed() > 100){
            return new IntenseEmotion(new Joy(),5.0);
        }
        if(color.getBlue() <= 100
            && color.getGreen() > 100
            && color.getRed() <= 100){
            Comfort p = new Comfort();
            IEmotion a = new Bravery();
            p.addComponent(a);
            p.addComponent(new IntenseEmotion(new Joy(),5.0));
            return p;
        }
        if(color.getBlue() > 100
            && color.getGreen() > 100
            && color.getRed() <= 100){
            return new Joy();
        }
        if(color.getBlue() <= 100
            && color.getGreen() <= 100
            && color.getRed() > 100){
            return new WeakEmotion(new Hunger(),10.0);
        }
        if(color.getBlue() > 100
            && color.getGreen() <= 100
            && color.getRed() <= 100){
            return new IntenseEmotion(new Joy(),10.0);
        }
        //default
        return new Joy();   
    }
}


