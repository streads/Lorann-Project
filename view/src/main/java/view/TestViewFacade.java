package view;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestViewFacade {

	@Test
	public void test_createUI(){
		ViewFacade test = new ViewFacade();
        test.createUI(500, 499);
        assertEquals("Not the good height", 500, test.getFrame().getHeight());
        assertEquals("Not the good width", 499, test.getFrame().getWidth());

	}
	
//	@Test
//	public void test_setScore(){
//		ViewFacade test = new ViewFacade();
//        test.setScore(10);
//        assertEquals(10, test.getScore());
//	}
//	
//	@Test
//	public void test_setLevelName(){
//		ViewFacade test = new ViewFacade();
//        test.setLevelName("Level 1");
//        assertEquals("Level 1", test.getName());
//	}

	@Test
	public void test_refreshModeData(){
		//ViewFacade test = new ViewFacade();
        //test.refreshModelData();
        //assertEquals(, test.getSprites());
        fail("Not implemented");
	}
}
