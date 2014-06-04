package com.ethanwong.slippinPenguin;

import java.awt.Rectangle;

public class Walls {
	
	private int wallx;
	private int wally;
	private int speed = 1;
	private static int wallPass = 0;
	
	private Rectangle rleft;
	private Rectangle rright;
	
	private int recHeight = 80;
	private int recWidth = 500;
	
	public Walls() {
		
		wallx = newInt();
		wally = 0;
		rleft = new Rectangle(wallx, wally, recWidth, recHeight);
		rright = new Rectangle(wallx, wally, recWidth, recHeight);
		
	}

	public int newInt() {
		
		int randInt = 30 + (int)(Math.random()*300);
		return randInt;
		
	}
	
	public void reset() {
		
		wallx = newInt(); 
		wally = -100;
		
	}
	
	public void update() {
		
		wally += speed;
		rleft.setLocation(wallx - 500, wally);
		rright.setLocation(wallx + 100, wally);
		if(wally >= 900 ) {
			reset();
		}
		else if(wally == 700) {
			wallPass++;
		}
		
	}
	
	public int getWallCenter() {
		return wallx - 400;
	}

	public void setWallx(int wallx) {
		this.wallx = wallx;
	}

	public void setWally(int wally) {
		this.wally = wally;
	}

	public int getWallx() {
		return wallx;
	}

	public int getWally() {
		return wally;
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

	public static int getwallPass() {
		return wallPass;
	}

	public static void setwallPass(int wallPass) {
		Walls.wallPass = wallPass;
	}

	public int getRecHeight() {
		return recHeight;
	}
	
}
