package model;

import java.awt.Dimension;
import java.sql.SQLException;

import controller.EUserOrder;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Lucas Ludmann
 * @version 1.0
 */
public interface IModel {
	
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
     public String loadLevel ( int indice) throws SQLException; 
     
     /**
  	 * execute the moving algorithm of element
  	 * @param indice 
  	 *     playerAction the action wished by player  
  	 */
     public void moveEntities(EUserOrder playerAction);
     
     
     /**
      * 
      * @return the score of the player 
      */
     public int getScore();
     
     
     
     
     
   
     
}
