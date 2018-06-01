package model.element;

import java.awt.Image;
import java.util.ArrayList;
import model.element.special.Monster;

public class GameElementFactory {
	

	
	// Example
	public static GameElement Createdoor(boolean IsClosed) { 
		GameElement x = new GameElement("D", new ArrayList<Image>());
		x.SetColliderManager(new OnCollisionStrategy() {
			
			@Override
			public void Collider(GameElement me, GameElement target) {
				if(target.identifier == "L") {
					if (me.state == 0) { // door closed
						target.kill();
					}
				}
			}
		});
		
		return x;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static GameElement createMonster1() {
		GameElement x = new Monster("L", new ArrayList<Image>());
		x.SetTickManager(new OnTickStrategy() {
			@Override
			public void onTick(GameElement me) {
				// TODO Auto-generated method stub
				
			}
		});
		return x;
	}
}
