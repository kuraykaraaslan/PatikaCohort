package org.rentacar.controller;


import org.rentacar.core.Helpers;
import org.rentacar.data.BrandData;
import org.rentacar.entities.Brand;

import java.util.ArrayList;
public class BrandController {
    public final BrandData brandData = new BrandData();


    public ArrayList<Object[]> getForTable(int size, ArrayList<Brand> brands) {
        ArrayList<Object[]> data = new ArrayList<>();
        for (Brand brand : brands) {
            Object[] row = new Object[size];
            row[0] = brand.getId();
            row[1] = brand.getName();
            data.add(row);
        }
        return data;
    }

    public ArrayList<Brand> getAll() {
        return brandData.getAll();
    }

    public boolean saveBrand(Brand brand) {
        return brandData.add(brand);
    }

    public Brand getById(int brandId) {
        return brandData.get(brandId);
    }

    public boolean updateBrand(Brand brand) {
        if (brandData.get(brand.getId()) != null) {
            return brandData.update(brand);
        } else {
            Helpers.showErrorMessage("Brand not found");
            return false;
        }
    }

    public boolean deleteBrand(Brand brand) {
        if (brandData.get(brand.getId()) != null) {
            return brandData.delete(brand.getId());
        } else {
            Helpers.showErrorMessage("Brand not found");
            return false;
        }
    }
}