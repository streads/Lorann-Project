package view;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestViewFacade {

	@Test
	public void testCreateUI(){
		ViewFacade test = new ViewFacade();
        test.createUI(31, 20);
        assertNotNull("Window wasn't generated", test.getFrame());
        assertEquals("Invalid width", 31,  test.getDimension().width);
        assertEquals("Invalid height", 20,  test.getDimension().height);
	}
	
	@Test
	public void testRefresh(){
		ViewFacade test = new ViewFacade();
        test.createUI(20, 20);
        test.setScore(400);
        test.setLevelName("Test level");
        String[][] x = new String[20][20];
        test.refreshModelData(x);
        assertEquals(test.getFrame().getTitle(), "Lorann [Test level] score: 400", test.getFrame().getTitle());
	}
	
	@Test
	public void testLoadImage() throws IOException {
		Tile tile = new Tile("black");
		tile.loadImage();
		assertEquals("black", tile.getImageName());
		assertNotNull(tile.getImage());	
	}

}
