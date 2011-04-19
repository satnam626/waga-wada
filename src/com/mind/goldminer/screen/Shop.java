package com.mind.goldminer.screen;

import com.badlogic.gdx.Gdx;

public class Shop implements Screen{

	public ScreenState nextState;
	
	public Shop() {
		
		nextState = ScreenState.GameOver;
		Gdx.app.log("Shop", "Shop()");
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.app.log("Shop", "render()");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Gdx.app.log("Shop", "update()");
	}

	@Override
	public void setNextState(ScreenState screenState) {
		// TODO Auto-generated method stub
		Gdx.app.log("Shop", "setNextState()");
		nextState = screenState;
	}

	@Override
	public ScreenState nextState() {
		// TODO Auto-generated method stub
		Gdx.app.log("Shop", "nextState()");
		return nextState;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		Gdx.app.log("Shop", "isDone()");
		return Gdx.input.isTouched();
	}

}
