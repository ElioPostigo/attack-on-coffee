package com.politecnicomalaga.attack_on_coffee.model;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Cliente extends Persona {

    private boolean vivo;
    private ArrayList<Queja> quejas;

    public Cliente(Texture img, float x, float y) {
        super(img, x, y);

        this.vivo = true;
        this.quejas = new ArrayList<>();
    }

    public void lanzarQueja(Texture texturaQueja) {

        Queja q = new Queja(
            texturaQueja,
            getSprite().getX(),
            getSprite().getY()
        );

        quejas.add(q);
    }

    public void morir() {
        vivo = false;
        setActivo(false);
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public ArrayList<Queja> getQuejas() {
        return quejas;
    }

    public void setQuejas(ArrayList<Queja> quejas) {
        this.quejas = quejas;
    }
}
