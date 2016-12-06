import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

/**
 * Write a description of class Bicho1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bicho1 extends Actor
{
   /**
     * Act - hace lo que Bicho1 quiere hacer. Este método se llama "cuando quiera" o whenever
     * los botones 'Actuar or 'Ejecutar' son presionados en el entorno.
     */
    
    private GreenfootImage run1= new GreenfootImage("enemigo1-7.png");//derecha
    private GreenfootImage run2= new GreenfootImage("enemigo1-1.png");//frente
    private GreenfootImage run3= new GreenfootImage("enemigo1-2.png");//izquierda
    private GreenfootImage run4= new GreenfootImage("enemigo1-3.png");//derecha
    
    
    private int frame = 1;
    private int avance = 0;
    
    
    public void act() 
    {
       
      World m=getWorld();
        if(getX()<getWorld().getWidth())
        {
         move(2);
         
        if(getX()>=m.getWidth()-5||getX()<=5)
        {
         turn(180);
         if(Greenfoot.getRandomNumber(100)<90)
         {
          turn(Greenfoot.getRandomNumber(90-45));
         }
        }
    
        if(getY()>=m.getHeight()-5||getY()<=5)
        {
        turn(180);
        if(Greenfoot.getRandomNumber(100)<90)
        {
        turn(Greenfoot.getRandomNumber(90-45));
        }
        }
        }
      animacion();
  }
  /**Este metodo ase la animacion de bicho1 uno en todas las direcciones 
  */
   public void animacion()
    {
        if(frame == 1)
        {
            setImage(run1);
        }
        else if(frame == 2)
        {
            setImage(run2);
        }
        else if(frame == 2)
        {
            setImage(run2);
        }
        else if(frame == 3)
        {
            setImage(run3);
        }
        else if(frame == 4)
        {
            setImage(run4);
            frame=1;
            return;
        }
        
        if(avance==10)
        {
        frame++;
        avance = 0;
        }
        avance++;
    }
}
