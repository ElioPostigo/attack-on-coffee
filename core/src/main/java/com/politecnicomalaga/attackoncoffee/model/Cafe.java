package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Cafe extends Accion {

    public Cafe(Texture img, float x, float y, float velocidad) {
        super(img, x, y, velocidad);
    }

    //Esto es para que la bala amiga suba hacia arriba
    @Override
    public void mover() {
        getSprite().translateY(getVelocidad() * Gdx.graphics.getDeltaTime());
        updatePosition(0);

        //Ejemplo de que pasa si sale de la pantalla
        if (getSprite().getY() > 720) {
            setActivo(false);
        }
    }
}
