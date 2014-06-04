package com.ethanwong.slippinPenguin;

import java.io.File;
import java.io.IOException;

import com.ethanwong.framework.Graphics;
import com.ethanwong.framework.Image;

public class StartButton {

	private int x, y, width, height;
	private boolean mouseOn, mouseDown, mouseClick;

	public StartButton() {
		
		x = 120;
		y = 300;
		width = 250;
		height = 130;
		
	}
	
	public void paint(Graphics g) {
		
		if(mouseDown && mouseOn) {
			g.drawImage(Assets.startHitPic, x, y, 0, 0, width, height);
		}
		else {
			g.drawImage(Assets.startPic, x, y, 0, 0, width, height);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getX() > x && arg0.getY() > y && arg0.getX() < (x + width) && arg0.getY() < (y + height)) {
			mouseClick = true;
			mouseOn = true;
		}
		else {
			mouseClick = false;
			mouseOn = false;
		}	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getX() > x && arg0.getY() > y && arg0.getX() < (x + width) && arg0.getY() < (y + height)) {
			mouseDown = true;
			mouseOn = true;
		}
		else {
			mouseDown = false;
			mouseOn = false;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getX() > x && arg0.getY() > y && arg0.getX() < (x + width) && arg0.getY() < (y + height)) {
			mouseDown = true;
		}
		else {
			mouseDown = false;
		}
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

	public boolean isMouseOn() {
		return mouseOn;
	}

	public boolean isMouseDown() {
		return mouseDown;
	}

	public void setMouseOn(boolean mouseOn) {
		this.mouseOn = mouseOn;
	}

	public void setMouseDown(boolean mouseDown) {
		this.mouseDown = mouseDown;
	}

	public boolean isMouseClick() {
		return mouseClick;
	}

	public void setMouseClick(boolean mouseClick) {
		this.mouseClick = mouseClick;
	}

}
