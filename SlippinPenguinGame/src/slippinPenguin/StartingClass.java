package slippinPenguin;

import java.awt.Rectangle;

public class StartingClass {

	private Penguin penguin;
	private Tubes tube[];
	private Rectangle penguinBox = new Rectangle();

	public void init() {
	
	}
	
	public void start() {
		
		penguin = new Penguin();
		penguinBox.height = 22;
		penguinBox.width = 20;		
		
		tube = new Tubes[5];
		for(int i = 0; i < 5; i++) {
			tube[i] = new Tubes();
			tube[i].setTubey((-150)*i);
		}
		
	}
	
	public void run() {
		
	}

	public void update() {
		
		penguin.update();
		alive();
		checkCollision();
		
	}
	
	public void stop() {
		
		penguin = null;
		for(int i = 0; i < 5; i++) {
			tube[i] = null;
		}
		
	}
	
	public boolean alive() {
		if(penguin.isAlive()) {
			
			for(int i = 0; i < 5; i++) {
				tube[i].update();
			}	
			return true;
		} 
		else {
			return false;
		}
	}
    
    public void checkCollision() {
    	penguinBox.setLocation(penguin.getCenterX(), penguin.getCenterY());
    	for(int i = 0; i < 5; i++) {
    		if(penguinBox.intersects(tube[i].getRleft()) || penguinBox.intersects(tube[i].getRright())) {
    			penguin.finish();
    		}
    	}
    }

	public Penguin getPenguin() {
		return penguin;
	}

	public void setPenguin(Penguin penguin) {
		this.penguin = penguin;
	}

	public Rectangle getPenguinBox() {
		return penguinBox;
	}

	public void setPenguinBox(Rectangle penguinBox) {
		this.penguinBox = penguinBox;
	}

	public Tubes[] getTube() {
		return tube;
	}

	public void setTube(Tubes[] tube) {
		this.tube = tube;
	}
    
}