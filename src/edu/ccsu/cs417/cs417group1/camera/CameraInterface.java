/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.cs417.cs417group1.camera;

import java.awt.Color;

/**
 *
 * @author phuphanmbp
 * This interface defines a camera that can take a picture and calculate the average color
 */
public interface CameraInterface {
    /**
    * This method take a picture
    * @return the average color type Color
    */
   public String takePicture();
   
   @Override
   public boolean equals(Object o);
   @Override
   public int hashCode();
   @Override
   public String toString();
}
