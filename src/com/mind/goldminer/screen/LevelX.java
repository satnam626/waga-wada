package com.mind.goldminer.screen;

import com.badlogic.gdx.Gdx;

public class LevelX implements Screen{

	public ScreenState nextState;
	
	private enum LevelState { LevelLoading,
							LevelPlay, 
							LevelFailed,
							LevelComplete, 
							LevelShop,
							};
	
	private LevelState			curLevelState;
	private LevelState			nextLevelState;
	
	private boolean			isDone;
	
	private int 				levelPlayResult;
	private int 				levelFailedChoice;
							
//	private final SpriteBatch 	spriteBatch;
//	private final Texture 		background;
//	private final Texture		miner;
//	private final Texture		gold;
//	
//	private final Matrix4		viewMatrix;
//	private final Matrix4		transformMatrix;
	
	public LevelX() {
		Gdx.app.log("LevelX", "LevelX()");
		nextState = ScreenState.MainMenu;
		curLevelState = LevelState.LevelLoading;
		nextLevelState = LevelState.LevelLoading;
		
		isDone = false;
		
		levelPlayResult = 0;
		levelFailedChoice = 0;
		
//		spriteBatch = new SpriteBatch();
//		background = new Texture(Gdx.files.internal("data/background.png"));
//		background.setFilter(TextureFilter.Linear, TextureFilter.Linear);
//		miner = new Texture(Gdx.files.internal("data/miner.png"));
//		miner.setFilter(TextureFilter.Linear, TextureFilter.Linear);
//		gold = new Texture(Gdx.files.internal("data/gold.png"));
//		gold.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
//		viewMatrix = new Matrix4();
//		transformMatrix = new Matrix4();
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.app.log("LevelX", "render()");
//		Application app = Gdx.app;
//		
//		app.getGraphics().getGL10().glClear(GL10.GL_COLOR_BUFFER_BIT);
//		
//		viewMatrix.setToOrtho2D(0, 0, 800, 480);
//		spriteBatch.setProjectionMatrix(viewMatrix);
//		spriteBatch.setTransformMatrix(transformMatrix);
//		spriteBatch.begin();
//		spriteBatch.disableBlending();
//		spriteBatch.draw(background, 0, 0, 800, 480, 0, 0, 512, 512, false, false);
//		spriteBatch.enableBlending();
//		spriteBatch.draw(miner, 400, 400);
//		spriteBatch.draw(gold, 300, 200);
//		spriteBatch.end();
		switch (curLevelState) {
		case LevelLoading:
			renderLevelLoading();
			break;
		case LevelPlay:
			renderLevelPlay();
			break;
		case LevelFailed:
			renderLevelFailed();
			break;
		case LevelComplete:
			renderLevelComplete();
			break;
		case LevelShop:
			renderLevelShop();
			break;
		default:
			break;
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Gdx.app.log("LevelX", "update()");
		
//		curLevelState = (curLevelState != nextLevelState) ? nextLevelState : curLevelState;
		
		if (curLevelState != nextLevelState) {
			curLevelState = nextLevelState;
		}
		
		switch (curLevelState) {
		case LevelLoading:
			updateLevelLoading();
			break;
		case LevelPlay:
			updateLevelPlay();
			break;
		case LevelFailed:
			updateLevelFailed();
			break;
		case LevelComplete:
			updateLevelComplete();
			break;
		case LevelShop:
			updateLevelShop();
			break;
		default:
			break;
		}
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
		return isDone;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	private void updateLevelLoading() {
		Gdx.app.log("LevelX", "updateLevelLoading()");
		switchLevelState(LevelState.LevelPlay);
	}
	
	private void updateLevelPlay() {
		Gdx.app.log("LevelX", "updateLevelPlay()");
		switch (levelPlayResult) {
		case 0:
			switchLevelState(LevelState.LevelFailed);
			++levelPlayResult;
			break;
		case 1:
			switchLevelState(LevelState.LevelComplete);
			++levelPlayResult;
			break;
		case 2:
			switchLevelState(LevelState.LevelFailed);
		default:
			break;
		}
	}

	private void updateLevelFailed() {
		Gdx.app.log("LevelX", "updateLevelFailed()");
		switch (levelFailedChoice) {
		case 0:
			switchLevelState(LevelState.LevelPlay);
			++levelFailedChoice;
			break;
		case 1:
			Gdx.app.log("LevelX", "Exit Level after failed!");
			isDone = true;
			break;
		default:
			break;
		}
	}

	private void updateLevelComplete() {
		Gdx.app.log("LevelX", "updateLevelComplete()");
		switchLevelState(LevelState.LevelShop);
	}

	private void updateLevelShop() {
		Gdx.app.log("LevelX", "updateLevelShop()");
		switchLevelState(LevelState.LevelLoading);
	}
	
	private void renderLevelLoading() {
		Gdx.app.log("LevelX", "renderLevelLoading()");
	}
	
	private void renderLevelPlay() {
		Gdx.app.log("LevelX", "renderLevelPlay()");
	}

	private void renderLevelFailed() {
		Gdx.app.log("LevelX", "renderLevelFailed()");
	}

	private void renderLevelComplete() {
		Gdx.app.log("LevelX", "renderLevelComplete()");
	}

	private void renderLevelShop() {
		Gdx.app.log("LevelX", "renderLevelShop()");
	}
	
	private void switchLevelState(LevelState levelState) {
		Gdx.app.log("LevelX", "switchLevelState()");
		nextLevelState = levelState;
	}
}
