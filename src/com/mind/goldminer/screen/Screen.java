package com.mind.goldminer.screen;

public interface Screen {
	
	public enum ScreenState { Uninit,
							 MainMenu,
							 LevelX,
							 Shop, 
							 GameOver }
	
	public void render();
	
	public void update();
	
	public void setNextState( ScreenState screenState );
	
	public ScreenState nextState();
	
	public boolean isDone();
	
	public void dispose();

}
