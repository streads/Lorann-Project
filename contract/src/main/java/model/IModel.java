package model;

import java.awt.Dimension;
import java.sql.SQLException;

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
	public String getTagElement(int x, int y);
	
	/**
	 * get the size of the level
	 * @return 
	 *     dimension of the window
	 */	
     public Dimension getLevelDimension();
     
     /**
 	 * allows to load the environment
 	 * @param indice 
 	 *     indice is the level ID   
     * @throws SQLException 
 	 */	
     public void loadLevel ( int indice) throws SQLException; 
     
     /**
  	 * execute the moving algorithm of element
  	 * @param indice 
  	 *     playerDirection the direction wished by player  
  	 */
     public void moveEntities(EUserOrder playerDirection);
     
     
     
     
     
   
     
}
