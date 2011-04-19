package com.mind.goldminer.screen;

import com.badlogic.gdx.Gdx;

public class LevelX implements Screen{

	public ScreenState nextState;
	
	public LevelX() {
		
		nextState = ScreenState.Shop;
		Gdx.app.log("LevelX", "LevelX()");	
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.app.log("LevelX", "render()");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Gdx.app.log("LevelX", "update()");
	}

	@Override
	public void setNextState(ScreenState screenState) {
		// TODO Auto-generated method stub
		Gdx.app.log("LevelX", "setNextState()");
		nextState = screenState;
	}

	@Override
	public ScreenState nextState() {
		// TODO Auto-generated method stub
		Gdx.app.log("LevelX", "nextState()");
		return nextState;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		Gdx.app.log("LevelX", "isDone()");
		return Gdx.input.isTouched();
	}

}
