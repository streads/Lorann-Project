package model.element;

import model.element.special.Monster;
import model.element.special.Player;

public class GameElementFactory {
	

		
	
	public static GameElement createMonster1() {
		GameElement x = new Monster("monster");
		x.SetTickManager(new OnTickStrategy() {
			@Override
			public void onTick(GameElement me) {
				// TODO Auto-generated method stub
				
			}
		});
		return x;
	}
	
	
	public static GameElement createMonster2() {
		GameElement x = new Monster("monster", 1);
		x.SetTickManager(new OnTickStrategy() {
			@Override
			public void onTick(GameElement me) {
				// TODO Auto-generated method stub
				
			}
		});
		return x;
	}
	
	
	
	
	public static GameElement createMonster3() {
		GameElement x = new Monster("monster", 2);
		x.SetTickManager(new OnTickStrategy() {
			@Override
			public void onTick(GameElement me) {
				// TODO Auto-generated method stub
				
			}
		});
		return x;
	}
	
	
	
	public static GameElement createMonster4() {
		GameElement x = new Monster("monster", 3);
		x.SetTickManager(new OnTickStrategy() {
			@Override
			public void onTick(GameElement me) {
				// TODO Auto-generated method stub
				
			}
		});
		return x;
	}
	
	public static GameElement createCrystalBall() {
		GameElement x = new Monster("CrystalBall");
		x.SetTickManager(new OnTickStrategy() {
			@Override
			public void onTick(GameElement me) {
				// TODO Auto-generated method stub
				
			}
		});
		return x;
	}
	
	public static GameElement createClosedDoor() {
		GameElement x = new GameElement("door", 1);
		return x;
	}
	
	public static GameElement createLorann() {
		GameElement x = new Player("lorann");
		return x;
	}
	
	public static GameElement createOpenedDoor() {
		GameElement x = new GameElement("door");
		x.setPermeability(EPermeability.ALLOW_Player);
		return x;
	}
	
	public static GameElement createPurse() {
		GameElement x = new GameElement("purse");
		x.setPermeability(EPermeability.ALLOW_Player);
		return x;
	}
	
	public static GameElement createVerticalBone() {
		GameElement x = new GameElement("bone", 2);
		return x;
	}
	
	public static GameElement createHorizontalBone() {
		GameElement x = new GameElement("bone", 1);
		return x;
	}
	public static GameElement createBone() {
		GameElement x = new GameElement("bone");
		return x;
	}
	
}
