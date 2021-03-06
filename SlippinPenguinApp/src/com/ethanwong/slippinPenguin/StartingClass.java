package com.ethanwong.slippinPenguin;

import android.graphics.Rect;

public class StartingClass {

	private Penguin penguin;
	private Walls wall[];
	private Rect penguinBox = new Rect();
	private boolean inRestart = false;
	
	public void start() {
		
		penguin = new Penguin();
		penguinBox.set(0, 0, 40, 40);
		
		wall = new Walls[5];
		for(int i = 0; i < wall.length; i++) {
			wall[i] = new Walls();
			wall[i].setWally((-200)*i);
		}
		
	}

	public void update() {
		
		penguin.update();
		alive();
		checkCollision();
		
	}
	
	public void stop() {
		
		penguin = null;
		for(int i = 0; i < wall.length; i++) {
			wall[i] = null;
		}
		inRestart = false;
		Walls.setwallPass(0);
		
	}
	
	public boolean alive() {
		if(penguin.isAlive()) {
			
			for(int i = 0; i < wall.length; i++) {
				wall[i].update();
			}	
			return true;
			
		} 
		else {
			return false;
		}
	}
    
    public void checkCollision() {
    	penguinBox.set(penguin.getX(), penguin.getY(), penguin.getWidth() + penguin.getX(), penguin.getHeight() + penguin.getY());
    	for(int i = 0; i < wall.length; i++) {
    		if(penguinBox.intersect(wall[i].getRleft()) || penguinBox.intersect(wall[i].getRright())) {
    			penguin.finish();
    			inRestart = true;
    		}
    	}
    }

	public Penguin getPenguin() {
		return penguin;
	}

	public Rect getPenguinBox() {
		return penguinBox;
	}

	public void setPenguinBox(Rect penguinBox) {
		this.penguinBox = penguinBox;
	}

	public Walls[] getWall() {
		return wall;
	}

	public void setWall(Walls[] wall) {
		this.wall = wall;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(penguin.isAlive()) {
			
			if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				penguin.setSpeed(penguin.getSpeed() - 1);
			}
			else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
				penguin.setSpeed(penguin.getSpeed() + 1);
			}
			
			else if(arg0.getKeyCode() == KeyEvent.VK_KP_UP) {
				
			}
			
			else if(arg0.getKeyCode() == KeyEvent.VK_KP_DOWN) {
				
			}
			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	public boolean isInRestart() {
		return inRestart;
	}

	public void setInRestart(boolean inRestart) {
		this.inRestart = inRestart;
	}
    
}