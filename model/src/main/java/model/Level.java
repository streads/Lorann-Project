package model;

import java.util.ArrayList;
import java.util.List;

import controller.EUserOrder;
import model.element.GameElement;
import model.element.GameElementFactory;
import model.element.special.Player;

public class Level {
	protected int id, height, width;
	protected List<GameElement> gameElements;
	protected String name;
	protected int score;
	protected EUserOrder playerAction;
	
	public Level(int id, String name, int height, int width) {
		this.name = name;
		this.height = height;
		this.width = width;
		this.id = id;
		gameElements = new ArrayList<GameElement>();
	}

	public Level(String name, int height, int width) {
		this.name = name;
		this.height = height;
		this.width = width;
		gameElements = new ArrayList<GameElement>();
	}
	
	public int getId() {
		return this.id;
	}
	public String getName() {
		return name;
	}
	public int getHeight(){
		return height; 
	}
	public int getWidth(){ 
		return width; 
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	public void setPlayerAction(EUserOrder order) {
		this.playerAction = order;
	}
	
	public EUserOrder getPlayerAction() {
		return this.playerAction;
	}
	
	public void tick() {
		for (GameElement gameElement : gameElements) {
			if (gameElement instanceof Player) {
				Player localPlayer = (Player) gameElement;
				localPlayer.executeOrder(localPlayer, this.getPlayerAction());
			}else {
				gameElement.tick();	
			}
			
		}
	}
	
	public void checkCollision() {
		for (GameElement gameElement : gameElements) {
			for (GameElement gameElement2 : gameElements) {
				if(gameElement.getX() == gameElement2.getX() && gameElement.getY() == gameElement2.getY()) {
					gameElement.collide(gameElement2);	
				}
			}
		}
	}
	
	public void removeElement(GameElement element) {
		gameElements.remove(element);
	}
	
	public GameElement getElement(int x, int y) {
		
		for (GameElement gameElement : gameElements) {
			if(gameElement.getX() == x && gameElement.getY() == y) {
				return gameElement;
			}
		}
		return null;
	}
	
	
	public void addElement(String identifier, int x, int y){
		GameElement temp = null;
		switch (identifier) {
		case "1":
			temp = GameElementFactory.createMonster1();
			break;

		default:
			break;
		}
		
		if (temp != null) {
			temp.setPostion(x, y);
		}else {
			System.err.println("Identifier not recognize");
		}

	}

}
