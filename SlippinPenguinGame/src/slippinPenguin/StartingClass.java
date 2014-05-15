package slippinPenguin;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;

public class StartingClass extends Applet implements Runnable {

	private static final long serialVersionUID = 6751322658627545895L;
	private Penguin penguin;
	private Tubes tube[];
	private Image image, currentSprite, character, characterHurt, background, tubePic;
	private Graphics second;
	private URL base;
	private static Background bg1;
	private Rectangle penguinBox = new Rectangle();
	Thread thread;

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

	}

	@Override
	public void start() {
		penguin = new Penguin();
		penguinBox.height = 22;
		penguinBox.width = 20;
		
		bg1 = new Background(0, 0);
		
		tube = new Tubes[5];
		for(int i = 0; i < 5; i++) {
			tube[i] = new Tubes();
			tube[i].setTubey((-150)*i);
		}
		
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void destroy() {
		for(int i = 0; i < 5; i++) {
			tube[i] = null;
		}
		penguin = null;
		bg1 = null;
		thread.stop();
	}

	@Override
	public void run() {
		while (true) {
			penguin.update();
			bg1.update();
			alive();
			checkCollision();
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
		g.drawImage(currentSprite, penguin.getCenterX(), penguin.getCenterY(), this);
		
		for(int i = 0; i < 5; i++) {
			g.drawImage(tubePic, tube[i].getTubex(), tube[i].getTubey(), this);
			g.drawRect(tube[i].getRleft().x, tube[i].getRleft().y, tube[i].getRleft().width, tube[i].getRleft().height);
			g.drawRect(tube[i].getRright().x, tube[i].getRright().y, tube[i].getRright().width, tube[i].getRright().height);
		}
		
		g.drawRect(penguinBox.x, penguinBox.y, penguinBox.width, penguinBox.height);
	}
	
	public static Background getBg1() {
        return bg1;
    }
	
	public void alive() {
		if(penguin.isAlive()) {
			currentSprite = character;
			for(int i = 0; i < 5; i++) {
				tube[i].update();
			}	
		} 
		else {
			currentSprite = characterHurt;
		}
	}
    
    public void checkCollision() {
    	penguinBox.setLocation(penguin.getCenterX(), penguin.getCenterY());
    	for(int i = 0; i < 5; i++) {
    		if(penguinBox.intersects(tube[i].getRleft()) || penguinBox.intersects(tube[i].getRright())) {
    			penguin.finish();
    		}
    	}
    }

}