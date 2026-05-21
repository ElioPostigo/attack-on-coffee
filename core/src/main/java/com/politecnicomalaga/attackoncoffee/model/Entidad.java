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
}
