package model;

import java.awt.Dimension;

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
     *
 	 */	
     public String loadLevel ( int indice); 
     
     /**
  	 * execute the moving algorithm of element
  	 * @param playerAction 
  	 *     playerAction the action wished by player  
  	 */
     public void moveEntities(EUserOrder playerAction);
     
     
     /**
      * Get the score of the player
      */
     public int getScore();
     
     
     /**
      * Get the current state of the game
      * @return a EGameState
      * 	
      */
     public EGameState getLevelState();
     
     
     
   
     
}
