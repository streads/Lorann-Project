package model.element;
 
import model.element.special.Monster;
import model.element.special.Player;
 
public class GameElementFactory {
   
 
       
	/** Create the monster 'kyracj'
	 * Movement Pattern: move from left to right
	 * @return a GameElement
	 */
    public static GameElement createMonster1() {
        GameElement x = new Monster("kyracj");
        x.setTickManager(new OnTickStrategy() {
            int a = 1;
            int b = -1;
           
            @Override
            public void onTick(GameElement me) {
                // TODO Auto-generated method stub
               
                int xPosition = x.getX();
                int yPosition = x.getY();
                
                GameElement gameElementAim = x.getLevel().getElement(xPosition + a, yPosition);
                if(gameElementAim == null) {
                    x.setPostion(xPosition + a, yPosition);
                    return ;
                }else if( gameElementAim.getPermeability() == EPermeability.ALLOW_ALL && !(gameElementAim instanceof Monster)){
                    x.setPostion(xPosition + a, yPosition);
                    gameElementAim.collide(me);
                    return ;
                }
                gameElementAim = x.getLevel().getElement(xPosition + b, yPosition);
                if(gameElementAim == null) {
                    x.setPostion(xPosition + b, yPosition);
                }else if( gameElementAim.getPermeability() == EPermeability.ALLOW_ALL && !(gameElementAim instanceof Monster)){
                    x.setPostion(xPosition + b, yPosition);
                    gameElementAim.collide(me);
                }
                int c = b;
                b = a;
                a = c;
               
            }
        });
        return x;
    }
   
	/** Create the monster 'cargyv'
	 * Movement Pattern: move from top to bottom
	 * @return a GameElement
	 */
    public static GameElement createMonster2() {
        GameElement x = new Monster("cargyv");
        x.setTickManager(new OnTickStrategy() {
            int a = 1;
            int b = -1;
           
            @Override
            public void onTick(GameElement me) {
                // TODO Auto-generated method stub
               
                int xPosition = x.getX();
                int yPosition = x.getY();
               
                GameElement gameElementAim = x.getLevel().getElement(xPosition, yPosition + a);
                if(gameElementAim == null) {
                    x.setPostion(xPosition, yPosition + a);
                    return ;
                }else if( gameElementAim.getPermeability() == EPermeability.ALLOW_ALL && !(gameElementAim instanceof Monster)){
                    x.setPostion(xPosition, yPosition + a);
                    gameElementAim.collide(me);
                    return ;
                }
                gameElementAim = x.getLevel().getElement(xPosition, yPosition + b);
                if(gameElementAim == null) {
                    x.setPostion(xPosition, yPosition + b);
                }else if( gameElementAim.getPermeability() == EPermeability.ALLOW_ALL && !(gameElementAim instanceof Monster)){
                    x.setPostion(xPosition, yPosition + b);
                    gameElementAim.collide(me);
                }
                int c = b;
                b = a;
                a = c;
               
            }
        });
        return x;
    }
   
