import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Maiz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cultivo extends Actor
{
    private Counter vidaCul;
    private int nivel;
    private int vida = 0;
    public Cultivo(int nivel)
    {
        vidaCul = new Counter();
        vidaCul.setValue(200);
        this.nivel = nivel;
    }
    
    /**
     * Act - do whatever the Maiz wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        vida();
        if(nivel == 1)
        {
            muerte1();
        }
        if(nivel == 2)
        {
            muerte2();
        }
        if(nivel == 3)
        {
            muerte3();
        }
    }
    
    /**
     * Este metodo le quita vida al cultivo si un bicho se lo esta comiendo
     */
    public void vida()
    {
        if(this.isTouching(Bicho1.class) || this.isTouching(Bicho2.class)
                                         || this.isTouching(Bicho3.class))
        {
            vidaCul.setValue((vidaCul.getValue())-1);
        }
    }
    
    /**
     * Este metodo elimina el cultivo si ya se quedo sin vida
     */
    public void muerte1()
    {
        if(vidaCul.getValue() == 0)
        {
            World miMundo = getWorld();
            Nivel1  n1 = (Nivel1)miMundo;
            n1.setCultivo();
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Este metodo elimina el cultivo si ya se quedo sin vida
     */
    public void muerte2()
    {
        if(vidaCul.getValue() == 0)
        {
            vida = 1;
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Este metodo elimina el cultivo si ya se quedo sin vida
     */
    public void muerte3()
    {
        if(vidaCul.getValue() == 0)
        {
            getWorld().removeObject(this);
        }
    }
    /**metodo para devolver vidas del cultivo*/
    public int getVida()
    {
        return vida;
    }
}
