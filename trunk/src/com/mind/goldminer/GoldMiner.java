package com.mind.goldminer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.mind.goldminer.screen.GameOver;
import com.mind.goldminer.screen.LevelX;
import com.mind.goldminer.screen.MainMenu;
import com.mind.goldminer.screen.Screen;
import com.mind.goldminer.screen.Shop;

public class GoldMiner implements ApplicationListener{

	private Screen screen;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		Gdx.app.log("GoldMiner", "create()");
		screen = new MainMenu();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		Gdx.app.log("GoldMiner", "dispose()");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		Gdx.app.log("GoldMiner", "pause()");
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.app.log("GoldMiner", "render()");
		
		if (screen.isDone()) {
			switch (screen.nextState()) {		
			case MainMenu:
				screen = new MainMenu();
				break;
			case LevelX:
				screen = new LevelX();
				break;
			case Shop:
				screen = new Shop();
				break;
			case GameOver:
				screen = new GameOver();
				break;
			default:
				break;
			}
			
		}
		
		screen.update();
		screen.render();

	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		Gdx.app.log("GoldMiner", "resize()");
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		Gdx.app.log("GoldMiner", "resume()");
	}

}
