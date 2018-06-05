package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import controller.EUserOrder;
import model.element.GameElement;
import model.element.GameElementFactory;
import model.element.special.Player;

/**
 * <h1>The Class Level is used to store and manipulate the map information (like score and entities).</h1>
 *
 * @author Thibault HANNA thibault.hanna@viacesi.fr
 * @version 1.0
 */
public class Level {
	protected int id, height, width;
	
	protected List<GameElement> gameElements = new ArrayList<GameElement>();
	protected GameElement player = null;
	protected String name;
	protected int score = 0;
	protected boolean isOver = false;
	
	// to avoid data manipulation error when the list is traveled
	protected List<GameElement> endTickKillElements = new ArrayList<GameElement>();
	protected List<GameElement> endTickCreateElements = new ArrayList<GameElement>();
	
	/**
     * Create a level object.
     * @param id
     * 		the id of the level in the database
     * @param name	
     * 		the map name
     * @param height	
     * 		the height of the map
     * @param width
     * 		the width of the map
     */
	public Level(int id, String name, int width, int height) {
		this.name = name;
		this.height = height;
		this.width = width;
		this.id = id;
		this.isOver = false;
	}

	/**
     * Create a level object.
     * @param name	
     * 		the map name
     * @param height	
     * 		the height of the map
     * @param width
     * 		the width of the map
     */
	public Level(String name, int width, int height) {
		this.name = name;
		this.height = height;
		this.width = width;
	}
	
	/**
	 * Return the id of the level
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Return the name of the level
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Return the height of the level map
	 */
	public int getHeight(){
		return height; 
	}
	
	/**
	 * Return the width of the level map
	 */
	public int getWidth(){ 
		return width; 
	}
	
	/**
	 * Return the score of the player inside this level
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * Change the score
	 * @param score
	 * 		the new score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	
	int tickCounter = 0;
	/**
	 * Function called in a loop with a little time sleep used to move entities
	 * @param playerAction
	 * 		the action wished by the player on this tick (by default none)
	 */
	public void tick(EUserOrder playerAction) {
		try {
			for (GameElement gameElement : gameElements) {
				if (gameElement instanceof Player) {
					Player localPlayer = (Player) gameElement;	
					localPlayer.executeOrder(localPlayer, playerAction);
				}
				if (tickCounter == 8) {
					gameElement.tick();
						
				}	
			}
			
		} catch(NullPointerException ex) {/** System.out.println(ex);*/}
		
		gameElements.addAll(endTickCreateElements);
		endTickCreateElements.clear();
		
		gameElements.removeAll(endTickKillElements);
		endTickKillElements.clear();
		
		if(tickCounter == 8) {
			tickCounter = 0;
		}else {
			tickCounter += 1;
		}
		
		checkCollision();


	}
	
	/**
	 * Loop to check and trigger collide function when two entities got the same position
	 */
	public void checkCollision() {
		try {
			for (GameElement gameElement : gameElements) {
				for (GameElement gameElement2 : gameElements) {
					if(gameElement.getX() == gameElement2.getX() && gameElement.getY() == gameElement2.getY() && gameElement != gameElement2) {
						//System.out.println("collide " + gameElement.getIdentifier() + " >" + gameElement2.getIdentifier());
						gameElement.collide(gameElement2);	
					}
				}
			}
		} catch(NullPointerException ex) {}
		
	}

	/**
	 * Remove an entities from the level
	 * @param element
	 * 		the game element to remove
	 */
	public void removeElement(GameElement element)
	{
		endTickKillElements.add(element);
		if (element instanceof Player) {
			player = null;
			isOver = true;
		
		}
	}
	/**
	 * Get the GameElement on a specific position
	 * @param x
	 * @param y
	 * @return a GameElement, null if not found
	 */
	public GameElement getElement(int x, int y) {
		
		for (GameElement gameElement : gameElements) {
			if(gameElement.getX() == x && gameElement.getY() == y) {
				return gameElement;
			}
		}
		return null;
	}
	
	/**
	 * Add a GameElement inside the level
	 * @param element
	 */
	public void addElement(GameElement element) {
		element.setLevel(this);
		endTickCreateElements.add(element);
	}
	
	/**
	 * Get the lorann GameElement
	 * @return a GameElement, null if not found
	 */
	public GameElement getPlayer() {
		return this.player;	
	}
	
	/**
	 * Get the state of the level
	 * @return true if the game is over, false if not.
	 */
	public boolean IsOver() {
		return this.isOver;
	}
	
	/**
	 * Set the current state of the level
	 * @param value true if the game is over, false if not.
	 */
	public void IsOver(boolean value) {
		this.isOver = value;
	}
	
	/** Add an element in the level thanks to the:
	 * @param identifier the char used in the database to store this element
	 * @param x spawn position on the height
	 * @param y spawn position on the width
	 */
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
			player = null;
			temp = GameElementFactory.createLorann();
			player = (Player) temp;
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
