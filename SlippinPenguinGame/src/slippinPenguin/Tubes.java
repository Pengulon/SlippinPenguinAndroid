package slippinPenguin;

import java.awt.Rectangle;

public class Tubes {
	
	private int tubex;
	private int tubey;
	private int speed = 1;
	
	private Rectangle rleft;
	private Rectangle rright;
	
	private int recHeight = 50;
	private int recWidth = 500;
	
	public Tubes() {
		
		tubex = newInt();
		tubey = 0;
		rleft = new Rectangle(tubex, tubey, recWidth, recHeight);
		rright = new Rectangle(tubex, tubey, recWidth, recHeight);
		
	}

	public int newInt() {
		
		int randInt = 0 + (int)(Math.random()*400);
		return randInt;
		
	}
	
	public void reset() {
		
		tubex = newInt(); 
		tubey = 0;
		
	}
	
	public void update() {
		
		if(tubey >= 500 ) {
			reset();
		}
		tubey += speed;
		rleft.setLocation(tubex - 500, tubey);
		rright.setLocation(tubex + 100, tubey);
		
	}

	public void setTubex(int tubex) {
		this.tubex = tubex;
	}

	public void setTubey(int tubey) {
		this.tubey = tubey;
	}

	public int getTubex() {
		return tubex;
	}

	public int getTubey() {
		return tubey;
	}

	public Rectangle getRleft() {
		return rleft;
	}

	public Rectangle getRright() {
		return rright;
	}

	public void setRleft(Rectangle rleft) {
		this.rleft = rleft;
	}

	public void setRright(Rectangle rright) {
		this.rright = rright;
	}
	
}
