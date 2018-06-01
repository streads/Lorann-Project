package model;

import java.awt.Dimension;
import java.awt.Image;

import controller.EUserOrder;
import controller.IController;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Lucas Ludmann
 * @version 1.0
 */
public interface IModel {
	
    /**
     * Set the value of the controller inside the Model
     */
    public void setController(IController controller);
    
	/**
	 * retrieves a sprite from an element at a certain position x or y
	 * @param x
	 *     position in abscissa of an element 
	 * @param y 
	 *     position in orderly of an element
	 */	
	public Image getSpriteElement(int x, int y);
	
	/**
	 * get the size of the map
	 * @return 
	 *     dimension of the window
	 */	
     public Dimension getMapSize(int x, int y);
     
     /**
 	 * allows to load the environment
 	 * @param indice 
 	 *     indice is the level ID   
 	 */	
     public void loadMap ( int indice); 
     
     /**
  	 * execute the moving algorithm of element
  	 * @param indice 
  	 *     loranDirection the direction of lorann  
  	 */
     public void moveEntities(EUserOrder lorannDirection);
     
     
     
     
     
   
     
}
