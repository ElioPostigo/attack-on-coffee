package com.politecnicomalaga.attackoncoffee.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.politecnicomalaga.attackoncoffee.Main;
import com.politecnicomalaga.attackoncoffee.model.GrupoClientes;

public class GameScreen extends ScreenAdapter {

    private final Main game;
    private final Stage stage;

    private Barista barista;
    private final GrupoClientes grupoClientes;

    public GameScreen(Main game) {
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        this.barista = new Barista();
        this.grupoClientes = new GrupoClientes(4, 6, new Texture("gilipollas.png"), 0f, 0f, 20f, 20f, 0.5f, 0.5f);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.5f, 1);

        barista.dispara();

        grupoClientes.colisiona(barista.getBala());

        if (grupoClientes.tieneClientes()) {
            game.setScreen(new GameOverScreen(game));
        }

        barista.render();
        grupoClientes.moverVertical(delta);
        grupoClientes.render();
    }
}
