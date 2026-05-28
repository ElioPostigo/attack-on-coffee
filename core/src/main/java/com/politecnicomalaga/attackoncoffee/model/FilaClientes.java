package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.graphics.Texture;

public class FilaClientes {

    private Cliente[] clientes;
    private float velocidad;

    public FilaClientes(
        int cantidad,
        Texture textura,
        float xInicial,
        float y,
        float separacion,
        float velocidad
    ) {

        this.velocidad = velocidad;
        this.clientes = new Cliente[cantidad];

        for (int i = 0; i < cantidad; i++) {

            float x = xInicial + (i * separacion);

            clientes[i] = new Cliente(textura, x, y);
        }
    }

    public void moverHorizontal(float delta) {

        for (Cliente c : clientes) {

            if (c != null && c.isActivo()) {

                moverHorizontal(velocidad * delta);
            }
        }
    }

    public Cliente[] getClientes() {
        return clientes;
    }
}
