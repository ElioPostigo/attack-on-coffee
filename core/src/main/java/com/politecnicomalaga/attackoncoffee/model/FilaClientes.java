package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.graphics.Texture;

public class FilaClientes {

    private final Cliente[] clientes;

    public FilaClientes(int cantidad, Texture textura, float xInicial, float y, float separacion) {
        clientes = new Cliente[cantidad];

        for (int i = 0; i < cantidad; i++) {
            float x = xInicial + (i * separacion);
            clientes[i] = new Cliente(textura, x, y);
        }
    }

    public void moverHorizontal(float velocidad, float delta) {
        for (Cliente c : clientes) {
            if (c != null && c.isActivo()) {
                c.getSprite().translateX(velocidad * delta);
                c.updatePosition();
            }
        }
    }

    public Cliente[] getClientes() {
        return clientes;
    }
}
