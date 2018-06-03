package model.element.special;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsInstanceOf;

import controller.EUserOrder;
import model.element.EPermeability;
import model.element.GameElement;
import model.element.OnCollisionStrategy;
import model.element.OnTickStrategy;

public class Player extends GameElement {
	int lastTickAction = 0;
	public GameElement me = this;
	public GameElement spell = null;
	private EUserOrder lastMovement = EUserOrder.NOP;
	
	public Player(String identifier) {
		super(identifier);
		super.setPermeability(EPermeability.ALLOW_ALL);
		super.SetColliderManager(new OnCollisionStrategy() {
			
			@Override
			public void Collider(GameElement me, GameElement target) {
				// TODO Auto-generated method stub
				if (target.getIdentifier() == "purse") {
					target.kill();
					me.getLevel().setScore(me.getLevel().getScore() + 100);
				}
				
				if (target.getIdentifier() == "crystalBall") {
					target.kill();
					boolean found = false;
					List<GameElement> doors = new ArrayList<GameElement>();
					for (int i = 0; i < me.getLevel().getWidth(); i++) {
						for (int j = 0; j < me.getLevel().getHeight(); j++) {
							GameElement localElement = me.getLevel().getElement(i, j);
							if (localElement == null) {}
							else if (localElement.getIdentifier() == "crystalBall") {
								System.out.println("on ataper chef");
								found = true;
								return;
							}
							else if (localElement.getIdentifier() == "door") {
								doors.add(localElement);
							}
						}
					}
					
					if (found == false) {
						for (GameElement gameElement : doors) {
							gameElement.setState(0);
						}
					}
				}else if(target instanceof Monster) {
					me.kill();
				}
			}
		});
	}
	
