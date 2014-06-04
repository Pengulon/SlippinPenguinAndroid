package com.ethanwong.slippinPenguin;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameScore {

	private BufferedImage scorePic;
	private Image scoreNums[];
	private double score;
	private int pixelWidth = 50;
	private int pixelHeight = 130;
	private int x, y;
	
	public GameScore() {
		
		score = 0;
		x = 215;
		y = 50;
		scoreNums = new Image[10];
		try {
			scorePic = ImageIO.read(new File("data/iceNumbers.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < 10; i++) {
			scoreNums[i] = scorePic.getSubimage(i*pixelWidth, 0, pixelWidth, pixelHeight);
		}

	}
	
	public void update() {
		
		score = Walls.getwallPass();
	}
	
	public void paint(Graphics g, int xMove, int yMove, ImageObserver io) {
		
		xMove += x;
		yMove += y;
		
		if(score >= 100) {
			
			int hundreth = (int) score/100;
			int tenth = (int) (score - hundreth*100)/10;
			int oneth = (int) score-(hundreth*100)-(tenth*10);
			g.drawImage(scoreNums[oneth], xMove + 50, yMove, pixelWidth, pixelHeight, io);
			g.drawImage(scoreNums[tenth], xMove, yMove, pixelWidth, pixelHeight, io);
			g.drawImage(scoreNums[hundreth], xMove - 50, yMove, pixelWidth, pixelHeight, io);

		}
		else if(score >= 10) {
			int tenth = (int) score/10;
			System.out.print(tenth);
			g.drawImage(scoreNums[(int) (score-(tenth*10))], xMove + 25, yMove, pixelWidth, pixelHeight, io);
			g.drawImage(scoreNums[tenth], xMove - 25, yMove, pixelWidth, pixelHeight, io);
		}
		else if(score >= 0) {
			g.drawImage(scoreNums[(int) score], xMove, yMove, pixelWidth, pixelHeight, io); 
		}
		else {
			g.drawImage(scoreNums[7], xMove + 50, yMove, pixelWidth, pixelHeight, io);
			g.drawImage(scoreNums[3], xMove, yMove, pixelWidth, pixelHeight, io);
			g.drawImage(scoreNums[3], xMove - 50, yMove, pixelWidth, pixelHeight, io);
			g.drawImage(scoreNums[1], xMove - 100, yMove, pixelWidth, pixelHeight, io);
		}
		
	}
	
	public void paint(Graphics g, int xMove, int yMove, int score, ImageObserver io) {
		
		xMove += x;
		yMove += y;
		
		if(score >= 100) {
			
			int hundreth = score/100;
			int tenth = (score - hundreth*100)/10;
			int oneth = score-(hundreth*100)-(tenth*10);
			g.drawImage(scoreNums[oneth], xMove + 50, yMove, pixelWidth, pixelHeight, io);
			g.drawImage(scoreNums[tenth], xMove, yMove, pixelWidth, pixelHeight, io);
			g.drawImage(scoreNums[hundreth], xMove - 50, yMove, pixelWidth, pixelHeight, io);

		}
		else if(score >= 10) {
			int tenth = score/10;
			System.out.print(tenth);
			g.drawImage(scoreNums[(score-(tenth*10))], xMove + 25, yMove, pixelWidth, pixelHeight, io);
			g.drawImage(scoreNums[tenth], xMove - 25, yMove, pixelWidth, pixelHeight, io);
		}
		else if(score >= 0) {
			g.drawImage(scoreNums[score], xMove, yMove, pixelWidth, pixelHeight, io); 
		}
		else {
			g.drawImage(scoreNums[7], xMove + 50, yMove, pixelWidth, pixelHeight, io);
			g.drawImage(scoreNums[3], xMove, yMove, pixelWidth, pixelHeight, io);
			g.drawImage(scoreNums[3], xMove - 50, yMove, pixelWidth, pixelHeight, io);
			g.drawImage(scoreNums[1], xMove - 100, yMove, pixelWidth, pixelHeight, io);
		}
		
	}
	
	public void stop() {
		scoreNums = null;
	}
	
	

}
