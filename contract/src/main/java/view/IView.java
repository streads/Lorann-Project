package view;

import controller.IController;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    public void displayMessage(String message);
    
    /**
     * Set the value of the controller inside the View
     */
    public void setController(IController controller);
    
    /**
     * Generate the graphical interface of a level 
     * @param columns
     *     columns of the level
     * @param rows
     *     rows of the level
     */
	public void createUI(int columns, int rows);
	    
	/**
	 * Set the score of the player
	 * @param score
	 *     score of the player
	 */
	public void setScore(int score);	
	
	/**
	 * Set the current level name
	 * @param name
	 *     name of the current level
	 */
	public void setLevelName(String name);
	
	/**
	 * Refreshes the window
	 * @param elementsTag
	 *     An array of element tag to disp on the window
	 */
	public void refreshModelData(String[][] elementsTag);



}