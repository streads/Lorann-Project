package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import controller.EUserOrder;
import model.element.GameElement;
import model.element.GameElementFactory;
import model.element.special.Player;

public class Level {
	protected int id, height, width;
	protected List<GameElement> gameElements = new ArrayList<GameElement>();
	protected GameElement lorann = null;
	protected String name;
	protected int score = 0;
	protected EUserOrder playerAction;
	
	protected List<GameElement> endTickKillElements = new ArrayList<GameElement>();
	protected List<GameElement> endTickCreateElements = new ArrayList<GameElement>();
	
	public Level(int id, String name, int height, int width) {
		this.name = name;
		this.height = height;
		this.width = width;
		this.id = id;
	}

	public Level(String name, int height, int width) {
		this.name = name;
		this.height = height;
		this.width = width;
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
	
	public void tick(EUserOrder playerDirection) {
		
		for (GameElement gameElement : gameElements) {
			if (gameElement instanceof Player) {
				Player localPlayer = (Player) gameElement;	
				localPlayer.executeOrder(localPlayer, playerDirection);
			}else {
				gameElement.tick();
			}
			
		}
		checkCollision();

		gameElements.addAll(endTickCreateElements);
		endTickCreateElements.clear();
		
		gameElements.removeAll(endTickKillElements);
		endTickKillElements.clear();
	}
	
	public void checkCollision() {
		for (GameElement gameElement : gameElements) {
			for (GameElement gameElement2 : gameElements) {
				if(gameElement.getX() == gameElement2.getX() && gameElement.getY() == gameElement2.getY() && gameElement != gameElement2) {
					//System.out.println("collide " + gameElement.getIdentifier() + " >" + gameElement2.getIdentifier());
					gameElement.collide(gameElement2);	
				}
			}
		}
	}
	
	public void removeElement(GameElement element)
	{
		System.out.println("removed " + element.getIdentifier());
		endTickKillElements.add(element);
	}
	
	public GameElement getElement(int x, int y) {
		
		for (GameElement gameElement : gameElements) {
			if(gameElement.getX() == x && gameElement.getY() == y) {
				return gameElement;
			}
		}
		return null;
	}
	
	public void addElement(GameElement element) {
		element.setLevel(this);
		endTickCreateElements.add(element);
	}
	
	public void addElement(String identifier, int x, int y){
		GameElement temp = null;
		switch (identifier) {
		case "1":
			temp = GameElementFactory.createMonster1();
			break;
		case "2":
			temp = GameElementFactory.createMonster2();
			break;
		case "3":
			temp = GameElementFactory.createMonster3();
			break;
		case "4":
			temp = GameElementFactory.createMonster4();
			break;
		case "B":
			temp = GameElementFactory.createCrystalBall();
			break;
		case "C":
			temp = GameElementFactory.createClosedDoor();
			break;
		case "L":
			lorann = null;
			temp = GameElementFactory.createLorann();
			lorann = (Player) temp;
			break;
		case "O":
			temp = GameElementFactory.createOpenedDoor();
			break;
		case "P":
			temp = GameElementFactory.createPurse();
			break;
		case "-":
			temp = GameElementFactory.createHorizontalBone();
			break;
		case "|":
			temp = GameElementFactory.createVerticalBone();
			break;	
		case "/":
			temp = GameElementFactory.createBone();
			break;
		
		default:
			break;
		}
		
		if (temp != null) {
			temp.setPostion(x, y);
			temp.setLevel(this);
			gameElements.add(temp);
			
		}else {
			System.err.println("Identifier not recognize");
		}

	}

}
