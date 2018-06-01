package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.IModel;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Lucas LUDMANN lucas.ludmann@viacesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController, Runnable {
	
	private static final int LEVEL_NUMBER = 1;
    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;
    
    private EUserOrder nextOrder; /** ordre de d�placement pour le model stock�e/** 

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
        this.getView().setController(this);
        this.getModel().setController(this);
     
    }

    /**
     * Start.
     */
    public void start() {
    	   
        this.getView().displayMessage("WELCOME TO THE CRYPT");
    	try {
			this.getModel().loadLevel(LEVEL_NUMBER);
			this.getView().createUI(this.getModel().getLevelDimension().height, this.getModel().getLevelDimension().width);
	    	this.run();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
 
    }
    private void sendSpritToView() {
    	List<String> elm = new ArrayList<String>();
		for (int x = 0; x < this.getModel().getLevelDimension().height; x++) {
    		for (int y = 0; y < this.getModel().getLevelDimension().width; y++) {
    			elm.add(this.getModel().getTagElement(x, y)); 
    		}
		}
		this.getView().refreshModelData(elm);
    }
    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }

	@Override
	public void run() {
    	for( ;; ) {
    		sendSpritToView();
    		this.getModel().moveEntities(nextOrder); // on r�cupere l'ordre de d�placement 
    		nextOrder = EUserOrder.NOP; // Permet de dire que l'ordre � �t� effectuer 
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
    		
    	}
	}

	@Override
	/**	on passe au controleur l'ordre que nous envoie la vue 
	*/
	public void orderPerformer(EUserOrder userOrder) {
		nextOrder = userOrder;
		
		
	}
}









