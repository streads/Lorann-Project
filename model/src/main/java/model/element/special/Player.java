package model.element.special;

import java.awt.Image;
import java.util.List;

import controller.EUserOrder;
import model.element.GameElement;
import model.element.OnTickStrategy;

public class Player extends GameElement {

	public Player(String identifier, List<Image> sprites) {
		super(identifier, sprites);
		this.tickManager = new OnTickStrategy() {
			
			@Override
			public void onTick(GameElement me) {
				// TODO Auto-generated method stub
				
			}
		};
		// TODO Auto-generated constructor stub
	}
	
	public void executeOrder(Player me, EUserOrder eUserOrder) {
		
	}
	
	
}
