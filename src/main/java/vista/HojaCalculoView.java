package vista;

import controller.HojaCalculoController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import model.AppModel;
import model.HojaCalculoModel;


public class HojaCalculoView extends BorderPane implements Serializable{

    private TableView<String[]> tableView;

    HojaCalculoController controller;
    HojaCalculoModel glbModel;
    AppModel appModel = new AppModel();
    public HojaCalculoView(Stage stage) {
        controller = new HojaCalculoController(new HojaCalculoModel(50,50),this);
        // Inicializar la interfaz gráfica con los componentes necesarios
        tableView = new TableView<>();
        this.setCenter(tableView);
        this.setPrefSize(800,800);
        HojaCalculoModel model = new HojaCalculoModel(50, 50);
        glbModel=model;
        this.mostrarTabla(this.obtenerDatosHojaCalculo(model));
        tableView.setEditable(true);
        tableView.getSelectionModel().cellSelectionEnabledProperty().set(true);

    }
    public void mostrarTabla(String[][] data) {
        tableView.getColumns().clear();
        tableView.getItems().clear();

        // Crear columnas en función del número de columnas en los datos
        char letra = 65;
        for (int col = 0; col < data[0].length; col++) {
            TableColumn<String[], String> column = new TableColumn<>("      "+(letra++)+"        ");
            final int columnIndex = col;
            column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[columnIndex]));
            column.setCellFactory(TextFieldTableCell.forTableColumn());
            column.setOnEditCommit(event -> {
                String newValue = event.getNewValue();
                int row = event.getTablePosition().getRow();
                int col2 = event.getTablePosition().getColumn();
                tableView.getItems().get(row)[col2] = newValue;
                controller.setValue(row,col2,newValue);
                if(newValue.charAt(0)=='=')
                {
                    controller.x = row;
                    controller.y = col2;
                    String valor = controller.calcularSuma(newValue);
                    if(!valor.equals(""))
                    {
                        tableView.getItems().get(row)[col2] = valor;
                        controller.setValue(row,col2,valor);
                    }
                }
                tableView.refresh();
            });

            tableView.getColumns().add(column);
        }

        // Agregar filas a la tabla
        tableView.getItems().addAll(Arrays.asList(data));
    }

    public void guardarHojaCalculo(String direccion) {
        try (FileOutputStream fos = new FileOutputStream(direccion)) {
            ObjectOutputStream salida = new ObjectOutputStream(fos);
            String[][] datos = this.obtenerDatosTabla();
            salida.writeObject(datos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String[][] obtenerDatosTabla() {
        int rows = tableView.getItems().size();
        int cols = tableView.getColumns().size();
        String[][] data = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                data[row][col] = tableView.getItems().get(row)[col];
            }
        }

        return data;
    }



    private String[][] obtenerDatosHojaCalculo(HojaCalculoModel model) {
        int rows = model.getNumeroFilas();
        int cols = model.getNumeroColumnas();
        String[][] data = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                data[row][col] = "";
                if(col==0 || row==0)
                {
                    if(col==0)
                    {
                        data[row][col] = row+" ";
                    }else
                    {
                        data[row][col] = col+" ";
                    }
                }
            }
        }

        return data;
    }
}
