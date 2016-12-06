import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arma2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arma2 extends Actor
{
    private GreenfootImage image1= new GreenfootImage("arma2-1.png");//dere
    private GreenfootImage image2= new GreenfootImage("arma2-2.png");//Izqui 
    private GreenfootImage image3= new GreenfootImage("arma2-3.png");
    private GreenfootImage image4= new GreenfootImage("arma2-4.png");
    private int dir;
    public Arma2(int dir)
    {
        this.dir = dir;
    }
    
    public void act() 
    {
        World miMundo = getWorld();
        Nivel2  n2 = (Nivel2)miMundo;
        direccion();
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
        else
            if(isTouching(Bicho2.class))
            {
                n2.removeObject(getOneIntersectingObject(Bicho2.class));
                getWorld().removeObject(this);
                n2.bichosMuertos();
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
