package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Entidad {

    private final Rectangle hitbox;
    private final Sprite sprite;
    private float velocidadX;
    private float velocidadY;
    private boolean activo;

    public Entidad(Texture img, float x, float y, float velocidadX, float velocidadY) {
        this.sprite = new Sprite(img);
        this.sprite.setPosition(x, y);
        this.hitbox = new Rectangle(x, y, sprite.getWidth(), sprite.getHeight());
        this.velocidadX = velocidadX;
        this.velocidadY = velocidadY;
        this.activo = true;
    }

    public void draw(SpriteBatch batch) {
        if (activo) {
            sprite.draw(batch);
        }
    }

    public void updatePosition() {
        hitbox.setPosition(sprite.getX(), sprite.getY());
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public float getVelocidadX() {
        return velocidadX;
    }

    public void setVelocidadX(float velocidadX) {
        this.velocidadX = velocidadX;
    }

    public float getVelocidadY() {
        return velocidadY;
    }

    public void setVelocidadY(float velocidadY) {
        this.velocidadY = velocidadY;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void dispose() {
        if (sprite != null && sprite.getTexture() != null) {
            sprite.getTexture().dispose();
        }
    }
}
