package model;


import java.io.*;

public class HojaCalculoModel implements Serializable{
    private int rows;
    private int cols;
    private MatrizOctagonal matriz;

    public HojaCalculoModel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matriz = new MatrizOctagonal(rows,cols);
    }
    public void setValue(int row, int col, String value) {
        matriz.set(row,col,value);
    }

    public String getValue(int row, int col) {
        return matriz.get(row,col);
    }


    public int getNumeroFilas() {
        return rows;
    }

    public int getNumeroColumnas() {
        return cols;
    }
 
}
