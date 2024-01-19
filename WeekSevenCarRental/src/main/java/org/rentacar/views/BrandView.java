package org.rentacar.views;

import org.rentacar.controller.BrandController;
import org.rentacar.core.Helpers;
import org.rentacar.entities.Brand;

import javax.swing.*;

public class BrandView extends Layout {
    private JPanel container;
    private JLabel lbl_brand;
    private JLabel lbl_brandName;
    private JTextField fld_brandName;
    private JButton btn_brandSave;
    private Brand brand;
    private BrandController brandController;

    public BrandView(Brand brand){
        this.brandController = new BrandController();
        this.add(container);
        this.layoutStart(300,300);
        this.brand = brand;

        if (brand != null){
            this.fld_brandName.setText(brand.getName());
        }

        btn_brandSave.addActionListener(e -> {
            if (Helpers.isFieldEmpty(this.fld_brandName)){
                Helpers.showErrorMessage("Brand name cannot be empty.");
            } else {
                boolean result = false;
                boolean updateIsValid = false;
                if (this.brand == null){
                    result = this.brandController.saveBrand(new Brand(fld_brandName.getText()));
                    result = true;
                } else {
                    this.brand.setName(this.fld_brandName.getText());
                    result = this.brandController.updateBrand(this.brand);
                    updateIsValid = true;
                    Helpers.showErrorMessage("Edited brand.", "Operation successful.");
                    dispose();
                }

                if (result){
                    Helpers.showErrorMessage("Added brand.", "Operation successful.");
                    dispose();
                } else if (!updateIsValid){
                    Helpers.showErrorMessage("Cannot add brand.");
                }
            }
        });
    }


}
