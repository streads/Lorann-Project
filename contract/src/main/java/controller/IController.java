package controller;

import model.IModel;
import view.IView;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Lucas LUDMANN lucas.ludmann@viacesi.fr
 * @version 1.0
 */
public interface IController extends IOrderPerformer{
	
    /**
     * start the controller.
     */
	public void start(); 
	
    /**
     * Return the model used by the controller.
     */
	public IModel getModel();

    /**
     * Return the view used by the controller.
     */
	public IView getView(); 

}
