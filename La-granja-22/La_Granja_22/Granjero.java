import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Granjero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Granjero extends Actor
{
   
    private GreenfootImage image1= new GreenfootImage("jugador3.png");//dere
    private GreenfootImage image2= new GreenfootImage("jugador2.png");//Izqui 
    private GreenfootImage image3= new GreenfootImage("jugador1.png");
    private GreenfootImage image4= new GreenfootImage("jugador4.png");

    private GreenfootImage image5= new GreenfootImage("jugador7.png");//derecha
    private GreenfootImage image6= new GreenfootImage("jugador6.png");//izquierda   
    private GreenfootImage image7= new GreenfootImage("jugador8.png");//arriba
    private GreenfootImage image8= new GreenfootImage("jugador5.png");//abajo
    private int direccion;
    private int speed = 5 ;
    private int i;
    private Counter vidas;
    private Counter puntos;
    private int nivel;
    /**contructor de inicialisacion del granjero
       */
    public Granjero(int vida, int nivel, int puntos)
    {
        vidas = new Counter();
        this.puntos = new Counter();
        this.vidas.setValue(vida);
        this.puntos.setValue(puntos);
        this.nivel = nivel;
    }
    
    public void act() 
    {
        // Add your action code here.
        movimientos();
        Disparar();
        muerte();
        puntos();
        vidas();
    }
    /**Metodo para mover al granjero*/
    public void  movimientos()
    {
       //mueve a el granjero para la derecha
        if(Greenfoot.isKeyDown("right"))
        {
           direccion = 1;                                  //1 Derecha
            this.setLocation(this.getX()+speed,this.getY());
            setImage(image1);
            i++;
            if(i%2 == 0)
               setImage(image5);
        }
     
        //mueve a el granjero para la izquierda
        if(Greenfoot.isKeyDown("left"))
        {
          direccion = 2;                                  //2 Izquierda
            this.setLocation(this.getX()-speed,this.getY());
            setImage(image2);
            i++;
            if(i%2 == 0)
               setImage(image6);
             
        }
         //mover para arriba a el granjero del usuario
        if(Greenfoot.isKeyDown("up"))
        {
            direccion = 3;                                 
             this.setLocation(this.getX(),this.getY()-speed);
            setImage(image4);
            i++;
            if(i%2 == 0)
               setImage(image7);
           
        }
         
         //mover el granjero del usuario a hacia abajo      
        if(Greenfoot.isKeyDown("down"))
        {
         direccion = 4;                                 
            this.setLocation(this.getX(),this.getY()+speed);
            setImage(image3);
            i++;
            if(i%2 == 0)
               setImage(image8);     
        }
    }
     /**
    *Metodo para poder disparar  
    */
    public void Disparar()
    {
        if(nivel == 1)
            if(("a").equals(Greenfoot.getKey()))
            {
                 Arma1 dis = new Arma1(direccion);
                 getWorld().addObject(dis, getX(), getY()+10);   
                 //Greenfoot.playSound("kri-fire.wav");
            }
        if(nivel == 2)    
            if(("s").equals(Greenfoot.getKey()))
            {
                Arma2 dis = new Arma2(direccion);
                getWorld().addObject(dis, getX(), getY()+10);   
                //Greenfoot.playSound("kri-fire.wav");
            }
        if(nivel == 3)
        {
            if(("d").equals(Greenfoot.getKey()))
            {
                Arma3 dis = new Arma3(direccion);
                getWorld().addObject(dis, getX(), getY()+10);   
                //Greenfoot.playSound("kri-fire.wav");
            }
        }
    }
    /**metodo para de volver  vidas del granjero
       */
    public int getVidas()
    {
        return vidas.getValue();
    }
    /** Metodo para de volver puntos del granjero*/
    public int getPuntos()
    {
        return puntos.getValue();
    }
    /** Metodo para quitarles las vidas al granjero*/
    public void muerte()
    {
        if(isTouching(Bicho1.class) || isTouching(Bicho2.class) || isTouching(Bicho3.class))
        {
            vidas.setValue(vidas.getValue()-1);
            this.setLocation(20,200);
        }
    }
    /**Metodo para ganar vidas */
    public void vidas()
    {
        if(isTouching(Itemvida.class))
        {
            if(nivel == 1)
            {
                World miMundo = getWorld();
                Nivel1  n1 = (Nivel1)miMundo;
                n1.removeObject(getOneIntersectingObject(Itemvida.class));
                vidas.setValue(vidas.getValue()+1);
            }
            if(nivel == 2)
            {
                World miMundo = getWorld();
                Nivel2  n2 = (Nivel2)miMundo;
                n2.removeObject(getOneIntersectingObject(Itemvida.class));
                vidas.setValue(vidas.getValue()+1);
            }
            if(nivel == 3)
            {
                World miMundo = getWorld();
                Nivel3  n3 = (Nivel3)miMundo;
                n3.removeObject(getOneIntersectingObject(Itemvida.class));
                vidas.setValue(vidas.getValue()+1);
            }
        }
    }
    /**Metodo para ganar puntos*/
    public void puntos()
    {
        if(isTouching(Itempuntos.class))
        {
            if(nivel == 1)
            {
                World miMundo = getWorld();
                Nivel1  n1 = (Nivel1)miMundo;
                n1.removeObject(getOneIntersectingObject(Itempuntos.class));
                puntos.setValue(puntos.getValue()+10);
            }
            if(nivel == 2)
            {
                World miMundo = getWorld();
                Nivel2  n2 = (Nivel2)miMundo;
                n2.removeObject(getOneIntersectingObject(Itempuntos.class));
                puntos.setValue(puntos.getValue()+10);
            }
            if(nivel == 3)
            {
                World miMundo = getWorld();
                Nivel3  n3 = (Nivel3)miMundo;
                n3.removeObject(getOneIntersectingObject(Itempuntos.class));
                puntos.setValue(puntos.getValue()+10);
            }
        }
    }
}
