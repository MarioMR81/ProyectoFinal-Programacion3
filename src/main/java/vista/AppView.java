package vista;

import controller.AppController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.AppModel;

import java.util.ArrayList;
import java.util.List;

public class AppView extends BorderPane {
    // Configurar menús
    Menu archivoMenu = new Menu("Archivo");
    Menu insertarMenu = new Menu("Insertar");
    Menu ayudaMenu = new Menu("Ayuda");
    MenuBar menuBar = new MenuBar();
    AppModel appModel = new AppModel();
    HBox buttonContainer = new HBox();

    AppController controller ;
    private List<Button> lista;
    public AppView(Stage stage) {

        lista = new ArrayList<>();
        controller = new AppController(appModel,this);
        // Configuración de la vista principal de la aplicación
        // Aquí puedes añadir los componentes y diseños necesarios
        MenuItem nuevoArchivo = new MenuItem("Nuevo archivo");
        MenuItem nuevoHoja = new MenuItem("Nueva hoja");
        nuevoArchivo.setOnAction(event -> {
            controller.getModel().reiniciar();
            lista.removeAll(lista);
            buttonContainer = new HBox();
            this.setBottom(buttonContainer);
            HojaCalculoView hojaCalculoView = new HojaCalculoView(stage);
            appModel.agregarHojaCalculo(hojaCalculoView);
            this.mostrarHojaCalculo(hojaCalculoView);
        });

        nuevoHoja.setOnAction(event -> {
            HojaCalculoView hojaCalculoView = new HojaCalculoView(stage);
            appModel.agregarHojaCalculo(hojaCalculoView);
            this.mostrarHojaCalculo(hojaCalculoView);
        });

        HojaCalculoView hojaCalculoView = new HojaCalculoView(stage);
        appModel.agregarHojaCalculo(hojaCalculoView);
        this.mostrarHojaCalculo(hojaCalculoView);
        archivoMenu.getItems().add(nuevoArchivo);
        insertarMenu.getItems().add(nuevoHoja);
        menuBar.getMenus().addAll(archivoMenu, insertarMenu, ayudaMenu);

        HBox horizontalContainer = new HBox();
        VBox verticalContainer = new VBox(menuBar,horizontalContainer);

        Label label = new Label(" f(x):");
        TextField textField = new TextField();

        Button aplicarButton = new Button("Aplicar");
        Button rechazarButton = new Button("Rechazar");
        rechazarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textField.setText("");
            }

        });

        // Establecer el espaciado y alineación del contenedor vertical
        horizontalContainer.setSpacing(10);
        // Establecer las propiedades de expansión para el TextField
        HBox.setHgrow(textField, Priority.ALWAYS);

        // Agregar los componentes al contenedor vertical
        horizontalContainer.getChildren().addAll(label, textField, aplicarButton, rechazarButton);
        this.setTop(verticalContainer);

        Scene scene = new Scene(this, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Hoja electrónica");
        stage.show();
    }

    public void mostrarHojaCalculo(HojaCalculoView hojaCalculoView) {
        this.setCenter(hojaCalculoView);
        lista.add(new Button((lista.size()+1)+""));
        Button nuevo = new Button(" Hoja "+lista.size()+" ");
        AppView temp = this;
        int valor  = lista.size()-1;
        nuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                temp.setCenter(appModel.getHoja(valor));
            }

        });
        buttonContainer.getChildren().add(nuevo);
        this.setBottom(buttonContainer);
    }

    // Resto de la implementación de la vista...
}
