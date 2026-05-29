package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Barista extends Entidad {

    private final List<Cafe> cafesEnPantalla;
    private float tiempoDisparo; // Cooldown entre disparos
    private final Sprite sprite;
    private float velocidadX;
    private final Texture cafeTexture ;
    private final Sound shootSound;

    public Barista(Texture img, float x, float y) {
        super(img, x, y);
        this.velocidadX = 0f;
        this.cafesEnPantalla = new ArrayList<>();
        this.tiempoDisparo = 1f;
        sprite = getSprite();
        velocidadX = 200f;
        cafeTexture= new Texture("cafe.png");
        shootSound = Gdx.audio.newSound(Gdx.files.internal("sounds/shootSound.mp3"));
    }

    public void updatePosition(float delta) {
        super.updatePosition();
        // --- CONTROL PARA PC (TECLADO) ---
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            getSprite().translateX(-this.velocidadX * delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            getSprite().translateX(this.velocidadX * delta);
        }

        // --- CONTROL PARA ANDROID (PANTALLA TÁCTIL) ---
        if (Gdx.input.isTouched()) {
            // Obtenemos la posición X del toque del usuario en la pantalla
            float toqueX = Gdx.input.getX();
            // Calculamos dónde está la mitad de la pantalla actual
            float mitadPantalla = Gdx.graphics.getWidth() / 2f;

            // Si toca en la mitad izquierda, se desplaza a la izquierda
            if (toqueX < mitadPantalla) {
                getSprite().translateX(-this.velocidadX * delta);
            }
            // Si toca en la mitad derecha, se desplaza a la derecha
            else {
                getSprite().translateX(this.velocidadX * delta);
            }
        }

        // --- LÍMITES DE PANTALLA ---
        if (getSprite().getX() < 0) {
            getSprite().setX(0);
        }
        if (getSprite().getX() + getSprite().getWidth() > Gdx.graphics.getWidth()) {
            getSprite().setX(Gdx.graphics.getWidth() - getSprite().getWidth());
        }

        // Disparo
        tiempoDisparo -= delta;
        if (tiempoDisparo <= 0) {
            disparar();
            tiempoDisparo = 1f;
        }

        // Actualizar disparos
        for (int i = cafesEnPantalla.size() - 1; i >= 0; i--) {
            Cafe cafe = cafesEnPantalla.get(i);
            cafe.mover();
            cafe.updatePosition();
            if (!cafe.isActivo()) {
                cafesEnPantalla.remove(i);
            }
        }
    }

    public void disparar() {
        // Crear un nuevo disparo (café) en la posición del barista
        Texture cafeTexture = new Texture("cafe.png"); // Cargar textura
        Cafe cafe = new Cafe(cafeTexture, sprite.getX(), sprite.getY(), 200f);
        shootSound.play(1.2f);
        cafesEnPantalla.add(cafe);
    }

//    public Cafe disparar(Texture texturaCafe, float velocidadVerticalCafe) {
//        float xDisparo = getSprite().getX() + (getSprite().getWidth() / 2f) - (texturaCafe.getWidth() / 2f);
//        float yDisparo = getSprite().getY() + getSprite().getHeight();
//
//        return new Cafe(texturaCafe, xDisparo, yDisparo, velocidadVerticalCafe);
//    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        for (Cafe cafe : cafesEnPantalla) {
            cafe.draw(batch);
        }
    }

    public List<Cafe> getCafes() {
        return cafesEnPantalla;
    }

    public void dispose(){
        if (shootSound != null) shootSound.dispose();
        cafeTexture.dispose();
    }

}
