package model;

import java.io.Serializable;

public class ListaEnlazada<T>{
    private NodoLista<T> cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public void add(T valor) {
        NodoLista<T> nuevoNodo = new NodoLista<>(valor);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoLista<T> nodoActual = cabeza;
            while (nodoActual.siguiente != null) {
                nodoActual = nodoActual.siguiente;
            }
            nodoActual.siguiente = nuevoNodo;
        }
    }

    public void borrarTodo() {
        cabeza = null;
    }

    public boolean buscar(T valor) {
        NodoLista<T> nodoActual = cabeza;
        while (nodoActual != null) {
            if (nodoActual.valor.equals(valor)) {
                return true;
            }
            nodoActual = nodoActual.siguiente;
        }
        return false;
    }

    public T get(int index) {
        NodoLista<T> nodoActual = cabeza;
        int actual = 0;
        while (nodoActual != null) {
            if (actual==index) {
                return nodoActual.valor;
            }
            actual++;
            nodoActual = nodoActual.siguiente;
        }
        return null;
    }


}