package model;

import java.awt.Dimension;
import java.awt.Image;
import java.sql.SQLException;
import java.util.List;

import model.dao.ExampleDAO;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class ModelFacade implements IModel {

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();
    }

	@Override
	public Image getSpriteElement(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getMapSize(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadMap(int indice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveEntities(EUserOrder loranDirection) {
		// TODO Auto-generated method stub
		
	}

}
