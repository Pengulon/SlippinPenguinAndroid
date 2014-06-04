package com.ethanwong.slippinPenguin;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RestartMenu implements MouseListener{

	private int x,y, width, height, buttonX, buttonY, buttonWidth, buttonHeight;
	private boolean mouseOn, mouseDown, mouseClick;
	private Image restartMenu, restartMenuHit;
	
	private String readLine;
	private String highScoreFile = "data/highScore.xml";
	private int highScore;
	
	public RestartMenu() {
		
		mouseOn = mouseDown = mouseClick = false;
		x = 100;
		y = 200;
		width = 300;
		height = 400;
		buttonX = x + 50;
		buttonY = y + 280;
		buttonWidth = 200;
		buttonHeight = 70;
		
		try {
			restartMenu = ImageIO.read(new File("data/restartMenu.png"));
			restartMenuHit = ImageIO.read(new File("data/restartMenuHit.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			readFile(highScoreFile);
			Integer.parseInt(readLine);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			writeFile(highScoreFile, 0);
		}
		
		
	}
	
	public void paint(Graphics g, ImageObserver io) {
		
		if(mouseOn && mouseDown) {
			g.drawImage(restartMenuHit, x, y, width, height, io);
		}
		else {
			g.drawImage(restartMenu, x, y, width, height, io);			
		}
		g.drawRect(buttonX, buttonY, buttonWidth, buttonHeight);
		
	}
	
	public void saveScore(int score) {
		
		readFile(highScoreFile);
		setHighScore(Integer.parseInt(readLine));
		if(score >= getHighScore()) {
			setHighScore(score);
			writeFile(highScoreFile, getHighScore());
		}
				
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX() > buttonX && e.getY() > buttonY && e.getX() < (buttonX + buttonWidth) && e.getY() < (buttonY + buttonHeight)) {
			mouseClick = true;
			mouseOn = true;
		}
		else {
			mouseClick = false;
			mouseOn = false;
		}	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX() > buttonX && e.getY() > buttonY && e.getX() < (buttonX + buttonWidth) && e.getY() < (buttonY + buttonHeight)) {
			mouseDown = true;
			mouseOn = true;
		}
		else {
			mouseDown = false;
			mouseOn = false;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX() > buttonX && e.getY() > buttonY && e.getX() < (buttonX + buttonWidth) && e.getY() < (buttonY + buttonHeight)) {
			mouseDown = true;
		}
		else {
			mouseDown = false;
		}		
	}

	public boolean isMouseOn() {
		return mouseOn;
	}

	public boolean isMouseDown() {
		return mouseDown;
	}

	public boolean isMouseClick() {
		return mouseClick;
	}

	public void setMouseOn(boolean mouseOn) {
		this.mouseOn = mouseOn;
	}

	public void setMouseDown(boolean mouseDown) {
		this.mouseDown = mouseDown;
	}

	public void setMouseClick(boolean mouseClick) {
		this.mouseClick = mouseClick;
	}
	
	private void writeFile(String filePath, int i) {
		File out;
		BufferedWriter outWriter;		
		
		try {
			
			out = new File(filePath);
			outWriter = new BufferedWriter(new FileWriter(out));
			outWriter.write(String.valueOf(i));
			outWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void readFile(String filePath) {
		File in;
		BufferedReader inWriter;		
		
		try {
			
			in = new File(filePath);
			inWriter = new BufferedReader(new FileReader(in));
			readLine = inWriter.readLine();
			inWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getButtonWidth() {
		return buttonWidth;
	}

	public int getButtonHeight() {
		return buttonHeight;
	}

	public void setButtonWidth(int buttonWidth) {
		this.buttonWidth = buttonWidth;
	}

	public void setButtonHeight(int buttonHeight) {
		this.buttonHeight = buttonHeight;
	}

	public int getButtonX() {
		return buttonX;
	}

	public int getButtonY() {
		return buttonY;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}	

}
