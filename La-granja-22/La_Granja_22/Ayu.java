import greenfoot.*;

/**
 * Escribe una descrición de la clase Ayu aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Ayu extends World
{

    /**
     * Constructor para objetos de clase Ayu.
     * 
     */
    public Ayu()
    {    
        // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
        super(600, 380, 1); 
         Mainmenu mainme = new Mainmenu();
        addObject(mainme, 550, 350);
    }
}
