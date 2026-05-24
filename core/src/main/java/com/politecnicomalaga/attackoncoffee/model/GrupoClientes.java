package com.politecnicomalaga.attackoncoffee.model;

public class GrupoClientes {

    private final float velocidadVertical;
    private FilaClientes[] filas;

    public GrupoClientes(FilaClientes[] filas, float velocidadVertical) {
        this.filas = filas;
        this.velocidadVertical = velocidadVertical;
    }

    public void moverVertical(float delta) {
        for (FilaClientes fila : filas) {
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

    public FilaClientes[] getFilas() {
        return filas;
    }

    public void setFilas(FilaClientes[] filas) {
        this.filas = filas;
    }
}
