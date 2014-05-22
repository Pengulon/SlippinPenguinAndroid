package slippinPenguin;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.net.URL;


public class MainMenu extends Applet implements Runnable, MouseListener, ActionListener, KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6751322658627545895L;
	private StartingClass sc;
	private Image image, currentSprite, character, character2, characterHurt, background, tubePic;
	private Graphics second;
	private URL base;
	private static Background bg1;
	private ImageObserver observer;
	private boolean inMenu;
	private boolean inGame;
	private Button startButton;
	private Thread thread;
	private int frameCounter = 0;

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
		tubePic = getImage(base, "data/ice.png");
		
		inMenu = true;
		inGame = false;
		
		addMouseListener(this);
		
	}

	@Override
	public void start() {
		
		bg1 = new Background(0, 0);
		
		sc = new StartingClass();
		sc.start();
		
		startButton = new Button();
		startButton.addActionListener(this);
		
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while (true) {
			
			bg1.update();
			if(inMenu) {
				
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
		removeKeyListener(this);
		removeMouseListener(this);
		
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
			
			
			
		}
		
		
	}
	
	public void gamePaint(Graphics g) {
		
		g.drawImage(currentSprite, sc.getPenguin().getCenterX(), sc.getPenguin().getCenterY(), this);
		
		for(int i = 0; i < sc.getTube().length; i++) {
			
			int tubeH = tubePic.getHeight(observer)/2;
			int tubeW = tubePic.getWidth(observer)/2;
			
			g.drawImage(tubePic, sc.getTube()[i].getTubeCenter() - tubeW, sc.getTube()[i].getTubey() - tubeH + (sc.getTube()[i].getRecHeight()/2), this);
			g.drawRect(sc.getTube()[i].getRleft().x, sc.getTube()[i].getRleft().y, sc.getTube()[i].getRleft().width, sc.getTube()[i].getRleft().height);
			g.drawRect(sc.getTube()[i].getRright().x, sc.getTube()[i].getRright().y, sc.getTube()[i].getRright().width, sc.getTube()[i].getRright().height);
			
			g.drawRect(sc.getPenguinBox().x, sc.getPenguinBox().y, sc.getPenguinBox().width, sc.getPenguinBox().height);

		}
		
		if(!sc.getPenguin().isAlive()) {
			restartGame();
		}
		
	}
	
	public void restartGame() {
		sc.stop();
		sc.start();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
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
		
		if(!inGame) {
			inGame = true;
			inMenu = false;
			System.out.print("Gemu hajimeru");
			addKeyListener(this);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		if(sc.getPenguin().isAlive() && inGame) {
			
			if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				sc.getPenguin().setSpeed(sc.getPenguin().getSpeed() - 1);
			}
			else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
				sc.getPenguin().setSpeed(sc.getPenguin().getSpeed() + 1);
			}
			
			else if(arg0.getKeyCode() == KeyEvent.VK_KP_UP) {
				
			}
			
			else if(arg0.getKeyCode() == KeyEvent.VK_KP_DOWN) {
				
			}
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


}
