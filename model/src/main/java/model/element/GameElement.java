package model.element;

import model.Level;

public class GameElement {
	protected int state = 0;
	protected String identifier;
	protected EPermeability permeability = EPermeability.ALLOW_NOBODY;
	protected Level level;
	protected int x, y; 
	protected OnCollisionStrategy colliderManager = null;
	protected OnTickStrategy tickManager = null;
	
	
	public GameElement(String identifier) {
		this.identifier = identifier;
	}
	
	public GameElement(String identifier, int state) {
		this.identifier = identifier;
		this.state = state;
	}
	
	public void setColliderManager(OnCollisionStrategy colliderManager) {
		this.colliderManager = colliderManager;
	}
	
	public void setTickManager(OnTickStrategy tickManager) {
		this.tickManager = tickManager;
	}
	
	public void tick() {
		if (tickManager != null) {
			tickManager.onTick(this);	
		}else {
			//System.err.println("no tick stategy on this object");
		}
	}
	
	public void collide(GameElement target) {
		if (colliderManager != null) {
			colliderManager.collider(this, target);	
		}else {
			//System.err.println("no collision strategy for this object");
		}
	}
	
	public void kill() {
		this.setPostion(-1, -1);
		if (this.getLevel() != null) {
			this.getLevel().removeElement(this);	
		}
		this.setLevel(null);
	};
	
	public void setState(int state) {
		this.state = state;
	}
	public int getState() {
		return this.state;
	}
	public void setPermeability(EPermeability perm) {
		this.permeability = perm;
	}
	
	public EPermeability getPermeability() {
		return this.permeability;
	}
	
	public String getTag() {
		return identifier + "_" + state;
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

