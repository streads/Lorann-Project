package model.element.special;

import controller.EUserOrder;
import model.element.EPermeability;
import model.element.GameElement;

public class Player extends GameElement {
	int lastTickAction = 0;
	public GameElement me = this;
	
	public Player(String identifier) {
		super(identifier);
		// TODO Auto-generated constructor stub
	}
	
	public void executeOrder(Player me, EUserOrder playerAction) {
		int xPosition = super.getX();
		int yPosition = super.getY();
		
		switch (playerAction) {
		case LEFT:
			xPosition -= 1;
			super.setState(2);
			break;
		case RIGHT:
			xPosition += 1;
			super.setState(6);
			break;
		case TOP:
			yPosition -= 1;
			super.setState(4);
			break;
		case BOTTOM:
			yPosition += 1;
			super.setState(0);
			break;
		case SPELLCAST:
			break;
		case NOP:
			if(super.getState() == 7) {
				super.setState(0);
			}else {
				super.setState(me.getState() + 1);
			}
			break;
		}
		
		GameElement gameElementAim = super.getLevel().getElement(xPosition, yPosition);
		if(gameElementAim == null) {
			super.setPostion(xPosition, yPosition);
		}else if( gameElementAim.getPermeability() == EPermeability.ALLOW_ALL || gameElementAim.getPermeability() == EPermeability.ALLOW_Player){
			super.setPostion(xPosition, yPosition);
		}
		
	}
	
	
}
