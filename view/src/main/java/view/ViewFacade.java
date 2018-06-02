package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.IOException;
import javax.swing.JOptionPane;

import controller.IController;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Hugo Peterhansel
 * @version 1.0
 */

public class ViewFacade implements IView {
	
	private final Tile x = new Tile("BlackTile.jpg");
	private int tileRow, tileColumn;
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
    
    
    public Dimension getDimension() {
    	return new Dimension(tileRow, tileColumn);
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
	public void createUI(int tileRow, int tileColumn) {
		frame = new Frame("TESTING", controller);
	

	       
	    frame.setDimension(new Dimension(20, 20));
	    frame.setDisplayFrame(new Rectangle(0,0, 200,  200));
	    frame.setSize(200, 200 );
	   
	    
	    
	    try {
			x.loadImage();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    for (int i = 0; i < 20; i++) {
	            for (int j = 0; j < 20; j++) {
	            	
	            	System.out.println(frame.getTitle());
	            	frame.addSquare(x, i, j);
	            }
	           
	    }
	    

	     frame.setVisible(true);
	   
	       
	}

	@Override
	public void setScore(int score) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLevelName(String name) {
		// TODO Auto-generated method stub
		
	}
	int i = 0;
	
	/* (non-Javadoc)
	 * @see view.IView#refreshModelData(java.util.List)
	 */
	@Override
	public void refreshModelData(String[][] elementsTags) {
		//System.err.println(i + ": received " + elementsTags.length + " columns of elements from controller");
		
		for (int x = 0; x < this.getDimension().width; x++) {
			for (int y = 0; y < this.getDimension().height; y++) {
				String elem = elementsTags[x][y];
				if (elem != null) {
					System.out.println(x + ";" + y + ";" + elem);
				}
			}
		}
	}
	
	public Frame getFrame() {
		return frame;
	}
}
