import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arma1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
   
public class Arma1 extends Actor
{
     private GreenfootImage image1= new GreenfootImage("arma1-1.png");//dere
    private GreenfootImage image2= new GreenfootImage("arma1-2.png");//Izqui 
    private GreenfootImage image3= new GreenfootImage("arma1-3.png");
    private GreenfootImage image4= new GreenfootImage("arma1-4.png");
    private int dir;
    public Arma1(int dir)
    {
        this.dir = dir;
    }
    
    public void act() 
    {
         World miMundo = getWorld();
         Nivel1  n1 = (Nivel1)miMundo;
        direccion();
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
        else
            if(isTouching(Bicho1.class))
            {
                n1.removeObject(getOneIntersectingObject(Bicho1.class));
                getWorld().removeObject(this);
                n1.bichosMuertos();
            }
    }
      /**Metodo para cambiar la direcion de la arma e imagen*/
    public void direccion()
    {
        if(dir == 1)
        {
            setImage(image1);
            this.setLocation(this.getX()+5, this.getY());
        }
        if(dir == 2)
        {
            setImage(image2);
            this.setLocation(this.getX()-5, this.getY());
        }
        if(dir == 3)
        {
            setImage(image3);
            this.setLocation(this.getX(), this.getY()-5);
        }
        if(dir == 4)
        {
            setImage(image4);
            this.setLocation(this.getX(), this.getY()+5);
        }
    }
}

