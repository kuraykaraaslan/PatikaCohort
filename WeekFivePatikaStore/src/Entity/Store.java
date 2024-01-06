package Entity;
import java.util.ArrayList;
import java.util.HashMap;

import Entity.Product;

public class Store {

    private String name;
    private String address;
    private String city;
    private String county;

    private HashMap<Integer, Category> categories = new HashMap<Integer, Category>();

    public Store(String name, String address, String city, String county) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.county = county;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public void addCategory(Category category) {
        this.categories.put(category.getId(), category);
    }

    public void removeCategory(Category category) {
        this.categories.remove(category.getId());
    }

    public HashMap<Integer, Category> getCategories() {
        // return only the categories has no parent category
        HashMap<Integer, Category> categories = new HashMap<Integer, Category>();

        for (Category category : this.categories.values()) {
            if (category.getParentCategory() == null) {
                categories.put(category.getId(), category);
            }
        }

        return categories;

    }

    public HashMap<Integer, Category> getAllCategoriesWithChildCategories() {
        // return all categories with child categories
        HashMap<Integer, Category> categories = new HashMap<Integer, Category>();

        for (Category category : this.categories.values()) {
            categories.put(category.getId(), category);
            categories.putAll(category.getChildCategories());
        }

        return categories;
    }

    public HashMap<Integer, Category> getAllCategories() {
        // categories but with parent categories
        HashMap<Integer, Category> categories = new HashMap<Integer, Category>();

        for (Category category : this.categories.values()) {
            if (category.getParentCategory() == null) {
                categories.put(category.getId(), category);
            }
        }

        return categories;

    }
    
    // get all products
    public HashMap<Integer, Product> getAllProducts() {
        HashMap<Integer, Product> products = new HashMap<Integer, Product>();

        for (Category category : this.categories.values()) {
            products.putAll(category.getProducts());
        }

        return products;
    }
}