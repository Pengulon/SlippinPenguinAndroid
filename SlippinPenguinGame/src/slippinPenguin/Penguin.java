package slippinPenguin;

public class Penguin {

    final int GROUND = 382;
    
    private int centerX = 100;
    private int centerY = GROUND;
    private boolean alive = true;
    private double speed = 0;

    public void update() {
    	if(centerX <= 0) {
    		speed = 0;
    		centerX = 0;
    	}
    	else if(centerX >= 480) {
    		speed = 0;
    		centerX = 480;
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

}