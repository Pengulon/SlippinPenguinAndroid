package com.ethanwong.slippinPenguin;

import java.io.File;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;

import com.ethanwong.framework.Graphics;
import com.ethanwong.framework.Image;

public class GameScore {

	private Bitmap scoreNums[];
	private double score;
	private int pixelWidth = 50;
	private int pixelHeight = 130;
	private int x, y;
	
	public GameScore() {
		
		score = 0;
		x = 215;
		y = 50;
		scoreNums = new Bitmap[10];

	}
	
	public void update() {
		
		score = Walls.getwallPass();
	}
	
	public void paint(Graphics g, int xMove, int yMove) {
		
		xMove += x;
		yMove += y;
		
		if(score >= 100) {
			
			int hundreth = (int) score/100;
			int tenth = (int) (score - hundreth*100)/10;
			int oneth = (int) score-(hundreth*100)-(tenth*10);
			g.drawImage(scoreNums[oneth], xMove + 50, yMove, 0, 0, pixelWidth, pixelHeight);
			g.drawImage(scoreNums[tenth], xMove, yMove, 0, 0, pixelWidth, pixelHeight);
			g.drawImage(scoreNums[hundreth], xMove - 50, yMove, 0, 0, pixelWidth, pixelHeight);

		}
		else if(score >= 10) {
			int tenth = (int) score/10;
			System.out.print(tenth);
			g.drawImage(scoreNums[(int) (score-(tenth*10))], xMove + 25, yMove, 0, 0, pixelWidth, pixelHeight);
			g.drawImage(scoreNums[tenth], xMove - 25, yMove, 0, 0, pixelWidth, pixelHeight);
		}
		else if(score >= 0) {
			g.drawImage(scoreNums[(int) score], xMove, yMove, 0, 0, pixelWidth, pixelHeight); 
		}
		else {
			g.drawImage(scoreNums[7], xMove + 50, yMove, 0, 0, pixelWidth, pixelHeight);
			g.drawImage(scoreNums[3], xMove, yMove, 0, 0, pixelWidth, pixelHeight);
			g.drawImage(scoreNums[3], xMove - 50, yMove, 0, 0, pixelWidth, pixelHeight);
			g.drawImage(scoreNums[1], xMove - 100, yMove, 0, 0, pixelWidth, pixelHeight);
		}
		
	}
	
	public void paint(Graphics g, int xMove, int yMove, int score) {
		
		xMove += x;
		yMove += y;
		
		if(score >= 100) {
			
			int hundreth = score/100;
			int tenth = (score - hundreth*100)/10;
			int oneth = score-(hundreth*100)-(tenth*10);
			g.drawImage(scoreNums[oneth], xMove + 50, yMove, 0, 0, pixelWidth, pixelHeight);
			g.drawImage(scoreNums[tenth], xMove, yMove, 0, 0, pixelWidth, pixelHeight);
			g.drawImage(scoreNums[hundreth], xMove - 50, yMove, 0, 0, pixelWidth, pixelHeight);

		}
		else if(score >= 10) {
			int tenth = score/10;
			System.out.print(tenth);
			g.drawImage(scoreNums[(score-(tenth*10))], xMove + 25, yMove, 0, 0, pixelWidth, pixelHeight);
			g.drawImage(scoreNums[tenth], xMove - 25, yMove, 0, 0, pixelWidth, pixelHeight);
		}
		else if(score >= 0) {
			g.drawImage(scoreNums[score], xMove, yMove, 0, 0, pixelWidth, pixelHeight); 
		}
		else {
			g.drawImage(scoreNums[7], xMove + 50, yMove, 0, 0, pixelWidth, pixelHeight);
			g.drawImage(scoreNums[3], xMove, yMove, 0, 0, pixelWidth, pixelHeight);
			g.drawImage(scoreNums[3], xMove - 50, yMove, 0, 0, pixelWidth, pixelHeight);
			g.drawImage(scoreNums[1], xMove - 100, yMove, 0, 0, pixelWidth, pixelHeight);
		}
		
	}
	
	public void stop() {
		scoreNums = null;
	}
	
	

}
