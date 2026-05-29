package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Barista extends Persona {

    public Barista(Texture img, float x, float y, float velocidadX) {
        super(img, x, y, velocidadX, 0f);
    }

    @Override
    public void mover(float delta) {
        // --- CONTROL PARA PC (TECLADO) ---
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            getSprite().translateX(-getVelocidadX() * delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            getSprite().translateX(getVelocidadX() * delta);
        }

        // --- CONTROL PARA ANDROID (PANTALLA TÁCTIL) ---
        if (Gdx.input.isTouched()) {
            // Obtenemos la posición X del toque del usuario en la pantalla
            float toqueX = Gdx.input.getX();
            // Calculamos dónde está la mitad de la pantalla actual
            float mitadPantalla = Gdx.graphics.getWidth() / 2f;

            // Si toca en la mitad izquierda, se desplaza a la izquierda
            if (toqueX < mitadPantalla) {
                getSprite().translateX(-getVelocidadX() * delta);
            }
            // Si toca en la mitad derecha, se desplaza a la derecha
            else {
                getSprite().translateX(getVelocidadX() * delta);
            }
        }

        // --- LÍMITES DE PANTALLA ---
        if (getSprite().getX() < 0) {
            getSprite().setX(0);
        }
        if (getSprite().getX() + getSprite().getWidth() > Gdx.graphics.getWidth()) {
            getSprite().setX(Gdx.graphics.getWidth() - getSprite().getWidth());
        }

        updatePosition();
    }

    public Cafe disparar(Texture texturaCafe, float velocidadVerticalCafe) {
        float xDisparo = getSprite().getX() + (getSprite().getWidth() / 2f) - (texturaCafe.getWidth() / 2f);
        float yDisparo = getSprite().getY() + getSprite().getHeight();

        return new Cafe(texturaCafe, xDisparo, yDisparo, velocidadVerticalCafe);
    }
}
