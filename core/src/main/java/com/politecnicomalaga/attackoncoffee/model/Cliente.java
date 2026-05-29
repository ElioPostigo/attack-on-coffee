package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Cliente extends Entidad {
    private ArrayList<Queja> quejas;

    public Cliente(Texture img, float x, float y) {
        super(img, x, y);
        this.quejas = new ArrayList<>();
    }

    //Los clientes lanzan proyectiles, este metodo crea proyectiles
    public void lanzarQueja(Texture texturaQueja) {
        Queja q = new Queja(
                texturaQueja,
                getSprite().getX(),
                getSprite().getY(),
                200);

        quejas.add(q);
    }

    public ArrayList<Queja> getQuejas() {
        return quejas;
    }

    public void setQuejas(ArrayList<Queja> quejas) {
        this.quejas = quejas;
    }
}
