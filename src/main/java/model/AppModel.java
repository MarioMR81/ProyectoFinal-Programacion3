package model;

import vista.AppView;
import vista.HojaCalculoView;

public class AppModel {
    private ListaEnlazada<HojaCalculoView> hojasCalculo;
    public AppModel() {
        hojasCalculo = new ListaEnlazada<>();
    }

    public void agregarHojaCalculo(HojaCalculoView hojaCalculoView) {
        hojasCalculo.add(hojaCalculoView);
    }

    public HojaCalculoView getHoja(int index)
    {
        return hojasCalculo.get(index);
    }

    public void reiniciar()
    {
        //hojasCalculo.removeAll(hojasCalculo);
    }


}
