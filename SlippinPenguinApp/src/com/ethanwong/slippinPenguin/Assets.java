package com.ethanwong.slippinPenguin;

import com.ethanwong.framework.Graphics;
import com.ethanwong.framework.Image;
import com.ethanwong.framework.Music;
import com.ethanwong.framework.Sound;

public class Assets {

	public static Image menu, image, currentSprite, character, character2, characterHurt, background, WallPic;
	public static Graphics second;
	
	public static Image button;
    public static Sound click;
    public static Music theme;
	
	public static void load(PenguinGame sampleGame) {
        // TODO Auto-generated method stub
        theme = sampleGame.getAudio().createMusic("menutheme.mp3");
        theme.setLooping(true);
        theme.setVolume(0.85f);
        theme.play();
    }

	public static Image getMenu() {
		return menu;
	}

	public static Image getImage() {
		return image;
	}

	public static Image getCurrentSprite() {
		return currentSprite;
	}

	public static Image getCharacter() {
		return character;
	}

	public static Image getCharacter2() {
		return character2;
	}

	public static Image getCharacterHurt() {
		return characterHurt;
	}

	public static Image getBackground() {
		return background;
	}

	public static Image getWallPic() {
		return WallPic;
	}

	public static Graphics getSecond() {
		return second;
	}

	public static void setMenu(Image menu) {
		Assets.menu = menu;
	}

	public static void setImage(Image image) {
		Assets.image = image;
	}

	public static void setCurrentSprite(Image currentSprite) {
		Assets.currentSprite = currentSprite;
	}

	public static void setCharacter(Image character) {
		Assets.character = character;
	}

	public static void setCharacter2(Image character2) {
		Assets.character2 = character2;
	}

	public static void setCharacterHurt(Image characterHurt) {
		Assets.characterHurt = characterHurt;
	}

	public static void setBackground(Image background) {
		Assets.background = background;
	}

	public static void setWallPic(Image wallPic) {
		WallPic = wallPic;
	}

	public static void setSecond(Graphics second) {
		Assets.second = second;
	}

}
