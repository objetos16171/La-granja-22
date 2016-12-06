import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arma3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arma3 extends Actor
{
     private GreenfootImage image1= new GreenfootImage("arma3-1.png");//dere
    private GreenfootImage image2= new GreenfootImage("arma3-2.png");//Izqui 
    private GreenfootImage image3= new GreenfootImage("arma3-3.png");
    private GreenfootImage image4= new GreenfootImage("arma3-4.png");
    private int dir;
    private int cont = 3;
    /**Metodo para la dirrecion en que disparar*/
    public Arma3(int dir)
    {
        this.dir = dir;
    }
    
    public void act() 
    {
         World miMundo = getWorld();
         Nivel3  n3 = (Nivel3)miMundo;
        direccion();
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
        else
            if(isTouching(Bicho3.class))
            {
                n3.removeObject(getOneIntersectingObject(Bicho3.class));
                getWorld().removeObject(this);
            }else
            if(isTouching(Reina.class))
            {
                getWorld().addObject(new Nido(),550,360);
                n3.removeObject(getOneIntersectingObject(Reina.class));
                getWorld().removeObject(this);
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

