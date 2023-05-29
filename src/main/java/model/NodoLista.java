package model;

public class NodoLista <T>{
    public T valor;
    public NodoLista<T> siguiente;

    public NodoLista(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}
