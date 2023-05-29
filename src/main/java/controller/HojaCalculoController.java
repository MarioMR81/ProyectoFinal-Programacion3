package controller;

import model.HojaCalculoModel;
import vista.HojaCalculoView;

import java.util.Hashtable;
import java.util.StringTokenizer;

public class HojaCalculoController {
    private HojaCalculoModel model;
    private HojaCalculoView view;

    public int x;
    public int y;
    public HojaCalculoController(HojaCalculoModel model, HojaCalculoView view) {
        this.model = model;
        this.view = view;

    }

    public void setValue(int row, int col, String value) {
        model.setValue(row, col, value);
    }
    public String getValue(int row, int col) {
        return model.getValue(row, col);
    }

    public String calcularSuma(String funcion) {
        String newValor="";
        try{
            String formula = "=suma((1,1),(2,2))";
            formula = funcion;
            int pos[] = new int[4];
            int i = 0;
            // Eliminar los caracteres no numéricos y los paréntesis
            String numeros = formula.replaceAll("[^0-9,]", "").replace("(", "").replace(")", "");

            // Utilizar StringTokenizer para dividir los números
            StringTokenizer tokenizer = new StringTokenizer(numeros, ",");
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                int numero = Integer.parseInt(token);
                // Realizar acciones con el valor numérico
                pos[i++] = numero;
            }
            if(funcion.contains("=suma") || funcion.contains("=mult"))
            {
                if(model.getValue(pos[0],pos[1])!=null && model.getValue(pos[2],pos[3])!=null)
                {
                    String valor1 = model.getValue(pos[0],pos[1]);
                    String valor2 = model.getValue(pos[2],pos[3]);
                    try {
                        int numero1 = Integer.parseInt(valor1);
                        int numero2 = Integer.parseInt(valor2);
                        int nuevoValor = 0;
                        if(funcion.contains("=suma"))
                        {
                             nuevoValor = numero1 + numero2;
                        }else
                        {
                             nuevoValor = numero1 * numero2;
                        }
                        newValor = nuevoValor+"";
                    } catch (NumberFormatException e) {
                        if(funcion.contains("=suma"))
                        {
                            newValor = valor1+valor2;
                        }
                    }

                }

            }
        }catch(Exception e)
        {

        }
        return newValor;
    }

    public void calcularMultiplicacion() {
        model.calcularMultiplicacion();
    }

    public void generarTablaHash() {
        model.generarTablaHash();
    }

    public void mostrarTabla() {
        String[][] data = obtenerDatosTabla();
        view.mostrarTabla(data);
    }


    public void mostrarMensaje(String mensaje) {
        view.mostrarMensaje(mensaje);
    }

    public void mostrarTablaHash() {
        Hashtable<Integer, String> hashTable = model.getHashTable();
        view.mostrarTablaHash(hashTable);
    }

    // Métodos privados del controlador para obtener los datos de la tabla
    private String[][] obtenerDatosTabla() {
        // Lógica para obtener los datos de la hoja de cálculo en formato de matriz
        return null;
    }

    // Métodos para manejar eventos de la interfaz gráfica
    private void onCalcularSumaButtonClicked() {
        //calcularSuma();
        mostrarTabla();
    }

    private void onCalcularMultiplicacionButtonClicked() {
        calcularMultiplicacion();
        mostrarTabla();
    }

    private void onGenerarTablaHashButtonClicked() {
        generarTablaHash();
        mostrarTablaHash();
    }
}