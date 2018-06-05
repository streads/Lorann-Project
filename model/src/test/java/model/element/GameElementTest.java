package model.element;

import static org.junit.Assert.*;

import org.junit.Test;

import model.ModelFacade;

public class GameElementTest {

	@Test
	public void testGameElementString() {
		GameElement testElement = new GameElement("r");
		assertEquals("The identifier should be r", "r", testElement.getIdentifier());
		assertEquals("The tag should be r_0 because default the state is 0", "r_0", testElement.getTag());

	}

	@Test
	public void testGameElementStringInt() {
		GameElement testElement = new GameElement("r", 1);
		assertEquals("The identifier should be r", "r", testElement.getIdentifier());
		assertEquals("The tag should be r_1 because the tag is identifer_tag", "r_1", testElement.getTag());

	}

	@Test
	public void testSetColliderManager() {
		ModelFacade facade = new ModelFacade();
		facade.loadLevel(1);
		GameElement testElement = new GameElement("a", 1);
		testElement.setPostion(1, 1);
		testElement.setColliderManager(new OnCollisionStrategy() {
			
			@Override
			public void collider(GameElement me, GameElement target) {
				if (target.getIdentifier() == "b") {
					System.out.println("called");
					target.kill();
				}
				
			}
		});
		GameElement testElement2 = new GameElement("b", 1);
		testElement2.setPostion(1, 1);
		facade.getLevel().addElement(testElement);
		facade.getLevel().addElement(testElement2);
		assertNotNull("The element should exist", testElement2.getLevel());

		testElement.collide(testElement2);
		assertNull("The element should be killed by 'a'", testElement2.getLevel());
	}

	@Test
	public void testSetTickManager() {
		ModelFacade facade = new ModelFacade();
		facade.loadLevel(1);
		GameElement testElement = new GameElement("a", 1);
		testElement.setPostion(1, 1);
		testElement.setTickManager(new OnTickStrategy() {
			
			@Override
			public void onTick(GameElement me) {
				me.setState(me.getState() + 1);
			}
			
			
		});
		
		for(int i = 2; i < 10; i++) {
			testElement.tick();
			assertEquals(i, testElement.getState());	
		}

		
		
	}

}
