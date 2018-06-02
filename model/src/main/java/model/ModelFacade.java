package model;

import java.awt.Dimension;
import java.sql.SQLException;

import controller.EUserOrder;
import controller.IController;
import model.dao.ADataBaseUseDAO;


/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Thibault HANNA thibault.hanna@viacesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModel {

    /**
     * Instantiates a new model facade.
     */
	protected Level level = null;
	
    public ModelFacade() {
        super();
    }

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
	@Override
	public void loadLevel(int indice) throws SQLException {
		this.setLevel(ADataBaseUseDAO.getLevelByNumber(indice));
	}

	@Override
	public void moveEntities(EUserOrder playerDirection) {
		if (level != null) {
			level.tick();
			
		}else {
			System.err.println("Level not loaded");
		}
		
		
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public void setController(IController controller) {
		// TODO Auto-generated method stub
		
	}




}
