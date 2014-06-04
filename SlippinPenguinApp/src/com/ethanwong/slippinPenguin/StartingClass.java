package com.ethanwong.slippinPenguin;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartingClass implements KeyListener{

	private Penguin penguin;
	private Walls wall[];
	private Rectangle penguinBox = new Rectangle();
	private boolean inRestart = false;
	
	public void start() {
		
		penguin = new Penguin();
		penguinBox.height = 42;
		penguinBox.width = 40;		
		
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
    	penguinBox.setLocation(penguin.getCenterX(), penguin.getCenterY());
    	for(int i = 0; i < wall.length; i++) {
    		if(penguinBox.intersects(wall[i].getRleft()) || penguinBox.intersects(wall[i].getRright())) {
    			penguin.finish();
    			inRestart = true;
    		}
    	}
    }

	public Penguin getPenguin() {
		return penguin;
	}

	public Rectangle getPenguinBox() {
		return penguinBox;
	}

	public void setPenguinBox(Rectangle penguinBox) {
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