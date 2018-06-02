package view;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.EUserOrder;
import controller.IController;
import showboard.BoardFrame;

public class Frame extends BoardFrame implements KeyListener {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4694925017397478123L;
	/**
     * Access point to the controller
     */
	private IController controller;
	
	
	public Frame(String title, IController controller)
	{
		super(title);
		this.controller = controller;
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//Detect the keypressed and order an action to the controller
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode())
	    {
	    case KeyEvent.VK_UP:
	        this.controller.orderPerformer(EUserOrder.TOP);
	            break;
	    case KeyEvent.VK_DOWN:
	        this.controller.orderPerformer(EUserOrder.BOTTOM);
	            break;
	    case KeyEvent.VK_LEFT:
	        this.controller.orderPerformer(EUserOrder.LEFT);
	            break;
	    case KeyEvent.VK_RIGHT:
	        this.controller.orderPerformer(EUserOrder.RIGHT);
	            break;
	    case KeyEvent.VK_SPACE:
	    	this.controller.orderPerformer(EUserOrder.SPELLCAST);
	            break;
	    default:
	    	this.controller.orderPerformer(EUserOrder.NOP);
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
