package com.politecnicomalaga.attack_on_coffee.model;
import java.util.ArrayList;

public class filaClientes {

    private ArrayList<Cliente> clientes;
    private int velocidadHorizontal;
    private boolean moviendoDerecha;

    public FilaClientes(int velocidadHorizontal) {
        this.clientes = new ArrayList<>();
        this.velocidadHorizontal = velocidadHorizontal;
        this.moviendoDerecha = true;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void moverHorizontal() {

        for (Cliente cliente : clientes) {

            if (moviendoDerecha) {
                cliente.setX(cliente.getX() + velocidadHorizontal);
            } else {
                cliente.setX(cliente.getX() - velocidadHorizontal);
            }
        }
    }

    public void cambiarDireccion() {
        moviendoDerecha = !moviendoDerecha;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
