package controller;

/**
 * <h1>The Interface IOrderPerformer.</h1>
 * 
 * @author Lucas LUDMANN lucas.ludmann@viacesi.fr
 * @version 1.0
 */
public interface IOrderPerformer {
	
    /**
     * Interface to communicate handle view event and controller.
     *
     * @param userOrder
     *            the direction wished by the player
     */
	public void orderPerformer(EUserOrder userOrder);
}
