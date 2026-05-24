package com.politecnicomalaga.attackoncoffee.model;

public class FilaClientes {

    private final float velocidad;
    private Cliente[] clientes;

    public FilaClientes(Cliente[] clientes, float velocidad) {
        this.clientes = clientes;
        this.velocidad = velocidad;
    }

    public void moverHorizontal(float delta) {

        for (Cliente c : clientes) {

            if (c != null && c.isActivo()) {

//                c.moverHorizontal(velocidad * delta);
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
