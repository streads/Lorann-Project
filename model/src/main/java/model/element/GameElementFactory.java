package model.element;
 
import java.util.Random;
import model.element.special.Monster;
import model.element.special.Player;
 
public class GameElementFactory {
   
 
       
   
    public static GameElement createMonster1() {
        GameElement x = new Monster("kyracj");
        x.SetTickManager(new OnTickStrategy() {
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
   
   
    public static GameElement createMonster2() {
        GameElement x = new Monster("cargyv");
        x.SetTickManager(new OnTickStrategy() {
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
   
   
   
   
    public static GameElement createMonster3() {
        GameElement x = new Monster("arrbarr");
        x.SetTickManager(new OnTickStrategy() {
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
   
   
   
    public static GameElement createMonster4() {
        GameElement x = new Monster("maarcg");
        x.SetTickManager(new OnTickStrategy() {
           
            @Override
            public void onTick(GameElement me) {
                // TODO Auto-generated method stub
                int randomValue = new Random().nextInt(16);
                if (randomValue == 8 && CanIMove(x.getX() + 1, x.getY())) {
       
                    x.setPostion(x.getX() + 1, x.getY());
                   
                }else if(randomValue == 9 && CanIMove(x.getX() - 1, x.getY())){
                    x.setPostion(x.getX() - 1, x.getY());
                }else if(randomValue == 10 && CanIMove(x.getX(), x.getY() + 1)){
           
                    x.setPostion(x.getX(), x.getY() + 1);
                }else if(randomValue == 11  && CanIMove(x.getX(), x.getY() - 1)){
                   
                    x.setPostion(x.getX(), x.getY() - 1);
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
   
    public static GameElement createCrystalBall() {
        GameElement x = new GameElement("crystalBall");
        x.setPermeability(EPermeability.ALLOW_Player);
        x.SetTickManager(new OnTickStrategy() {
            @Override
            public void onTick(GameElement me) {
                // TODO Auto-generated method stub
               
            }
        });
        return x;
    }
   
    public static GameElement createClosedDoor() {
        GameElement x = new GameElement("door",1);
        x.setPermeability(EPermeability.ALLOW_Player);
        x.SetColliderManager(new OnCollisionStrategy() {
           
            @Override
            public void Collider(GameElement me, GameElement target) {
                if (target instanceof Player) {
                    target.kill();
                }
               
            }
        });
        return x;
    }
   
    public static GameElement createLorann() {
        Player x = new Player("lorann");
        return (GameElement) x;
    }
   
    public static GameElement createOpenedDoor() {
        GameElement x = new GameElement("door");
        x.setPermeability(EPermeability.ALLOW_NOBODY);
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