package controller;

import model.IModel;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Lucas LUDMANN lucas.ludmann@viacesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController, Runnable {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;

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
    }

    /**
     * Start.
     */
    public void start() {
    	this.getView().displayMessage("Ok");
    	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void orderPerformer(EUserOrder userOrder) {
		// TODO Auto-generated method stub
		
	}
}
