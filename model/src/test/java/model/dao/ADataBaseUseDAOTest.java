package model.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import model.Level;

public class ADataBaseUseDAOTest {

	/**
     * Test the method getLevelByNumber. 
     * Just verify in the first level (the test level) in the DB if the Height of the Level is equals to 12 and the Width to 20
	 * @throws SQLException 
     */
	@Test
	public void testGetLevelByNumber() throws SQLException {
		Level level1 = ADataBaseUseDAO.getLevelByNumber(1);
		assertTrue("Height of the level is not equals to 12", level1.getHeight() == 12);
		assertTrue("Width of the level is not equals to 20", level1.getWidth() == 20);
	}

	
	/**
     * Test the method feedLevel. 
     * Just verify if the method return the good composition of the first level in the DB (The test level) 
	 * @throws SQLException 
     */
	@Test
	public void testFeedLevel() throws SQLException {
		Level level1 = ADataBaseUseDAO.getLevelByNumber(1);
		ADataBaseUseDAO.feedLevel(level1);
		assertTrue("Position of Lorann is wrong", level1.getElement(5,6).getIdentifier() == "lorann");
		assertTrue("Position of Circle Bone is wrong", level1.getElement(5,10).getIdentifier() == "bone");
		assertTrue("Position of Vertical Bone is wrong", level1.getElement(6,1).getIdentifier() == "bone");
	}

	
	/**
     * Test the method getAllLevel. 
     * Just verify if the method return the good properties of the first level (in the first index of the list)
	 * @throws SQLException 
     */
	@Test
	public void testGetAllLevel() throws SQLException {
		List<Level> levels = ADataBaseUseDAO.getAllLevel();
		assertTrue("Height of the level is not equals to 12", levels.get(0).getHeight() == 12);
		assertTrue("Width of the level is not equals to 20", levels.get(0).getWidth() == 20);
	}

}
