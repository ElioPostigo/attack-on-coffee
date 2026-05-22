package com.politecnicomalaga.attack_on_coffee.model;

public class Cliente extends Persona {
    public Cliente(int x, int y, int vida, int velocidad) {
        super(x, y, vida, velocidad);
    }

    @Override
    public void mover() {
        x += velocidad;
    }

    @Override
    public void recibirDanio(int cantidad) {
        vida -= cantidad;

        if (vida <= 0) {
            morir();
        }
    }

    public Queja lanzarQueja() {
        return new Queja(x, y);
    }

    public void morir() {
        //ns que va aqui;
    }
}
