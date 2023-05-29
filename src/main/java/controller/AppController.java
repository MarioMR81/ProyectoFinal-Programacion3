package controller;

import model.AppModel;
import model.HojaCalculoModel;
import vista.AppView;
import vista.HojaCalculoView;

public class AppController {
    private AppModel model;
    private AppView view;


    public AppController(AppModel model, AppView view) {
        this.model = model;
        this.view = view;
    }

    public AppModel getModel() {
        return model;
    }

    public void setModel(AppModel model) {
        this.model = model;
    }

    public AppView getView() {
        return view;
    }

    public void setView(AppView view) {
        this.view = view;
    }
}
