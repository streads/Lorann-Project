package view;

import java.awt.Image;
import java.util.List;

import javax.swing.JOptionPane;

import controller.IController;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Hugo Peterhansel
 * @version 1.0
 */

public class ViewFacade implements IView {
	
    /**
     * Initiates a window
     */
	private Frame frame;
	
    /**
     * Access point to the controller
     */
	private IController controller;
	
    /**
     * Instantiates a new view facade.
     */
    public ViewFacade() {
        super();
    }
    
    /**
     * Set the value of the controller inside the View
     */
    @Override
	public void setController(IController controller)
	{
		this.controller = controller;
	}

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

	@Override
	public void createUI(int height, int width) {
		frame = new Frame("Loop view", controller);
		
	}

	@Override
	public void setScore(int score) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLevelName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refreshModelData(List<Image> sprites) {
		/*int elements = 0;
        for (int y = 0; y < sprites.size() / width; y++ ) {
			for(int x = 0; x < width; x++) {
				String spriteLocation = sprites.get(elements) + " " + String.valueOf(x) + ";" + String.valueOf(y);
                displayMessage(spriteLocation);
                elements++;    
			}
		}*/
	}
	
	public Frame getFrame() {
		return frame;
	}
}
