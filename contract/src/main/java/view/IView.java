package view;

import java.util.List;

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
    void displayMessage(String message);

    
    /**
     * Generate the window of the game
     * @param height
     *     height of the window
     * @param width
     *     width of the windows
     */
	public void createUI(int height, int width);
	    
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
	 * @param sprites
	 *     An array of images to disp on the window
	 */
	public void refreshModelData(List<List<String>> sprites);
	
	    


}