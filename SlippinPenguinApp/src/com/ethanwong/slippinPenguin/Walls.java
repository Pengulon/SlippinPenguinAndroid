package com.ethanwong.slippinPenguin;

import android.graphics.Rect;

public class Walls {
	
	private int wallx;
	private int wally;
	private int speed = 1;
	private static int wallPass = 0;
	
	private Rect rleft;
	private Rect rright;
	
	private int recHeight = 80;
	private int recWidth = 500;
	
	public Walls() {
		
		wallx = newInt();
		wally = 0;
		rleft = new Rect(wallx, wally, recWidth, recHeight);
		rright = new Rect(wallx, wally, recWidth, recHeight);
		
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
		rleft.set(wallx - 500, wally, wallx - 500 + recWidth, wally + recHeight);
		rright.set(wallx + 100, wally, wallx + 100 + recWidth, wally + recHeight);
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

	public Rect getRleft() {
		return rleft;
	}

	public Rect getRright() {
		return rright;
	}

	public void setRleft(Rect rleft) {
		this.rleft = rleft;
	}

	public void setRright(Rect rright) {
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
