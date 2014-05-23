package slippinPenguin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartButton implements MouseListener {

	private int x, y, width, height;
	private boolean mouseOn, mouseDown, mouseClick;
	
	public StartButton() {
		x = y = width = height = -1;
	}

	public StartButton(int x, int y, int width, int height) {
		super();
		this.x = x - width/2;
		this.y = y - height/2;
		this.width = width;
		this.height = height;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mouseClick = true;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mouseOn = true;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mouseOn = false;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mouseDown = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mouseDown = false;
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