	/** Create the monster 'arrbarr'
	 * Movement Pattern: is always following the left wall
	 * @return a GameElement
	 */
    public static GameElement createMonster3() {
        GameElement x = new Monster("arrbarr");
        x.setTickManager(new OnTickStrategy() {
            int a = 1;
            int b = 0;
            @Override
            public void onTick(GameElement me) {
                // TODO Auto-generated method stub
                GameElement lcl = me.getLevel().getElement(me.getX() + a, me.getY() + b);
                if(lcl == null) {
                    me.setPostion(me.getX() + a, me.getY() + b);
                }else {
                    lcl.collide(me);
                    if(lcl.getPermeability() == EPermeability.ALLOW_ALL && !(lcl instanceof Monster)) {
                        me.setPostion(me.getX() + a, me.getY() + b);
                        lcl.collide(me);
                    }else {
                        if(a == 1) {
                            a = 0;
                            b = 1;
                        }else if(b == 1) {
                            a = -1;
                            b = 0;
                        }else if(a == -1) {
                            b = -1;
                            a = 0;
                        }else{
                            b = 0;
                            a = 1;
                        }
                    }
                }
            }      
        });
        return x;
    }
   
   
	/** Create the monster 'maarcg'
	 * Movement Pattern: don't move until a player is too close
	 * @return a GameElement
	 */
    public static GameElement createMonster4() {
    	
    	GameElement x = new Monster("maarcg");
        x.setTickManager(new OnTickStrategy() {
        	
        @Override
        public void onTick(GameElement me) {
        	
        	int difA = me.getLevel().getPlayer().getX() - me.getX();
        	// a < 0 gauche
        	// a > 0 droite
        	// b < 0 haut
        	// b > 0 bas
        	int difB = me.getLevel().getPlayer().getY() - me.getY();

        	if(Math.abs(difA) + Math.abs(difB) > 3) {
        		return;
        	}
        	
        	int a = 0;
        	int b = 0;
        	if(difA < 0 && CanIMove(me.getX() - 1, me.getY())) {
        		a = -1;
        		b = 0;
        	}else if(difA > 0 && CanIMove(me.getX() + 1, me.getY() )){
        		a = 1;
        		b = 0;
        	}else if(difB < 0 && CanIMove(me.getX(), me.getY() - 1) ) {
        		a = 0;
        		b = -1;
        	}else if(difB > 0 && CanIMove(me.getX(), me.getY() + 1)) {
        		a = 0;
        		b = 1;
        	}
        	
        	if (CanIMove(me.getX() + a, me.getY() + b)){
    			me.setPostion(me.getX() + a, me.getY() + b);
    		}else if(CanIMove(me.getX() + a, me.getY())){
    			me.setPostion(me.getX() + a, me.getY());
    		}else if(CanIMove(me.getX(), me.getY() + b)) {
    			me.setPostion(me.getX(), me.getY() + b);
    		}
        }
            	
           
            private boolean CanIMove(int xPosition, int yPosition) {
                GameElement entity = x.getLevel().getElement(xPosition, yPosition);
                if(entity == null){
                    return true;   
                }else {
                    if(entity.getPermeability() == EPermeability.ALLOW_ALL && !(entity instanceof Monster)) {
                        entity.collide(x);
                        return true;
                    }
                }
                return false;
            }
               
        });
        return x;
    }
   
	/** Create a crystall ball
	 * the door is open when all crystall ball are collected by the player
	 * @return a GameElement
	 */
    public static GameElement createCrystalBall() {
        GameElement x = new GameElement("crystalBall");
        x.setPermeability(EPermeability.ALLOW_Player);
        x.setTickManager(new OnTickStrategy() {
            @Override
            public void onTick(GameElement me) {
                // TODO Auto-generated method stub
               
            }
        });
        return x;
    }
	/** Create a closed door
	 * this door allow the player when open to get out the level
	 * @return a GameElement
	 */
    public static GameElement createClosedDoor() {
        GameElement x = new GameElement("door",1);
        x.setPermeability(EPermeability.ALLOW_Player);
        x.setColliderManager(new OnCollisionStrategy() {
           
            @Override
            public void collider(GameElement me, GameElement target) {
            	if (target instanceof Player) {
            		if (x.getState() == 1) {
            			target.kill();	
            		}else {
            			x.getLevel().IsOver(true);
            		}   
                }
            }
        });
        return x;
    }
   
	/** Create a loran
	 * Lorann is the entity controlled by the player
	 * @return a GameElement
	 */
    public static GameElement createLorann() {
        Player x = new Player("lorann");
        return (GameElement) x;
    }
   
	/** Create an opened door
	 * this door is just decoration element player can't interact with it
	 * @return a GameElement
	 */
    public static GameElement createOpenedDoor() {
        GameElement x = new GameElement("door");
        x.setPermeability(EPermeability.ALLOW_NOBODY);
        return x;
    }
   
	/** Create a purse
	 * the purse is the gold bag, the score of the player increase when the player take the bag
	 * @return a GameElement
	 */
    public static GameElement createPurse() {
        GameElement x = new GameElement("purse");
        x.setPermeability(EPermeability.ALLOW_Player);
        return x;
    }
   
	/** Create a vertical bone
	 * a vertical wall
	 * @return a GameElement
	 */
    public static GameElement createVerticalBone() {
        GameElement x = new GameElement("bone", 2);
        return x;
    }
	/** Create a vertical bone
	 * an horizontal wall
	 * @return a GameElement
	 */
    public static GameElement createHorizontalBone() {
        GameElement x = new GameElement("bone", 1);
        return x;
    }
	/** Create a bone (default wall)
	 * @return a GameElement
	 */
    public static GameElement createBone() {
        GameElement x = new GameElement("bone");
        return x;
    }
   
}