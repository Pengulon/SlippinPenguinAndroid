package slippinPenguin;

public class Penguin {

    final int GROUND = 650;
    
    private int centerX = 200;
    private int centerY = GROUND;
    private boolean alive = true;
    private double speed = 0;

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

}