	public void executeOrder(Player me, EUserOrder playerAction) {
		int xPosition = super.getX();
		int yPosition = super.getY();
		if (playerAction != EUserOrder.NOP && playerAction != EUserOrder.SPELLCAST) {lastMovement = playerAction; }
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
			createSpell();
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
	
	
	private void createSpell() {
		int xPosition = super.getX();
		int yPosition = super.getY();
		if (spell == null) {
			spell = new GameElement("fireball", 0);				
			spell.setPermeability(EPermeability.ALLOW_ALL);
			
			switch (lastMovement) {
				case LEFT:
					spell.setPostion(xPosition + 1, yPosition);
					spell.SetTickManager(new  OnTickStrategy() {
						int a = 1;
						int b = -1;
						@Override
						public void onTick(GameElement mySpell) {
							if (mySpell.getState() == 4) {
								mySpell.setState(0);
							}else {
								mySpell.setState(mySpell.getState() + 1);
							}
							
							int xPosition = mySpell.getX();
							int yPosition = mySpell.getY();
							
							GameElement gameElementAim = mySpell.getLevel().getElement(xPosition + a, yPosition);
							if(gameElementAim == null) {
								mySpell.setPostion(xPosition + a, yPosition);
								return ;
							}else if( gameElementAim.getPermeability() == EPermeability.ALLOW_ALL){
								mySpell.setPostion(xPosition + a, yPosition );
								return ;
							} 
							gameElementAim = mySpell.getLevel().getElement(xPosition + b, yPosition);
							if(gameElementAim == null) {
								mySpell.setPostion(xPosition + b, yPosition );
							}else if( gameElementAim.getPermeability() == EPermeability.ALLOW_ALL){
								mySpell.setPostion(xPosition + b, yPosition );
							}
							int c = b;
							b = a;
							a = c;
						}
					});
					break;
				case RIGHT:
					spell.setPostion(xPosition - 1, yPosition);
					spell.SetTickManager(new  OnTickStrategy() {
						int a = -1;
						int b = 1;
						@Override
						public void onTick(GameElement mySpell) {
							if (mySpell.getState() == 4) {
								mySpell.setState(0);
							}else {
								mySpell.setState(mySpell.getState() + 1);
							}
							
							int xPosition = mySpell.getX();
							int yPosition = mySpell.getY();
							
							GameElement gameElementAim = mySpell.getLevel().getElement(xPosition + a, yPosition);
							if(gameElementAim == null) {
								mySpell.setPostion(xPosition + a, yPosition);
								return ;
							}else if( gameElementAim.getPermeability() == EPermeability.ALLOW_ALL){
								mySpell.setPostion(xPosition + a, yPosition );
								return ;
							} 
							gameElementAim = mySpell.getLevel().getElement(xPosition + b, yPosition);
							if(gameElementAim == null) {
								mySpell.setPostion(xPosition + b, yPosition );
							}else if( gameElementAim.getPermeability() == EPermeability.ALLOW_ALL){
								mySpell.setPostion(xPosition + b, yPosition );
							}
							int c = b;
							b = a;
							a = c;
						}
					});
					break;
				case TOP:
					spell.setPostion(xPosition, yPosition + 1);
					spell.SetTickManager(new  OnTickStrategy() {
						int a = 1;
						int b = -1;
						@Override
						public void onTick(GameElement mySpell) {
							if (mySpell.getState() == 4) {
								mySpell.setState(0);
							}else {
								mySpell.setState(mySpell.getState() + 1);
							}
							
							int xPosition = mySpell.getX();
							int yPosition = mySpell.getY();
							
							GameElement gameElementAim = mySpell.getLevel().getElement(xPosition, yPosition + a);
							if(gameElementAim == null) {
								mySpell.setPostion(xPosition, yPosition + a);
								return ;
							}else if( gameElementAim.getPermeability() == EPermeability.ALLOW_ALL){
								mySpell.setPostion(xPosition, yPosition  + a);
								return ;
							} 
							gameElementAim = mySpell.getLevel().getElement(xPosition, yPosition + b);
							if(gameElementAim == null) {
								mySpell.setPostion(xPosition, yPosition + b);
							}else if( gameElementAim.getPermeability() == EPermeability.ALLOW_ALL){
								mySpell.setPostion(xPosition, yPosition + b);
							}
							int c = b;
							b = a;
							a = c;
						}
					});
					break;	
				case BOTTOM:
					spell.setPostion(xPosition, yPosition - 1);
					spell.SetTickManager(new  OnTickStrategy() {
						int a = -1;
						int b = 1;
						@Override
						public void onTick(GameElement mySpell) {
							if (mySpell.getState() == 4) {
								mySpell.setState(0);
							}else {
								mySpell.setState(mySpell.getState() + 1);
							}
							
							int xPosition = mySpell.getX();
							int yPosition = mySpell.getY();
							
							GameElement gameElementAim = mySpell.getLevel().getElement(xPosition, yPosition + a);
							if(gameElementAim == null) {
								mySpell.setPostion(xPosition, yPosition + a);
								return ;
							}else if( gameElementAim.getPermeability() == EPermeability.ALLOW_ALL){
								mySpell.setPostion(xPosition, yPosition  + a);
								return ;
							} 
							gameElementAim = mySpell.getLevel().getElement(xPosition, yPosition + b);
							if(gameElementAim == null) {
								mySpell.setPostion(xPosition, yPosition + b);
							}else if( gameElementAim.getPermeability() == EPermeability.ALLOW_ALL){
								mySpell.setPostion(xPosition, yPosition + b);
							}
							int c = b;
							b = a;
							a = c;
						}
					});
					break;
			}
				
			spell.SetColliderManager(new OnCollisionStrategy() {
			
				@Override
				public void Collider(GameElement mySpell, GameElement target) {
					if (target instanceof Player || target instanceof Monster) {
						Player lcl = (Player) me;
						lcl.spell = null;
						mySpell.kill();
						
					}
					if (target instanceof Monster) {
						target.kill();
					} else if (target.getIdentifier() == "crystalBall") {
						System.out.println("vie");
					}
					System.out.println(mySpell.getIdentifier() + " rencontre un " + target.getIdentifier());
					
				}
			});
			
			if (me.getLevel().getElement(this.spell.getX() , this.spell.getY()) == null){
				me.getLevel().addElement(spell);
			}else if(me.getLevel().getElement(this.spell.getX() , this.spell.getY()).getPermeability() == EPermeability.ALLOW_ALL) {
				me.getLevel().addElement(spell);
			}else {
				this.spell = null;
			}
			
			
		}

	}
	
}
