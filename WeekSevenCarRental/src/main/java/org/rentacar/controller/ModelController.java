package org.rentacar.controller;


import org.rentacar.core.ComboItem;
import org.rentacar.core.Helpers;
import org.rentacar.data.ModelData;
import org.rentacar.entities.Model;

import java.util.ArrayList;
public class ModelController {
    public final ModelData modelData = new ModelData();

    public Model getById(int modelId) {
        return modelData.get(modelId);
    }

    public ArrayList<Object[]> getForTable(int size, ArrayList<Model> models) {
        ArrayList<Object[]> data = new ArrayList<>();
        for (Model model : models) {
            Object[] row = new Object[size];
            row[0] = model.getId();
            row[1] = model.getName();
            data.add(row);
        }
        return data;
    }

    public ArrayList<Model> getAll() {
        return modelData.getAll();
    }

    public boolean saveModel(Model model) {
        return modelData.add(model);
    }


    public boolean updateModel(Model model) {
        if (modelData.get(model.getId()) != null) {
            return modelData.update(model);
        } else {
            Helpers.showErrorMessage("Model not found");
            return false;
        }
    }

    public boolean deleteModel(Model model) {
        if (modelData.get(model.getId()) != null) {
            return modelData.delete(model.getId());
        } else {
            Helpers.showErrorMessage("Model not found");
            return false;
        }
    }
}