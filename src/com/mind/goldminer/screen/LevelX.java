package com.mind.goldminer.screen;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

public class LevelX implements Screen{

	public ScreenState nextState;
	
	private enum LevelState { Level_Loading,
							Level_Play, 
							Level_Failed,
							Level_Complete, 
							Level_Shop,
							};
	
	private LevelState			curLevelState;
	private LevelState			nextLevelState;
							
//	private final SpriteBatch 	spriteBatch;
//	private final Texture 		background;
//	private final Texture		miner;
//	private final Texture		gold;
//	
//	private final Matrix4		viewMatrix;
//	private final Matrix4		transformMatrix;
	
	public LevelX() {
		Gdx.app.log("LevelX", "LevelX()");
//		nextState = ScreenState.Shop;
		curLevelState = LevelState.Level_Loading;
		nextLevelState = LevelState.Level_Play;
		
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

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
