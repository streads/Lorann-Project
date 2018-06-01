package model.element;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import model.Level;

public class GameElement {
	protected int state = 1;
	protected String identifier;
	protected EPermeability permeability = EPermeability.ALLOW_NOBODY;
	protected Level level;
	protected int x, y; 
	protected List<Image> sprites = null;
	protected OnCollisionStrategy colliderManager = null;
	protected OnTickStrategy tickManager = null;
	
	public GameElement(char identifier) {
		
	}
	
	public GameElement(String identifier ,List<Image> sprites) {
		this.sprites = sprites;
	}
	
	public GameElement(String identifier, Image sprite) {
		this.sprites = new ArrayList<Image>();
		this.sprites.add(sprite);
	}
	
	public void SetColliderManager(OnCollisionStrategy colliderManager) {
		this.colliderManager = colliderManager;
	}
	
	public void SetTickManager(OnTickStrategy tickManager) {
		this.tickManager = tickManager;
	}
	
	public void tick() {
		if (tickManager != null) {
			tickManager.onTick(this);	
		}else {
			System.err.println("no tick stategy on this object");
		}
	}
	
	public void collide(GameElement target) {
		if (colliderManager != null) {
			colliderManager.Collider(this, target);	
		}else {
			System.err.println("no collision strategy for this object");
		}
	}
	
	public void kill() {
		this.getLevel().removeElement(this);
	};
	
	public void setState(int state) {
		this.state = state;
	}
	public int getState() {
		return this.state;
	}
	
	public Image getImage() {
		if (state >= this.sprites.size()) {
			return this.sprites.get(0);
		}else {
			return this.sprites.get(state);
		}
	}
	
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setPostion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public String getIdentifier() {
		return this.identifier;
	}
}

