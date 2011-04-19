package com.mind.goldminer.screen;

import com.badlogic.gdx.Gdx;

public class MainMenu implements Screen{

	public ScreenState nextState;
	
	public MainMenu() {
		
		nextState = ScreenState.LevelX;
		Gdx.app.log("MainMenu", "MainMenu()");
	}
	
	@Override
	public void render() {
		Gdx.app.log("MainMenu", "render()");
	}

	@Override
	public void update() {
		Gdx.app.log("MainMenu", "update()");
	}

	@Override
	public void setNextState(ScreenState screenState) {
		Gdx.app.log("MainMenu", "setNextState()");
		nextState = screenState;
	}

	@Override
	public ScreenState nextState() {
		Gdx.app.log("MainMenu", "nextState()");
		return nextState;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		Gdx.app.log("MainMenu", "isDone()");
		return Gdx.input.isTouched();
	}

}
