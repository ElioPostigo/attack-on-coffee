package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.graphics.Texture;

public class grupoClientes {

    private filaClientes[] filas;
    private float velocidadVertical;

    public grupoClientes(
        int numFilas,
        int clientesPorFila,
        Texture textura,
        float xInicial,
        float yInicial,
        float separacionHorizontal,
        float separacionVertical,
        float velocidadHorizontal,
        float velocidadVertical
    ) {

        this.velocidadVertical = velocidadVertical;

        filas = new filaClientes[numFilas];

        for (int i = 0; i < numFilas; i++) {

            float y = yInicial - (i * separacionVertical);

            filas[i] = new filaClientes(
                clientesPorFila,
                textura,
                xInicial,
                y,
                separacionHorizontal,
                velocidadHorizontal
            );
        }
    }

    public void moverVertical(float delta) {

        for (filaClientes fila : filas) {

            if (fila != null) {

                for (Cliente c : fila.getClientes()) {

                    if (c != null && c.isActivo()) {

                        c.getSprite().translateY(-velocidadVertical * delta);

                        c.updatePosition(delta);
                    }
                }
            }
        }
    }

    public filaClientes[] getFilas() {
        return filas;
    }
}
