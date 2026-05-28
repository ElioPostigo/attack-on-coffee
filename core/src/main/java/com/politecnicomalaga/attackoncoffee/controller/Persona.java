package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.graphics.Texture;

public abstract class Persona extends Entidad {

    private float velocidad;

    public Persona(
        Texture img,
        float x,
        float y,
        float velocidad
    ) {

        super(img, x, y);

        this.velocidad = velocidad;
    }

    // Define cómo se mueve cada persona
    public abstract void mover(float delta);

    // Define cómo dispara cada persona
    public abstract void disparar();

    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }
}
