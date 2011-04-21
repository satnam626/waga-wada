package com.mind.goldminer.screen;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

public class LevelX implements Screen{

	public ScreenState nextState;
	
	private enum LevelState { LevelLoading,
							LevelPlay, 
							LevelFailed,
							LevelComplete, 
							LevelShop
							};
							
	private enum LoadingSteps { Step0, 
								Step1,
								Step2 };
	
	private LevelState			curLevelState;
	private LevelState			nextLevelState;
	
	private boolean			isDone;
	
	private int 				levelPlayResult;
	private int 				levelFailedChoice;
	
	private final SpriteBatch	spriteBatch;
	private final Texture		loadingBackground;
	private final BitmapFont	font;

	private final Matrix4		viewMatrix;
	private final Matrix4		transformMatrix;
	
	private ArrayList<Texture>		golds;
	private ArrayList<Texture>		stones;
	private Texture					levelPlayBackground;
	private int[]					leveldatas;
	private LoadingSteps			loadingStep;
	
	public LevelX() {
		Gdx.app.log("LevelX", "LevelX()");
		nextState = ScreenState.MainMenu;
		curLevelState = LevelState.LevelLoading;
		nextLevelState = LevelState.LevelLoading;
		
		loadingStep = LoadingSteps.Step0;
		
		golds = new ArrayList<Texture>();
		stones = new ArrayList<Texture>();
		
		isDone = false;
		
		levelPlayResult = 0;
		levelFailedChoice = 0;
		
		spriteBatch = new SpriteBatch();
		loadingBackground = new Texture(Gdx.files.internal("data/levels/loadingbackground.jpg"));
		loadingBackground.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		font = new BitmapFont(Gdx.files.internal("data/font16.fnt"), Gdx.files.internal("data/font16.png"), false);
		
		viewMatrix = new Matrix4();
		transformMatrix = new Matrix4();
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.app.log("LevelX", "render()");
		
		Gdx.app.getGraphics().getGL10().glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		viewMatrix.setToOrtho2D(0, 0, 800, 480);
		spriteBatch.setProjectionMatrix(viewMatrix);
		spriteBatch.setTransformMatrix(transformMatrix);
		spriteBatch.begin();
		
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
		
		spriteBatch.end();
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
		switch (loadingStep) {
		case Step0:
			for (int i = 0; i < 3; ++i) {
				golds.add(new Texture(Gdx.files.internal("data/levels/gold"+i+".png")));
				golds.get(i).setFilter(TextureFilter.Linear, TextureFilter.Linear);	
			}
			loadingStep = LoadingSteps.Step1;
			break;
		case Step1:
			for (int i = 0; i < 2; ++i) {
				stones.add(new Texture(Gdx.files.internal("data/levels/stone"+i+".png")));
				stones.get(i).setFilter(TextureFilter.Linear, TextureFilter.Linear);
			}
			loadingStep = LoadingSteps.Step2;
			break;
		case Step2:
			levelPlayBackground = new Texture(Gdx.files.internal("data/levels/levelplaybackground.png"));
			switchLevelState(LevelState.LevelPlay);
			break;
		default:
			break;
		}
	}
	
	private void updateLevelPlay() {
		Gdx.app.log("LevelX", "updateLevelPlay()");
		
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
		
		spriteBatch.setColor(Color.WHITE);
		spriteBatch.disableBlending();
		spriteBatch.draw(loadingBackground, 0, 0, 800, 480, 0, 0, 512, 512, false, false);
		spriteBatch.enableBlending();
		String text = "Loading........";
		int width = font.getBounds(text).width;
		font.setColor(Color.RED);
		font.draw(spriteBatch, text, 400-width/2, 128);
	}
	
	private void renderLevelPlay() {
		Gdx.app.log("LevelX", "renderLevelPlay()");
		
		spriteBatch.setColor(Color.WHITE);
		spriteBatch.disableBlending();
		spriteBatch.draw(levelPlayBackground, 0, 0, 800, 480, 0, 0, 512, 512, false, false);
		spriteBatch.enableBlending();
		
		for (int i = 0, size = golds.size(); i < size; ++i) {
			spriteBatch.draw(golds.get(i), (i+1)*200, (i+1)*30);
		}
		
		for (int i = 0, size = stones.size(); i < size; ++i) {
			spriteBatch.draw(stones.get(i), (i+1)*233, (i+1)*10);
		}
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
