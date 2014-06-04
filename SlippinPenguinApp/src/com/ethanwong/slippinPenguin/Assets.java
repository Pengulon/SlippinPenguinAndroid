package com.ethanwong.slippinPenguin;

import com.ethanwong.framework.Graphics;
import com.ethanwong.framework.Image;
import com.ethanwong.framework.Music;
import com.ethanwong.framework.Sound;

public class Assets {

	public static Image splash, menu, currentSprite, character, character2, 
	characterHurt, background, WallPic, startPic, startHitPic, scorePic, 
	rMenu, rMenuHit;
	
	public static Graphics second;
	
    public static Sound click;
    
    public static Music theme;
	
	public static void load(PenguinGame sampleGame) {
        // TODO Auto-generated method stub
        theme = sampleGame.getAudio().createMusic("menutheme.mp3");
        theme.setLooping(true);
        theme.setVolume(0.85f);
        theme.play();
    }

}
