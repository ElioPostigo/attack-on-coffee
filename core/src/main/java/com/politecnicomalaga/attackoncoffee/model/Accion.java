package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.graphics.Texture;
public abstract class Accion extends Entidad{
    private float velocidad;
    //Para Controlar si ha impactado el proyectil/accion/bala/ataque y etc
    private boolean impactado;
    public Accion(Texture img, float x, float y,float velocidad){
        super(img,x,y);
        this.velocidad=velocidad;
        this.impactado = false;
    }
    //para definir como se va a mover cada accion
    public abstract void mover();
    public float getVelocidad(){
        return velocidad;
    }
    public void setVelocidad(){
        this.velocidad=velocidad;
    }
    public boolean getImpactado(){
        return impactado;
    }
    //Si al final la proyectil/accion/bala/ataque impacta al objetivo se desactiva
    public void setImpactado(){
        this.impactado=impactado;
        if(impactado)setActivo(false);
    }
}

