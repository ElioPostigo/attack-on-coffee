package com.politecnicomalaga.attackoncoffee;

import com.badlogic.gdx.Game;
import com.politecnicomalaga.attackoncoffee.screen.MenuScreen;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends Game {

    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
