package model;

import javafx.stage.Stage;
import vista.AppView;
import vista.HojaCalculoView;

import java.io.*;

public class AppModel{
    public ListaEnlazada<HojaCalculoView> hojasCalculo;
    AppModel appModel;
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
    }

}
