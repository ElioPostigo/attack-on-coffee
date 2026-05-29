package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class GrupoClientes {

    private final FilaClientes[] filas;
    private final float velocidadVertical;
    private float velocidadHorizontal;

    public GrupoClientes(int numFilas, int clientesPorFila, Texture textura, float xInicial, float yInicial,
                         float separacionHorizontal, float separacionVertical, float velocidadHorizontal, float velocidadVertical) {
        this.velocidadHorizontal = velocidadHorizontal;
        this.velocidadVertical = velocidadVertical;

        filas = new FilaClientes[numFilas];

        for (int i = 0; i < numFilas; i++) {
            float y = yInicial - (i * separacionVertical);
            filas[i] = new FilaClientes(clientesPorFila, textura, xInicial, y, separacionHorizontal);
        }
    }

    public void mover(float delta) {
        boolean tocarBorde = false;

        // Detectar bordes
        for (FilaClientes fila : filas) {
            for (Cliente c : fila.getClientes()) {
                if (c != null && c.isActivo()) {

                    // Derecha
                    if (c.getSprite().getX() + c.getSprite().getWidth() >= Gdx.graphics.getWidth()) {
                        tocarBorde = true;
                    }

                    // Izquierda
                    if (c.getSprite().getX() <= 0) {
                        tocarBorde = true;
                    }
                }
            }
        }

        // Si toca borde:
        if (tocarBorde) {
            velocidadHorizontal = -velocidadHorizontal;
            for (FilaClientes fila : filas) {
                for (Cliente c : fila.getClientes()) {
                    if (c != null && c.isActivo()) {
                        c.getSprite().translateY(-velocidadVertical);
                        c.updatePosition();
                    }
                }
            }
        }

        // Movimiento horizontal
        for (FilaClientes fila : filas) {
            fila.moverHorizontal(velocidadHorizontal, delta);
        }
    }

    public FilaClientes[] getFilas() {
        return filas;
    }
}
