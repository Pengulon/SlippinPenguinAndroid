package slippinPenguin;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


public class MainMenu extends Applet implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6751322658627545895L;
	private StartingClass sc;
	private Image image, currentSprite, character, character2, characterHurt, background, WallPic, startPic, startHitPic;
	private Graphics second;
	private URL base;
	private static Background bg1;
	private boolean inMenu;
	private boolean inGame;
	private Thread thread;
	private int frameCounter = 0;
	private StartButton startButton;

	@Override
	public void init() {

		setSize(480, 800);
		setBackground(Color.BLACK);
		setFocusable(true);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Slippin Penguin");
		try {
			base = getDocumentBase();
		} catch (Exception e) {
			// TODO: handle exception
		}

		// Image Setups
		character = getImage(base, "data/penguin1.png");
		character2 = getImage(base, "data/penguin2.png");
		characterHurt = getImage(base, "data/penguinDead.png");
		currentSprite = character;
		background = getImage(base, "data/background.png");
		WallPic = getImage(base, "data/ice wall.png");
		try {
			startPic = ImageIO.read(new File("data/startbutton.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startHitPic = getImage(base, "data/startbuttonhit.png");
		
		inMenu = true;
		inGame = false;
		
	}

	@Override
	public void start() {
		
		bg1 = new Background(0, 0);
		
		sc = new StartingClass();
		sc.start();
		
		startButton = new StartButton(240, 600, startPic.getWidth(this), startPic.getHeight(this));
		addMouseListener(startButton);
		
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while (true) {
			
			if(inMenu) {
				
				if(startButton.isMouseClick()) {
					inMenu = false;
					inGame = true;
					System.out.print("Gemu Hajimeru");
					addKeyListener(sc);
					setFocusable(true);
					this.requestFocusInWindow();
					startButton.setMouseClick(false);
				}
				
			}
			else if(inGame) {
				
				++frameCounter;
				sc.update();
				
				if(!sc.getPenguin().isAlive()){
					currentSprite = characterHurt;
				}
				
				if(frameCounter == 30) {
					currentSprite = character2;
				}
				else if(frameCounter >= 60) {
					currentSprite = character;
					frameCounter = 0;
				}
				
			}
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void stop() {
		
		bg1 = null;
		sc.stop();
		sc = null;
		startButton = null;
		
		thread.interrupt();
		thread = null;
		
	}

	@Override
	public void destroy() {
		
	}
	
	@Override
	public void update(Graphics g) {
		
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}
		
		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);

	}

	@Override
	public void paint(Graphics g) {
		
		g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);

		if(inGame) {
			gamePaint(g);
		}
			
		else if(inMenu) {
			
			if(startButton.isMouseDown()) {
				g.drawImage(startHitPic, startButton.getX(), startButton.getY(), startButton.getWidth(), startButton.getHeight(), this);
			}
			else {
				g.drawImage(startPic, startButton.getX(), startButton.getY(), startButton.getWidth(), startButton.getHeight(), this);
			}
		}
		
	}
	
	public void gamePaint(Graphics g) {
		
		g.drawImage(currentSprite, sc.getPenguin().getCenterX(), sc.getPenguin().getCenterY(), this);
		
		for(int i = 0; i < sc.getWall().length; i++) {
			
			g.drawImage(WallPic, sc.getWall()[i].getWallCenter(), sc.getWall()[i].getWally(), this);
			//g.drawRect(sc.getWall()[i].getRleft().x, sc.getWall()[i].getRleft().y, sc.getWall()[i].getRleft().width, sc.getWall()[i].getRleft().height);
			//g.drawRect(sc.getWall()[i].getRright().x, sc.getWall()[i].getRright().y, sc.getWall()[i].getRright().width, sc.getWall()[i].getRright().height);
			
			//g.drawRect(sc.getPenguinBox().x, sc.getPenguinBox().y, sc.getPenguinBox().width, sc.getPenguinBox().height);

		}
		
		if(!sc.getPenguin().isAlive()) {
			restartGame();
		}
		
	}
	
	public void restartGame() {
		sc.stop();
		sc.start();
	}

}
