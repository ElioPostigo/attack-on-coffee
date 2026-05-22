package com.politecnicomalaga.attack_on_coffee.model;

public class grupoClientes {

    private filaClientes[] filas;
    private float velocidadVertical;

    public grupoClientes(filaClientes[] filas, float velocidadVertical) {
        this.filas = filas;
        this.velocidadVertical = velocidadVertical;
    }

    public void moverVertical(float delta) {
    }

    public filaClientes[] getFilas() {
        return filas;
    }

    public void setFilas(filaClientes[] filas) {
        this.filas = filas;
    }
}
