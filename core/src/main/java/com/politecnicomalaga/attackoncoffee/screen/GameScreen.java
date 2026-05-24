package com.politecnicomalaga.attackoncoffee.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.politecnicomalaga.attackoncoffee.Main;
import com.politecnicomalaga.attackoncoffee.model.GrupoClientes;

public class GameScreen extends ScreenAdapter {

    private final Main game;
    private final Stage stage;

    private GrupoClientes grupoClientes;
    private Barista barista;

    public GameScreen(Main game) {
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.5f, 1);
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            game.setScreen(new GameOverScreen(game));
        }
    }
}
