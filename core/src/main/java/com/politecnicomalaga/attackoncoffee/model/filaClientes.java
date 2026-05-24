package com.politecnicomalaga.attackoncoffee.model;

public class filaClientes {

    private Cliente[] clientes;
    private float velocidad;

    public filaClientes(Cliente[] clientes, float velocidad) {
        this.clientes = clientes;
        this.velocidad = velocidad;
    }

    public void moverHorizontal(float delta) {

        for (Cliente c : clientes) {

            if (c != null && c.isActivo()) {

                c.moverHorizontal(velocidad * delta);
            }
        }
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }
}
