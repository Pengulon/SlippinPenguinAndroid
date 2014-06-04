package com.ethanwong.slippinPenguin;

public class Penguin {

    final int GROUND = 650;
    
    private int centerX = 200;
    private int centerY = GROUND;
    private boolean alive = true;
    private double speed = 0;
    private int x, y, width, height;
    
    public Penguin() {
    	
    	x = 0;
    	y = 0;
    	width = 42;
    	height = 42;
    	
    }

    public void update() {
    	
    	if(centerX < 10) {
    		speed = 0;
    		centerX = 10;
    	}
    	else if(centerX > 430) {
    		speed = 0;
    		centerX = 430;
    	}
    	else {
    		centerX += speed;
    	}
    	
    }

    public void finish() {
        alive = false;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public boolean isAlive() {
        return alive;
    }
    
    public void setAlive(boolean alive) {
    	this.alive = alive;
    }

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}      

}