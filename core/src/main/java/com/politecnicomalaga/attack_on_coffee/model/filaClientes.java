package com.politecnicomalaga.attack_on_coffee.model;

public class FilaClientes {

    private Cliente[] clientes;
    private float velocidad;

    public FilaClientes(Cliente[] clientes, float velocidad) {
        this.clientes = clientes;
        this.velocidad = velocidad;
    }

    public void moverHorizontal(float delta) {

        for (Cliente c : clientes) {

            if (c != null && c.isVivo()) {

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
