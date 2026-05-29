package com.politecnicomalaga.attackoncoffee.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class GrupoClientes {

    private final FilaClientes[] filas;
    private final float velocidadVertical;
    private final Texture clienteAlto;
    private final Texture clienteMedio;
    private float velocidadHorizontal;

    public GrupoClientes(int numFilas, int clientesPorFila, Texture clienteBajo, float xInicial, float yInicial,
                         float separacionHorizontal, float separacionVertical, float velocidadHorizontal, float velocidadVertical) {
        this.velocidadHorizontal = velocidadHorizontal;
        this.velocidadVertical = velocidadVertical;

        filas = new FilaClientes[numFilas];
        clienteAlto = new Texture("Alto.png");
        clienteMedio = new Texture("Medio.png");

        for (int i = 0; i < numFilas; i++) {
            float y = yInicial - (i * separacionVertical);
            switch (i) {
                case 0:
                    filas[i] = new FilaClientes(clientesPorFila, clienteAlto, xInicial, y, separacionHorizontal, 20);
                    break;
                case 1:
                    filas[i] = new FilaClientes(clientesPorFila, clienteMedio, xInicial, y, separacionHorizontal, 10);
                    break;
                case 2:
                    filas[i] = new FilaClientes(clientesPorFila, clienteBajo, xInicial, y, separacionHorizontal, 5);
                    break;
                case 3:
                    filas[i] = new FilaClientes(clientesPorFila, clienteBajo, xInicial, y, separacionHorizontal, 5);
                    break;
                default:
                    filas[i] = new FilaClientes(clientesPorFila, clienteBajo, xInicial, y, separacionHorizontal, 5);
            }
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

    public void dispose() {
        clienteAlto.dispose();
        clienteMedio.dispose();
    }
}
