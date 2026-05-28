package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.Gdx;
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

    // Devuelve true si toca un borde
    // Mueve la fila, detecta bordes, y cambia la direccion
    public boolean moverHorizontal(float delta) {

        boolean cambiarDireccion = false;

        for (Cliente c : clientes) {

            if (c != null && c.isActivo()) {

                c.getSprite().translateX(velocidad * delta);

                c.updatePosition(delta);

                // Borde derecho
                if (c.getSprite().getX() + c.getSprite().getWidth()
                    >= Gdx.graphics.getWidth()) {

                    cambiarDireccion = true;
                }

                // Borde izquierdo
                if (c.getSprite().getX() <= 0) {

                    cambiarDireccion = true;
                }
            }
        }

        // Cambiar dirección
        if (cambiarDireccion) {
            velocidad = -velocidad;
        }

        return cambiarDireccion;
    }

    public Cliente[] getClientes() {
        return clientes;
    }
}
