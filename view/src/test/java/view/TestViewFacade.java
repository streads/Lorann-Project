package view;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestViewFacade {
	
    /**
     * Create a test window and check its the width/height
     */
	@Test
	public void testCreateUI(){
		ViewFacade test = new ViewFacade();
        test.createUI(31, 20);
        assertNotNull("Window wasn't generated", test.getFrame());
        assertEquals("Invalid width", 31,  test.getDimension().width);
        assertEquals("Invalid height", 20,  test.getDimension().height);
	}
	
    /**
     * Create a test window, set a score, a level, refresh and check if the good values are shown
     */
	@Test
	public void testRefresh(){
		ViewFacade test = new ViewFacade();
        test.createUI(20, 20);
        test.setScore(400);
        test.setLevelName("Test level");
        String[][] x = new String[20][20];
        x[0][0] = "lorann_0";
        test.refreshModelData(x);
        assertEquals(test.getFrame().getTitle(), "Lorann [Test level] score: 400", test.getFrame().getTitle());
	}
	
    /**
     * Create test Tile, load an image within it and check if the Tile contain the image
     */
	@Test
	public void testLoadImage() throws IOException {
		Tile tile = new Tile("black");
		tile.loadImage();
		assertEquals("black", tile.getImageName());
		assertNotNull(tile.getImage());	
	}

}
