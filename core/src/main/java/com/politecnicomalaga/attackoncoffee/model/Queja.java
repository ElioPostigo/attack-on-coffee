package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Queja extends Accion {

    //La velocidad se puede modificar, podemos hacer fija cambiando la variable velocidad por un numero
    //O dejarla asi para cuando queramos subirle la dificultad dependiendo el nivel
    public Queja(Texture img, float x, float y, float velocidad) {
        super(img, x, y, velocidad);
    }

    //Es el movimiento pero al reves
    @Override
    public void mover() {
        getSprite().translateY(-getVelocidad() * Gdx.graphics.getDeltaTime());
        updatePosition(0);

        if (getSprite().getY() < 0) {
            setActivo(false);
        }
    }
}
