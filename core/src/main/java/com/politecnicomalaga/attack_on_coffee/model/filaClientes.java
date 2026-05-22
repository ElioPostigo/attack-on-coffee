package com.politecnicomalaga.attack_on_coffee.model;

import java.util.ArrayList;

public class FilaClientes {

    private ArrayList<Cliente> clientes;
    private int velocidadHorizontal;
    private boolean moviendoDerecha;

    public FilaClientes(int velocidadHorizontal) {
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void moverHorizontal() {
    }

    public void cambiarDireccion() {
        moviendoDerecha = !moviendoDerecha;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
