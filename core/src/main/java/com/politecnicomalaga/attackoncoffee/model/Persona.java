package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.graphics.Texture;

public abstract class Persona extends Entidad {

    public Persona(Texture img, float x, float y, float velocidadX, float velocidadY) {
        super(img, x, y, velocidadX, velocidadY);
    }

    public abstract void mover(float delta);
}
