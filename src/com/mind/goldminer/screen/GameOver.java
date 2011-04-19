package com.mind.goldminer.screen;

import com.badlogic.gdx.Gdx;

public class GameOver implements Screen{

	public ScreenState nextState;
	
	public GameOver() {
		
		nextState = ScreenState.MainMenu;
		Gdx.app.log("GameOver", "GameOver()");
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.app.log("GameOver", "render()");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Gdx.app.log("GameOver", "update()");
	}

	@Override
	public void setNextState(ScreenState screenState) {
		// TODO Auto-generated method stub
		Gdx.app.log("GameOver", "setNextState()");
		nextState = screenState;
	}

	@Override
	public ScreenState nextState() {
		// TODO Auto-generated method stub
		Gdx.app.log("GameOver", "nextState()");
		return nextState;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		Gdx.app.log("GameOver", "isDone()");
		return Gdx.input.isTouched();
	}

}
