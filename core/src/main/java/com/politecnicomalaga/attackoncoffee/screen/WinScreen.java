package com.politecnicomalaga.attackoncoffee.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.politecnicomalaga.attackoncoffee.Main;
import com.politecnicomalaga.attackoncoffee.manager.SettingsManager;

public class WinScreen extends ScreenAdapter {
    private final Main game;
    private Texture winImage;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Sound winSound;

    public WinScreen(Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera(SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT);
        viewport = new StretchViewport(SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT, camera);
        winImage = new Texture("win.jpeg");
        winSound = Gdx.audio.newSound(Gdx.files.internal("sounds/winSound.mp3"));
        batch = new SpriteBatch();
        winSound.play(0.5f);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.5f, 1);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(winImage, 0, 0, SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT);
        batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new MenuScreen(game));
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        if (winSound != null) winSound.dispose();
        winImage.dispose();
        batch.dispose();
    }
}
