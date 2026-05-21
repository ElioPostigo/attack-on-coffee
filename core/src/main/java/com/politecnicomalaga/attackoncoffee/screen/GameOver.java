package com.politecnicomalaga.attackoncoffee.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.politecnicomalaga.attackoncoffee.Main;

public class GameOver extends ScreenAdapter {
    private final Main game;
    private Texture gameOver;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;

    public GameOver(Main game) {
        this.game = game;
    }

    @Override
    public void show(){
        camera = new OrthographicCamera(1280,720);
        viewport = new StretchViewport(1280,720,camera);
        gameOver = new Texture("gameOver.png");
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.5f, 1);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(gameOver,0,0);
        batch.end();

        if(Gdx.input.isTouched()){
            game.setScreen(new MenuScreen(game));
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose(){
        gameOver.dispose();
    }
}
