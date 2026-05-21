package com.politecnicomalaga.attackoncoffee.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.politecnicomalaga.attackoncoffee.Main;

public class GameScreen extends ScreenAdapter {
    private final Main game;

    public GameScreen(Main game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.5f, 1);
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            game.setScreen(new GameOver(game));
        }
    }
}
