package org.rentacar.views;

import org.rentacar.controller.BrandController;
import org.rentacar.controller.ModelController;
import org.rentacar.core.ComboItem;
import org.rentacar.core.Helpers;
import org.rentacar.entities.Brand;
import org.rentacar.entities.Model;

import javax.swing.*;

public class ModelView extends Layout {
    private JPanel container;
    private JLabel lbl_header;
    private JLabel lbl_brand;
    private JComboBox<ComboItem> cmb_brand;
    private JTextField fld_model_name;
    private JLabel lbl_name;
    private JLabel mdl_year;
    private JTextField fld_year;
    private JLabel lbl_type;
    private JComboBox<Model.Type> cmb_type;
    private JLabel lbl_fuel;
    private JComboBox<Model.Fuel> cmb_fuel;
    private JLabel lbl_gear;
    private JComboBox<Model.Gear> cmb_gear;
    private JButton btn_save;
    private Model model;
    private ModelController modelController;
    private BrandController brandController;

    public ModelView(Model model){
        this.model = model;
        this.modelController = new ModelController();
        this.brandController = new BrandController();
        this.add(container);
        layoutStart(450,500);

        for (Brand brand : this.brandController.getAll()){
            this.cmb_brand.addItem(new ComboItem(brand.getId(), brand.getName()));
        }

        this.cmb_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));

        if (this.model.getId() != 0){
            this.fld_year.setText(this.model.getYearString());
            this.fld_model_name.setText(this.model.getName());
            this.cmb_fuel.getModel().setSelectedItem(this.model.getFuel());
            this.cmb_type.getModel().setSelectedItem(this.model.getType());
            this.cmb_gear.getModel().setSelectedItem(this.model.getGear());
            ComboItem defaultBrand = new ComboItem(1, "Placeholder");
            this.cmb_brand.getModel().setSelectedItem(defaultBrand);
        }

        this.btn_save.addActionListener(e -> {
            if (Helpers.isFieldEmpty(this.fld_model_name)){
                Helpers.showErrorMessage("Model name cannot be empty.");
            } else {
                if (Helpers.isFieldEmpty(this.fld_year)){
                    Helpers.showErrorMessage("Model year cannot be empty.");
                } else {
                    boolean result = false;

                    ComboItem selectedBrand = (ComboItem) cmb_brand.getSelectedItem();
                    // find brand by id
                    Brand brand = this.brandController.getById(selectedBrand.getKey());

                    this.model.setYear(fld_year.getText());
                    this.model.setName(fld_model_name.getText());
                    this.model.setBrand(brand);
                    this.model.setType((Model.Type) cmb_type.getSelectedItem());
                    this.model.setFuel((Model.Fuel) cmb_fuel.getSelectedItem());
                    this.model.setGear((Model.Gear) cmb_gear.getSelectedItem());

                    if (this.model.getId() != 0){
                        result = this.modelController.updateModel(this.model);
                    } else {
                        result = this.modelController.saveModel(this.model);
                    }

                    if (result){
                        Helpers.showErrorMessage("Added model.", "Operation successful.");
                        dispose();
                    }
                }
            }
        });
    }
}
