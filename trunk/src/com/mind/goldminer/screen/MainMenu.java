package com.mind.goldminer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

public class MainMenu implements Screen{

	public ScreenState 		nextState;
	
	private boolean 		isDone;
	
	private final SpriteBatch 	spriteBatch;
	private final Texture 		background;
	private final BitmapFont	font;
	
	private final Matrix4 		viewMatrix;
	private final Matrix4 		transformMatrix;
	
	public MainMenu() {
		Gdx.app.log("MainMenu", "MainMenu()");
		nextState = ScreenState.LevelX;
		
		isDone = false;
		
		spriteBatch = new SpriteBatch();
		background = new Texture(Gdx.files.internal("data/background.png"));
		background.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		font = new BitmapFont(Gdx.files.internal("data/font16.fnt"), Gdx.files.internal("data/font16.png"), false);
		
		viewMatrix = new Matrix4();
		transformMatrix = new Matrix4();
	}
	
	@Override
	public void render() {
		Gdx.app.log("MainMenu", "render()");
		
		Application app = Gdx.app;
		
		app.getGraphics().getGL10().glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		viewMatrix.setToOrtho2D(0, 0, 800, 480);
		spriteBatch.setProjectionMatrix(viewMatrix);
		spriteBatch.setTransformMatrix(transformMatrix);
		spriteBatch.begin();
		spriteBatch.setColor(Color.WHITE);
		spriteBatch.disableBlending();
		spriteBatch.draw(background, 0, 0, 800, 480, 0, 0, 512, 512, false, false);
		spriteBatch.enableBlending();
		String text = "Touch screen to start!";
		int width = font.getBounds(text).width;	
		font.draw(spriteBatch, text, 240 - width / 2, 128);
		spriteBatch.end();
	}

	@Override
	public void update() {
		Gdx.app.log("MainMenu", "update()");
		isDone = Gdx.input.isTouched();
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
		Gdx.app.log("MainMenu", "isDone()");
		return isDone;
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
		background.dispose();
		font.dispose();
	}

}
