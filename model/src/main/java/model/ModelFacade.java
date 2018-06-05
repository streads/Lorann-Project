package model;

import java.awt.Dimension;
import java.sql.SQLException;

import controller.EUserOrder;
import model.dao.ADataBaseUseDAO;


/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Thibault HANNA thibault.hanna@viacesi.fr
 * @version 1.0
 */
/**
 * @author 1843251
 *
 */
/**
 * @author 1843251
 *
 */
/**
 * @author 1843251
 *
 */
public final class ModelFacade implements IModel {

	
	private Level level = null;
	
    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
    }

    
    /**
     * With this function you can obtain the tag of an element (identifier_state) by his coordonate
     */
	/* (non-Javadoc)
	 * @see model.IModel#getTagElement(int, int)
	 */
	@Override
	public String getTagElement(int x, int y) {
		if (level != null) {
			if (level.getElement(x, y) != null) {
				return level.getElement(x, y).getTag();	
			}else {
				return null;
			}
		}else {
			System.err.println("level not loaded");
			return null;
		}
		
	}

	/* (non-Javadoc)
	 * @see model.IModel#getLevelDimension()
	 */
	@Override
	public Dimension getLevelDimension() {
		// TODO Auto-generated method stub
		if (level != null) {
			return new Dimension(this.getLevel().getWidth(), this.getLevel().getHeight());
		}else {
			System.err.println("Level not loaded");
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see model.IModel#loadLevel(int)
	 */
	@Override
	public String loadLevel(int indice) {
		try {
			this.setLevel(ADataBaseUseDAO.getLevelByNumber(indice));
			return this.getLevel().getName();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see model.IModel#moveEntities(controller.EUserOrder)
	 */
	@Override
	public void moveEntities(EUserOrder playerDirection) {
		if (level != null) {
			level.tick(playerDirection);
		} else {
			System.err.println("Level not loaded");
		}
	}
	
	/**
	 * Get the current level played
	 */
	public Level getLevel() {
		return this.level;
	}
	/**
	 * Set the current level played
	 * @param level
	 */
	private void setLevel(Level level) {
		this.level = level;
	}

	/* (non-Javadoc)
	 * @see model.IModel#getScore()
	 */
	@Override
	public int getScore() {
		return this.getLevel().getScore();
	}

	/* (non-Javadoc)
	 * @see model.IModel#getLevelState()
	 */
	@Override
	public EGameState getLevelState() {
		if(level == null) {
			return EGameState.LEVEL_NOT_STARTED;
		}else {
			if(level.getPlayer() == null) {
				return EGameState.LEVEL_LOOSED;
			}else {
				if(level.IsOver() == false) {
					return EGameState.LEVEL_IS_RUNNING;
				}else {
					return EGameState.LEVEL_WON;
				}
			}
		}
	}





}
