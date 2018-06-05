package model;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.EUserOrder;

public class ModelFacadeTest {

	ModelFacade model = new ModelFacade();
	
	@Test
	public void testLoadLevel() {
		model.loadLevel(1);
		assertEquals(1, model.getLevel().getId());
	}
	@Test
	public void testGetTagElement() {
		model.loadLevel(1);
		assertEquals("At this position it should be a lorann", "lorann_0", model.getTagElement(5, 6));
		assertEquals("At this position it should be a lorann", "bone_0", model.getTagElement(5, 10));
	}

	@Test
	public void testGetLevelDimension() {
		model.loadLevel(1);
		assertEquals("The height should be 12", 12, model.getLevelDimension().height);
		assertEquals("The width should be 20", 20, model.getLevelDimension().width);
	}

	
	@Test
	public void testMoveEntities() {
		model.loadLevel(1);
		model.moveEntities(EUserOrder.BOTTOM);
		assertNull("This position should be empty", model.getTagElement(5, 6));
		assertEquals("Lorann should move on this position", "lorann_0", model.getTagElement(5, 7));
		model.moveEntities(EUserOrder.TOP);
		assertTrue("Lorann should move on this position", model.getTagElement(5, 6).contains("lorann"));
		assertNull("This position should be empty", model.getTagElement(5, 7));
		model.moveEntities(EUserOrder.LEFT);
		assertTrue("Lorann should move on this position", model.getTagElement(4, 6).contains("lorann"));
		assertNull("This position should be empty", model.getTagElement(5, 6));
		model.moveEntities(EUserOrder.RIGHT);
		assertTrue("Lorann should move on this position", model.getTagElement(5, 6).contains("lorann"));
		assertNull("This position should be empty", model.getTagElement(4, 6));		
	}

	@Test
	public void testGetLevel() {
		model.loadLevel(1);
		assertNotNull(model.getLevel());
	}

	@Test
	public void testGetScore() {
		model.loadLevel(1);
		assertEquals("The level is started but we didn't took any purse the score should be 0", 0, model.getScore(), model.getScore());
	}

	@Test
	public void testGetLevelState() {
		model.loadLevel(1);
		assertEquals("the game should be running because lorann is alive", EGameState.LEVEL_IS_RUNNING, model.getLevelState());
	}

}
