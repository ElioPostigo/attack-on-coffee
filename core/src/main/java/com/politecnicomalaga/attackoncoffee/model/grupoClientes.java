package com.politecnicomalaga.attackoncoffee.model;

public class grupoClientes {

    private filaClientes[] filas;
    private float velocidadVertical;

    public grupoClientes(filaClientes[] filas, float velocidadVertical) {
        this.filas = filas;
        this.velocidadVertical = velocidadVertical;
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

    public void setFilas(filaClientes[] filas) {
        this.filas = filas;
    }
}
