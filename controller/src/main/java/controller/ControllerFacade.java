package controller;

import model.EGameState;
import model.IModel;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Lucas LUDMANN lucas.ludmann@viacesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController, Runnable {
	
	private int levelNumber = 2;
    
	private int score = 0;
	
	/** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;
    
    
    
    
    private EUserOrder nextOrder = EUserOrder.NOP; /** displacement order for the stored model
/** 

	

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
        this.getView().setLevelName(this.getModel().loadLevel(levelNumber)); 
		this.getView().createUI(this.getModel().getLevelDimension().width, this.getModel().getLevelDimension().height);
		this.run();
    }
    
    private void refreshView() {
    	
    	this.getView().setScore(this.getScore() + this.getModel().getScore());
    	
    	String[][] elms =  new String[this.getModel().getLevelDimension().width][this.getModel().getLevelDimension().height];
		for (int x = 0; x < this.getModel().getLevelDimension().width; x++) {
    		for (int y = 0; y < this.getModel().getLevelDimension().height; y++) {
    			elms[x][y] = this.getModel().getTagElement(x, y); 
    		}
		}
		this.getView().refreshModelData(elms);
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
		EGameState gameState =  this.getModel().getLevelState();

    	while ( gameState == EGameState.LEVEL_IS_RUNNING ) {
    		gameState =  this.getModel().getLevelState();
    		refreshView();
    		
    		this.getModel().moveEntities(nextOrder); // we recover the movement order

    		nextOrder = EUserOrder.NOP; // Allows to say that the order has been made 
    		try {
				Thread.sleep(12);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
    	}
    	
    	switch(gameState) {
    		case LEVEL_LOOSED:
    			this.getView().displayMessage("Game over");	
    			System.exit(0);
    			break;
    		case LEVEL_WON:
    			setScore(score + this.getModel().getScore());
    			setLevel(levelNumber + 1);
    			start();
    			break;
		default:
			break;
		}
    	    
	}

	@Override
	/**	we pass to the controller the order that sends us the view */
	public void orderPerformer(EUserOrder userOrder) {
		nextOrder = userOrder;
	}
	
	/** define the number of the level */ 
	public void setLevel(int level) {
		levelNumber = level;
	}
	
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int value) {
		this.score = value;
	}
}









