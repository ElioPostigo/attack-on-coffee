package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.graphics.Texture;

public class GrupoClientes {

    private FilaClientes[] filas;
    private float velocidadVertical;

    public GrupoClientes(
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

        filas = new FilaClientes[numFilas];

        for (int i = 0; i < numFilas; i++) {

            float y = yInicial - (i * separacionVertical);

            filas[i] = new FilaClientes(
                clientesPorFila,
                textura,
                xInicial,
                y,
                separacionHorizontal,
                velocidadHorizontal
            );
        }
    }

    public void mover(float delta) {

        boolean bajar = false;

        // Movimiento horizontal
        for (FilaClientes fila : filas) {

            if (fila != null) {

                if (fila.moverHorizontal(delta)) {
                    bajar = true;
                }
            }
        }

        // Movimiento vertical al tocar borde
        if (bajar) {

            for (FilaClientes fila : filas) {

                if (fila != null) {

                    for (Cliente c : fila.getClientes()) {

                        if (c != null && c.isActivo()) {

                            c.getSprite().translateY(-velocidadVertical);

                            c.updatePosition(delta);
                        }
                    }
                }
            }
        }
    }

    public FilaClientes[] getFilas() {
        return filas;
    }
}
