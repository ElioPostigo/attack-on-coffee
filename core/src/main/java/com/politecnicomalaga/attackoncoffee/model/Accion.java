package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.graphics.Texture;
public abstract class Accion extends Entidad{
    private float velocidad;
    //Para Controlar si ha impactado el proyectil/accion/bala/ataque y etc
    public Accion(Texture img, float x, float y,float velocidad){
        super(img,x,y);
        this.velocidad=velocidad;
    }

    //para definir como se va a mover cada accion
    public abstract void mover();
    public float getVelocidad(){
        return velocidad;
    }
    public void setVelocidad(){
        this.velocidad=velocidad;
    }
}

