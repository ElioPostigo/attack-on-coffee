package com.politecnicomalaga.attackoncoffee.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.politecnicomalaga.attackoncoffee.Main;
import com.politecnicomalaga.attackoncoffee.manager.SettingsManager;

public class MenuScreen extends ScreenAdapter {
    private final Main game;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture background;
    private Texture startButton;
    private Viewport viewport;
    private TextButton start;

    private Stage stage;
    private BitmapFont font;

    public MenuScreen(Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        background = new Texture("background.jpeg");
        startButton = new Texture("start.png");
        camera = new OrthographicCamera(SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT);
        batch = new SpriteBatch();
        viewport = new StretchViewport(SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT, camera);

        stage = new Stage(viewport, batch);
        Gdx.input.setInputProcessor(stage);

        TextureRegionDrawable fondoBoton = new TextureRegionDrawable(new TextureRegion(startButton));
        font = new BitmapFont();

        TextButton.TextButtonStyle estilo = new TextButton.TextButtonStyle();
        estilo.up = fondoBoton;
        estilo.font = font;

        start = new TextButton("", estilo);

        start.setSize(400, 120);

        float posX = (viewport.getWorldWidth() / 2f) - (start.getWidth() / 2f);
        float posY = 80f;

        start.setPosition(posX, posY);

        stage.addActor(start);

        start.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new GameScreen(game));

                dispose();
            }
        });
    }

    @Override
    public void render(float delta) {
        // Limpiar pantalla de forma moderna
        ScreenUtils.clear(0, 0, 0, 1);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(background, 0, 0, SettingsManager.SCREEN_WIDTH, SettingsManager.SCREEN_HEIGHT);
        batch.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        startButton.dispose();
        stage.dispose();
        font.dispose();
    }
}
