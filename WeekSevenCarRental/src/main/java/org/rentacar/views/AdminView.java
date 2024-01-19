package org.rentacar.views;

import org.rentacar.controller.BrandController;
import org.rentacar.controller.CarController;
import org.rentacar.controller.ModelController;
import org.rentacar.core.ComboItem;
import org.rentacar.core.Helpers;
import org.rentacar.entities.Brand;
import org.rentacar.entities.Car;
import org.rentacar.entities.Model;
import org.rentacar.entities.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AdminView extends Layout{
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane tab_menu;
    private JButton btn_logout;
    private JScrollPane scrl_brand;

    private JPanel pnl_model;
    private JScrollPane scl_model;
    private JTable tbl_model;
    private JTable tbl_car;
    private JTable tb_brand;
    private JComboBox cmb_s_model;
    private JLabel lbl_cmb_menu_brand;
    private JComboBox cmb_s_model_type;
    private JComboBox cmb_s_model_fuel;
    private JComboBox cmb_s_model_gear;
    private JButton btn_search;
    private JLabel lbl_cmb_menu_type;
    private JLabel lbl_cmb_menu_fuel;
    private JLabel lbl_cmb_menu_gear;
    private JPanel pnl_search_options;
    private JPanel pnl_brand;
    private JPanel pnl_car;
    private JScrollPane scrl_car;
    private User currentUser;
    private DefaultTableModel tmdl_brand = new DefaultTableModel();
    private DefaultTableModel tmdl_model = new DefaultTableModel();
    private DefaultTableModel tmdl_car = new DefaultTableModel();
    private BrandController brandController;
    private ModelController modelController;
    private CarController carController;
    private JPopupMenu brand_menu;
    private JPopupMenu model_menu;

    private JPopupMenu car_menu;

    public AdminView(User currentUser){
        this.brandController = new BrandController();
        this.modelController = new ModelController();
        this.add(container);
        layoutStart(500,1000);
        this.currentUser = currentUser;
        if (this.currentUser == null){
            dispose();
        }
        this.lbl_welcome.setText("Welcome, " +this.currentUser.getUsername() + "!");

        refreshBrandTable();
        loadBrandComponent();

        loadModelTable();
        loadModelComponent();
        loadModelFilter();

        loadCarTable();
        loadCarComponent();

    }

    private void loadModelComponent() {
        tableRowSelect(this.tbl_model);
        this.tb_brand.setComponentPopupMenu(brand_menu);

        this.model_menu = new JPopupMenu();
        this.model_menu.add("Add New Model").addActionListener(e -> {
            ModelView modelView = new ModelView(new Model());
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    refreshBrandTable();
                    loadModelTable();
                }
            });
        });
        this.model_menu.add("Edit Selected Model").addActionListener(e -> {
            int selectedModelId = this.getTableSelectedRow(tbl_model, 0);
            ModelView modelView = new ModelView(this.modelController.getById(selectedModelId));
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    refreshBrandTable();
                    loadModelTable();
                }
            });

        });
        this.model_menu.add("Delete Selected Model").addActionListener(e -> {
            if (Helpers.confirm("Yes")){
                int selectedModelId = this.getTableSelectedRow(tbl_model, 0);
                Model model = this.modelController.getById(selectedModelId);
                if (this.modelController.deleteModel(model)){
                    Helpers.showErrorMessage("Brand deleted.", "Operation successful.");
                    refreshBrandTable();
                    loadModelTable();
                } else {
                    Helpers.showErrorMessage("Error.");
                }
            }

        });
        ;
        this.tbl_model.setComponentPopupMenu(model_menu);
    }

    public void refreshBrandTable(){
        Object[] col_brand = {"Brand ID", "Brand Name"};
        ArrayList<Object[]> brandList = this.brandController.getForTable(col_brand.length, this.brandController.getAll());
        this.createTable(this.tmdl_brand, this.tb_brand, col_brand, brandList);

    }

    public void loadBrandComponent(){
        tableRowSelect(this.tb_brand);

        this.brand_menu = new JPopupMenu();
        this.brand_menu.add("Add New Brand").addActionListener(e -> {
            BrandView brandView = new BrandView(null);
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    refreshBrandTable();
                    loadModelTable();
                    loadModelFilterBrand();
                }
            });
        });
        this.brand_menu.add("Edit Selected Brand").addActionListener(e -> {
            int selectedBrandId = this.getTableSelectedRow(tb_brand, 0);
            BrandView brandView = new BrandView(this.brandController.getById(selectedBrandId));
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    refreshBrandTable();
                    loadModelTable();
                    loadModelFilterBrand();
                }
            });
        });
        this.brand_menu.add("Delete Selected Brand").addActionListener(e -> {
            if (Helpers.confirm("Yes")){
                int selectedBrandId = this.getTableSelectedRow(tb_brand, 0);
                Brand brand = this.brandController.getById(selectedBrandId);
                if (this.brandController.deleteBrand(brand)){
                    Helpers.showErrorMessage("Brand deleted.", "Operation successful.");
                    refreshBrandTable();
                    loadModelTable();
                    loadModelFilterBrand();
                } else {
                    Helpers.showErrorMessage("Error.");
                }
            }

        });;
    }

    public void loadModelTable(){
        Object[] col_model = {"ID", "Brand ID", "Name", "Type", "Year", "Fuel", "Gear"};
        ArrayList<Object[]> modelList = this.modelController.getForTable(col_model.length, this.modelController.getAll());
        createTable(this.tmdl_model, this.tbl_model,col_model,modelList);

    }

    public void loadModelFilter(){
        this.cmb_s_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_s_model_type.setSelectedItem(null);
        this.cmb_s_model_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_s_model_fuel.setSelectedItem(null);
        this.cmb_s_model_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_s_model_gear.setSelectedItem(null);
        loadModelFilterBrand();


    }

    public void loadModelFilterBrand(){
        this.cmb_s_model.removeAllItems();
        for (Brand obj: brandController.getAll()){
            this.cmb_s_model.addItem(new ComboItem(obj.getId(), obj.getName()));
        }
        this.cmb_s_model.setSelectedItem(null);
    }

    public void loadCarTable(){
        Object[] col_car = {"ID", "Brand", "Model", "Plate", "Color", "KM", "Year", "Type", "Fuel", "Gear"};
        ArrayList<Object[]> carList = this.carController.getForTable(col_car.length, this.carController.getAll());
        createTable(this.tmdl_car, this.tbl_car,col_car,carList);
    }

    public void loadCarComponent(){
        tableRowSelect(this.tbl_car);

        this.car_menu = new JPopupMenu();
        this.car_menu.add("Add New Car").addActionListener(e -> {
            CarView carView = new CarView(new Car());
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
        this.car_menu.add("Edit Selected Brand").addActionListener(e -> {
            int selectedCarId = this.getTableSelectedRow(tb_brand, 0);
            CarView carView = new CarView(this.carController.getById(selectedCarId));
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
        this.car_menu.add("Delete Selected Brand").addActionListener(e -> {
            if (Helpers.confirm("Yes")){
                int selectedCarId = this.getTableSelectedRow(tbl_car, 0);
                Car car = this.carController.getById(selectedCarId);
                if (this.carController.deleteCar(car)){
                    Helpers.showErrorMessage("Car deleted.", "Operation successful.");
                    loadCarTable();
                } else {
                    Helpers.showErrorMessage("Error.");
                }
            }

        });;
        this.tbl_car.setComponentPopupMenu(car_menu);
    }
}
