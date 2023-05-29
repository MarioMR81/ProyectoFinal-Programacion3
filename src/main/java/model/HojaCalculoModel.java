package model;

import java.util.Hashtable;

public class HojaCalculoModel {
    private int rows;
    private int cols;
    private MatrizOctagonal matriz;
    private Hashtable<Integer, String> hashTable;


    public HojaCalculoModel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.hashTable = new Hashtable<>();
        matriz = new MatrizOctagonal(rows,cols);
    }

    public void setValue(int row, int col, String value) {
        matriz.set(row,col,value);
    }

    public String getValue(int row, int col) {
        return matriz.get(row,col);
    }

    public void calcularSuma() {
        // Lógica para calcular la suma de las celdas

    }

    public void calcularMultiplicacion() {
        // Lógica para calcular la multiplicación de las celdas
    }

    public void generarTablaHash() {
        // Lógica para generar la tabla hash a partir de los datos de la columna A
    }

    public Hashtable<Integer, String> getHashTable() {
        return hashTable;
    }

    public int getNumeroFilas() {
        return rows;
    }

    public int getNumeroColumnas() {
        return cols;
    }
}
