package com.ethanwong.slippinPenguin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.util.Log;

import com.ethanwong.framework.Graphics;
import com.ethanwong.framework.Screen;
import com.ethanwong.framework.implementation.AndroidGame;
import com.ethanwong.slippinpenguinapp.R;

public class PenguinGame extends AndroidGame implements Runnable {

	private StartingClass sc;
	private RestartMenu rMenu;
	private GameScore scores;
	private static Background bg1;
	private boolean inMenu, inGame, inRestart;
	private Thread thread;
	private int frameCounter = 0;
	private int highScore;
	private StartButton startButton;
	
	public static String map;
	boolean firstTimeCreate = true;

	@Override
	public Screen getInitScreen() {
		// TODO Auto-generated method stub
		if (firstTimeCreate) {
            Assets.load(this);
            firstTimeCreate = false;
        }

        InputStream is = getResources().openRawResource(R.raw.map1);
        map = convertStreamToString(is);

        return new SplashLoadingScreen(this);

	}
	
	@Override
    public void onBackPressed() {
        getCurrentScreen().backButton();
    }
	
	private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append((line + "\n"));
            }
        } catch (IOException e) {
            Log.w("LOG", e.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                Log.w("LOG", e.getMessage());
            }
        }
        return sb.toString();
    }
	
	@Override
    public void onResume() {
        super.onResume();
        Assets.theme.play();
        
    }

    @Override
    public void onPause() {
        super.onPause();
        Assets.theme.pause();

    }
	
	public void init() {
		
		inMenu = true;
		inGame = false;
		
	}

	public void start() {
		
		bg1 = new Background(0, 0);
		
		sc = new StartingClass();
		sc.start();
		sc.getPenguin().setAlive(true);
		
		startButton = new StartButton();
		addMouseListener(startButton);
		
		scores = new GameScore();
		
		thread = new Thread(this);
		thread.start();
		
	}
	
	@Override
	public void run() {
		while (true) {
			
			if(inMenu) {
				
				if(startButton.isMouseClick()) {
					removeMouseListener(startButton);
					inMenu = false;
					inGame = true;
					System.out.print("Gemu Hajimeru");
					addKeyListener(sc);
					startButton.setMouseClick(false);
				}
				
			}
			else if(inGame && !inRestart) {
				
				sc.update();
				scores.update();
				
				
				if(sc.isInRestart()){ // This is called when the penguin has died.
					Assets.currentSprite = Assets.characterHurt;
					rMenu = new RestartMenu();
					addMouseListener(rMenu);
					removeKeyListener(sc);
					inRestart = true;
					rMenu.saveScore(Walls.getwallPass());
					highScore = rMenu.getHighScore();
				}
				else {
					
					++frameCounter;
					if(frameCounter == 30) {
						Assets.currentSprite = Assets.character2;
					}
					else if(frameCounter >= 60) {
						Assets.currentSprite = Assets.character;
						frameCounter = 0;
					}
					
				}
				
			}
			
			else if(inRestart) {
				if(rMenu.isMouseClick()) {
					restartGame();
					addKeyListener(sc);
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
	
	public void stop() {
		
		bg1 = null;
		sc.stop();
		sc = null;
		startButton = null;
		rMenu = null;
		
		scores.stop();
		scores = null;
		
		thread.interrupt();
		thread = null;
		
	}
	
	public void update(Graphics g) {

	}

	public void paint(Graphics g) {
		
		g.drawImage(Assets.background, bg1.getBgX(), bg1.getBgY());

		if(inGame && !inRestart) {
			gamePaint(g);
			scores.paint(g, 0, 0);
		}
			
		else if(inMenu) {
			startButton.paint(g);
		}
		else if(inRestart) {
			gamePaint(g);
			rMenu.paint(g);
			scores.paint(g, rMenu.getX() - 5, rMenu.getY() - 20);
			scores.paint(g, rMenu.getX() - 5, rMenu.getY() + 90, highScore);
		}
		
	}
	
	public void gamePaint(Graphics g) {
		
		g.drawImage(Assets.currentSprite, sc.getPenguin().getCenterX(), sc.getPenguin().getCenterY());
		
		for(int i = 0; i < sc.getWall().length; i++) {
			
			g.drawImage(Assets.WallPic, sc.getWall()[i].getWallCenter(), sc.getWall()[i].getWally());
			//g.drawRect(sc.getWall()[i].getRleft().x, sc.getWall()[i].getRleft().y, sc.getWall()[i].getRleft().width, sc.getWall()[i].getRleft().height);
			//g.drawRect(sc.getWall()[i].getRright().x, sc.getWall()[i].getRright().y, sc.getWall()[i].getRright().width, sc.getWall()[i].getRright().height);
			
			//g.drawRect(sc.getPenguinBox().x, sc.getPenguinBox().y, sc.getPenguinBox().width, sc.getPenguinBox().height);

		}
		
	}
	
	public void restartGame() {
		sc.stop();
		sc.start();
		removeMouseListener(rMenu);
		rMenu = null;
		inRestart = false;
		Assets.currentSprite = Assets.character;
	}

}
