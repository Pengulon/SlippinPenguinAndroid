package slippinPenguin;

import java.awt.Rectangle;

public class Tubes {
	
	private int tubex;
	private int tubey;
	private int speed = 1;
	private static int tubePass = 0;
	
	private Rectangle rleft;
	private Rectangle rright;
	
	private int recHeight = 80;
	private int recWidth = 500;
	
	public Tubes() {
		
		tubex = newInt();
		tubey = 0;
		rleft = new Rectangle(tubex, tubey, recWidth, recHeight);
		rright = new Rectangle(tubex, tubey, recWidth, recHeight);
		
	}

	public int newInt() {
		
		int randInt = 30 + (int)(Math.random()*350);
		return randInt;
		
	}
	
	public void reset() {
		
		tubex = newInt(); 
		tubey = -100;
		
	}
	
	public void update() {
		
		tubey += speed;
		rleft.setLocation(tubex - 500, tubey);
		rright.setLocation(tubex + 100, tubey);
		if(tubey >= 900 ) {
			reset();
			tubePass++;
		}
		
	}
	
	public int getTubeCenter() {
		return tubex + 50;
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

	public static int getTubePass() {
		return tubePass;
	}

	public static void setTubePass(int tubePass) {
		Tubes.tubePass = tubePass;
	}

	public int getRecHeight() {
		return recHeight;
	}
	
}
