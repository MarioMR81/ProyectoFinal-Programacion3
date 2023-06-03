package model;

import java.io.Serializable;

public class NodoLista <T> implements Serializable {
    public T valor;
    public NodoLista<T> siguiente;

    public NodoLista(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}
