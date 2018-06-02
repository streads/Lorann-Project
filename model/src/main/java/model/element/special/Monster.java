package model.element.special;

import model.element.EPermeability;
import model.element.GameElement;

public class Monster extends GameElement{

	public Monster(String identifier) {
		super(identifier);
		super.setPermeability(EPermeability.ALLOW_Player);
		// TODO Auto-generated constructor stub
	}
	
	public Monster(String identifier, int state) {
		super(identifier, state);
		super.setPermeability(EPermeability.ALLOW_Player);
		// TODO Auto-generated constructor stub
	}

}
