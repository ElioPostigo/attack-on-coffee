package com.politecnicomalaga.attack_on_coffee.model;

import java.util.ArrayList;

public class Cliente extends Persona {

    private ArrayList<Queja> quejas;

    public Cliente(int x, int y, int vida, int velocidad) {
        super(x, y, vida, velocidad);
        this.quejas = new ArrayList<>();
    }

    @Override
    public void mover() {
        setX(getX() + velocidad);
    }

    public void crearQueja() {
        Queja nuevaQueja = new Queja(getX(), getY());
        quejas.add(nuevaQueja);
    }

    public ArrayList<Queja> getQuejas() {
        return quejas;
    }

    public void moverQuejas() {
        for (Queja queja : quejas) {
            queja.mover();
        }
    }

    public void eliminarQueja(Queja queja) {
        quejas.remove(queja);
    }
}
