package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Entidad {
    private float x,y;
    private Rectangle hitbox;
    private Sprite sprite;
    private boolean activo;

    public Entidad(Texture img,float x, float y){
        this.sprite = new Sprite(img);
        this.sprite.setPosition(x,y);
        this.hitbox = new Rectangle(x,y,sprite.getWidth(),sprite.getHeight());
        this.activo = true;
    }

    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

    public void updateHitbox(float delta){
        hitbox.setPosition(sprite.getX(),sprite.getY());
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
