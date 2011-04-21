package com.mind.goldminer.screen;

import java.io.InputStream;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.mind.goldminer.object.Hook;

public class LevelX implements Screen{

	private InputStream 	inputStream;
	
	public ScreenState nextState;
	
	private enum LevelState { LevelLoading,
							LevelPlay, 
							LevelFailed,
							LevelComplete, 
							LevelShop
							};
	
	private LevelState			curLevelState;
	private LevelState			nextLevelState;
	
	private boolean			isDone;
	
	private int 				levelPlayResult;
	private int 				levelFailedChoice;
	
	private final SpriteBatch	spriteBatch;
	private final Texture		loadingBackground;
	private final BitmapFont	font;
	private Hook 				hook;

	private final Matrix4		viewMatrix;
	private final Matrix4		transformMatrix;
	
	private final int 			LAYERNUMBER = 5;
	private ArrayList<ArrayList<Sprite>>	layers;
	
	private ArrayList<Sprite>		golds;
	private ArrayList<Sprite>		stones;
	private Texture					levelPlayBackground;
	private int[]					leveldatas;
	private int					loadingStep;
	
	public LevelX() {
		Gdx.app.log("LevelX", "LevelX()");
		nextState = ScreenState.MainMenu;
		curLevelState = LevelState.LevelLoading;
		nextLevelState = LevelState.LevelLoading;
		
		loadingStep = 0;
		
		layers = new ArrayList<ArrayList<Sprite>>();
		for (int i = 0; i < LAYERNUMBER; ++i) {
			layers.add(new ArrayList<Sprite>());
		}
		
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
		spriteBatch.dispose();
		loadingBackground.dispose();
		font.dispose();
		levelPlayBackground.dispose();
		
	}

	private void updateLevelLoading() {
		Gdx.app.log("LevelX", "updateLevelLoading()");
		
		switch (loadingStep) {
		case 0:
			//add sprite to layer 0
			Texture tempTex;
			for (int i = 0; i < 3; ++i) {
				tempTex = new Texture(Gdx.files.internal("data/levels/gold"+i+".png"));
				tempTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
				layers.get(0).add(new Sprite(tempTex));
			}
			++loadingStep;
			break;
		case 1:
			//add sprite to layer 1
			for (int i = 0; i < 2; ++i) {
				tempTex = new Texture(Gdx.files.internal("data/levels/stone"+i+".png"));
				tempTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
				layers.get(1).add(new Sprite(tempTex));
			}
			++loadingStep;
			break;
		case 2:
			//add sprite to layer 2
			++loadingStep;
			break;
		case 3:
			//add sprite to layer 3
			++loadingStep;
			break;
		case 4:
			//add sprite to layer 4
			++loadingStep;
			break;
		case 5:
			hook = new Hook(new Sprite(new Texture(Gdx.files.internal("data/levels/hook.png"))));
			levelPlayBackground = new Texture(Gdx.files.internal("data/levels/levelplaybackground.png"));
			switchLevelState(LevelState.LevelPlay);
			break;
		default:
			break;
		}
	}
	
	private void updateLevelPlay() {
		Gdx.app.log("LevelX", "updateLevelPlay()");
		
		if (Gdx.input.isTouched()) {
			//set flag to detect collision.
		}
		
		//do sth
		hook.update();
		
		if (true/*flag to detect*/) {
			//move hook
			//detect collision
			//if collision, do sth.
		}
		else {
			
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
		
		hook.draw(spriteBatch);
		
		for (int layerIndex = 0, layerSize = layers.size(); layerIndex < layerSize; ++layerIndex) {
			for (int spriteIndex = 0, spriteNum = layers.get(layerIndex).size(); spriteIndex < spriteNum; ++spriteIndex) {
				layers.get(layerIndex).get(spriteIndex).draw(spriteBatch);
			}
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
