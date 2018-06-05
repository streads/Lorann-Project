package model;

import static org.junit.Assert.*;
import org.junit.Test;
import controller.EUserOrder;

public class LevelTest {

	
	/**
	 * Test the constructor of the Level class
	 */
	@Test
	public void testLevelIntStringIntInt() {
		Level level = new Level(4, "This is level 4", 20, 12);
		assertEquals("Bad id", 4,  level.getId());
		assertEquals("Bad width", 20,  level.getWidth());
		assertEquals("Bad height", 12,  level.getHeight());
		assertEquals("Bad name", "This is level 4", level.getName()); 
		assertEquals(0, level.getScore());
	}

	
	/**
	 * Test the constructor of the Level class
	 */
	@Test
	public void testLevelStringIntInt() {
		Level level = new Level("This is level 6", 30, 18);
		assertEquals("Bad width", 30,  level.getWidth());
		assertEquals("Bad height", 18,  level.getHeight());
		assertEquals("Bad name", "This is level 6", level.getName());
		assertEquals(0, level.getScore());
	}
	
	
	/**
	 * Test the constructor of the Level class
	 */
	@Test
	public void testGetSetScore() {
		Level level = new Level("Test", 30, 18);
		level.setScore(50);
		assertEquals(50, level.getScore());
	}

	/**
	 * Try the method add and  remove an element from the level
	 */
	@Test
	public void testAddRemoveElement() {
		Level level = new Level("Test", 30, 18);
		level.addElement("1", 1, 1);
		assertNotNull("Element not added", level.getElement(1, 1));
		level.removeElement(level.getElement(1, 1));
		level.tick(EUserOrder.NOP);
		assertNull("Element not removed", level.getElement(1, 1));
	}

	/**
	 * Test if the getElement method is working fine
	 */
	@Test
	public void testGetElement() {
		Level level = new Level("Test", 30, 18);
		level.addElement("1", 1, 1);
		
		assertNotNull("Element not found", level.getElement(1, 1));
	}

	
	/**
	 * Test if the method getPlayer return null if there 
	 * is not player and a GameElement if lorann is alive
	 */
	@Test
	public void testGetPlayer() {
		Level level = new Level("Test", 30, 18);
		level.addElement("L", 1,2);
		assertNotNull("Player not found", level.getPlayer());
	}

	/**
	 * Test the method used to know if the game is running
	 * by killed the player and cheking the state after
	 */
	@Test
	public void testIsOver() {
		Level level = new Level("Test", 30, 18);
		level.addElement("L", 1,2);
		assertEquals("The game sould be running", false, level.IsOver());
		level.getElement(1, 2).kill();
		level.tick(EUserOrder.NOP);
		assertEquals("The game should be over", true, level.IsOver());
	}

	/**
	 * Test the method that permitte to add element in the level thank's to an identifier and a x,y postion
	 */
	@Test
	public void testAddElementStringIntInt() {
		Level level = new Level("Test", 30, 18);
		level.addElement("L", 1,2);
		assertEquals("The entity should be a lorann", "lorann", level.getElement(1, 2).getIdentifier());
	}
}
