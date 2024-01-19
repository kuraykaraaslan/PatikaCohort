package org.rentacar.views;

import org.rentacar.controller.CarController;
import org.rentacar.controller.ModelController;
import org.rentacar.core.ComboItem;
import org.rentacar.core.Helpers;
import org.rentacar.entities.Car;
import org.rentacar.entities.Model;

import javax.swing.*;

public class CarView extends Layout{
    private JPanel container;
    private JLabel lbl_header;
    private JLabel lbl_model;
    private JComboBox cmb_models;
    private JLabel lbl_color;
    private JLabel lbl_km;
    private JComboBox cmb_color;
    private JTextField fld_car_km;
    private JLabel lbl_plate;
    private JTextField fld_car_plate;
    private JButton btn_save;
    private Car car;
    private ModelController modelController;
    private CarController carController;

    public CarView(Car car){
        this.car = car;
        this.add(container);
        this.carController = new CarController();
        this.modelController = new ModelController();

        this.layoutStart(400,300);

        this.cmb_color.setModel(new DefaultComboBoxModel<>(Car.Color.values()));

        for (Model model : this.modelController.getAll()){
            this.cmb_models.addItem(model.getComboItem());
        }

        if (this.car.getId() != 0 ){
            ComboItem selectedItem = car.getModel().getComboItem();
            this.cmb_models.getModel().setSelectedItem(selectedItem);
            this.cmb_color.getModel().setSelectedItem(car.getColor());
            this.fld_car_plate.setText(car.getPlate());
            this.fld_car_km.setText(Integer.toString(car.getKilometers()));
        }

        this.btn_save.addActionListener(e -> {
            if (Helpers.isFieldEmpty(this.fld_car_km)){
                Helpers.showErrorMessage("KM field cannot be empty.");
            } else {
                if (Helpers.isFieldEmpty(this.fld_car_plate)){
                    Helpers.showErrorMessage("Plate field cannot be empty.");
                } else {
                    boolean result = false;
                    ComboItem selectedModel = (ComboItem) this.cmb_models.getSelectedItem();
                    this.car.setId(selectedModel.getKey());
                    this.car.setColor((Car.Color) this.cmb_color.getSelectedItem());
                    this.car.setPlate(fld_car_plate.getText());
                    this.car.setKilometers(Integer.parseInt(this.fld_car_km.getText()));
                    if (this.car.getId() != 0){
                        result = this.carController.updateCar(this.car);
                    } else {
                        result = this.carController.saveCar(this.car);
                    }

                    if (result){
                        Helpers.showErrorMessage("Added model.", "Operation successful.");
                        dispose();
                    } else {
                        Helpers.showErrorMessage("Something went wrong.");
                    }
                }
            }
        });
    }
}
