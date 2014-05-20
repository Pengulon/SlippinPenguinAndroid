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
	private Image image, currentSprite, character, characterHurt, background, tubePic;
	private Graphics second;
	private URL base;
	private static Background bg1;
	private ImageObserver observer;
	private boolean inMenu = true;
	private boolean inGame = false;
	private Button startButton;

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
		characterHurt = getImage(base, "data/penguinDead.png");
		currentSprite = character;
		background = getImage(base, "data/background.png");
		tubePic = getImage(base, "data/ice.png");
		
		addMouseListener(this);
		addKeyListener(this);
		
	}

	@Override
	public void start() {
		
		bg1 = new Background(0, 0);
		
		sc = new StartingClass();
		sc.start();
		
		startButton = new Button();
		startButton.addActionListener(this);
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while (true) {
			bg1.update();
			if(inMenu) {
				
			}
			else if(inGame) {
				
				sc.update();
				
				if(sc.getPenguin().isAlive()) {
					currentSprite = character;
				}
				else {
					currentSprite = characterHurt;
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
		
		
	}

	@Override
	public void destroy() {
		
		bg1 = null;
		sc = null;
		startButton = null;
		
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
			
			g.drawImage(currentSprite, sc.getPenguin().getCenterX(), sc.getPenguin().getCenterY(), this);
			
			for(int i = 0; i < 5; i++) {
				
				int tubeH = tubePic.getHeight(observer)/2;
				int tubeW = tubePic.getWidth(observer)/2;
				
				g.drawImage(tubePic, sc.getTube()[i].getTubeCenter() - tubeW, sc.getTube()[i].getTubey() - tubeH + 25, this);
				g.drawRect(sc.getTube()[i].getRleft().x, sc.getTube()[i].getRleft().y, sc.getTube()[i].getRleft().width, sc.getTube()[i].getRleft().height);
				g.drawRect(sc.getTube()[i].getRright().x, sc.getTube()[i].getRright().y, sc.getTube()[i].getRright().width, sc.getTube()[i].getRright().height);
				
				g.drawRect(sc.getPenguinBox().x, sc.getPenguinBox().y, sc.getPenguinBox().width, sc.getPenguinBox().height);

			}
		}
			
		else if(inMenu) {
			
			g.drawImage(character, 100, 100, this);
			
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
		// TODO Auto-generated method stub
		inGame = true;
		inMenu = false;
		System.out.print("Gemu hajimeru");
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.print("Gemu hajimeru");
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(sc.getPenguin().isAlive()) {
			
			if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				sc.getPenguin().setCenterX(sc.getPenguin().getCenterX()-15);
				System.out.print("Left");
			}
			else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
				sc.getPenguin().setCenterX(sc.getPenguin().getCenterX()+15);
			}
			
			else if(arg0.getKeyCode() == KeyEvent.VK_KP_UP) {
				
			}
			
			else if(arg0.getKeyCode() == KeyEvent.VK_KP_DOWN) {
				
			}
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


}
