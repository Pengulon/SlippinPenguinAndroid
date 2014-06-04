package com.ethanwong.slippinPenguin;

import com.ethanwong.framework.Game;
import com.ethanwong.framework.Graphics;
import com.ethanwong.framework.Graphics.ImageFormat;
import com.ethanwong.framework.Screen;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.menu = g.newImage("data/menu.png", ImageFormat.RGB565);
        Assets.background = g.newImage("data/background.png", ImageFormat.RGB565);
        
        Assets.character = g.newImage("data/penguin.png", ImageFormat.ARGB4444);
        Assets.character2 = g.newImage("data/penguin2.png", ImageFormat.ARGB4444);
        Assets.characterHurt = g.newImage("data/penguinDead.png", ImageFormat.ARGB4444);
        		
        Assets.WallPic = g.newImage("data/ice wall.png", ImageFormat.ARGB4444);
        Assets.scorePic = g.newImage("data/iceNumbers.png", ImageFormat.ARGB4444);
        
        Assets.startPic = g.newImage("data/startbutton.png", ImageFormat.ARGB4444);
        Assets.startHitPic = g.newImage("data/startbuttonhit.png", ImageFormat.ARGB4444);
        
        Assets.rMenu = g.newImage("data/restartMenu.png", ImageFormat.ARGB4444);
        Assets.rMenuHit = g.newImage("data/restartMenuHit.png", ImageFormat.ARGB4444);

        //This is how you would load a sound if you had one.
        //Assets.click = game.getAudio().createSound("explode.ogg");

        
        game.setScreen(new MainMenuScreen(game));

    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawImage(Assets.splash, 0, 0);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {

    }
}