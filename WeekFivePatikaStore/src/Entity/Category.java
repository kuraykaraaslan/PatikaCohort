package Entity;
import java.util.HashMap;

import Entity.Spec;

public class Category {

    // This is a static variable that will be used to generate unique IDs for each
    private static HashMap<Integer, Category> categories = new HashMap<Integer, Category>();

    // Object Based Variables
    private int id;
    private String name;
    private String description;
    private HashMap<Integer, Spec> specs = new HashMap<Integer, Spec>();

    // Relationships
    private Store store;

    // Parent-Child Relationship
    private Category parentCategory;
    private HashMap<Integer, Category> childCategories = new HashMap<Integer, Category>();

    //Products
    private HashMap<Integer, Product> products = new HashMap<Integer, Product>();

    // Constructors
    public Category(String name) {
        this.name = name;
        this.id = Category.categories.size() + 1;
        Category.categories.put(this.id, this);

        // create default specs from the name, description, brand, price, quantity, discount
    }


    public static Category[] getCategories() {
        return Category.categories.values().toArray(new Category[0]);
    }

    public String getName() {
        return this.name;
    }

    public void registerStore(Store store) {
        this.store = store;
        store.addCategory(this);
    }

    public void unregisterStore() {
        this.store = null;
        store.removeCategory(this);
    }

    public void registerStoreWithAllChildCategories(Store store) {
        this.registerStore(store);

        for (Category category : this.childCategories.values()) {
            category.registerStoreWithAllChildCategories(store);
        }
    }

    public void unregisterStoreWithAllChildCategories() {
        this.unregisterStore();

        for (Category category : this.childCategories.values()) {
            category.unregisterStoreWithAllChildCategories();
        }
    }

    // Static Methods
    public static Category getCategoryById(int id) {
        return Category.categories.get(id);
    }

    // Get Specs
    public HashMap<Integer, Spec> getSelfSpecs() {
        return this.specs;
    }

    public int getId() {
        return this.id;
    }

    public HashMap<Integer, Spec> getSpecs() {
        HashMap<Integer, Spec> specs = new HashMap<Integer, Spec>();
        specs.putAll(this.specs);

        if (this.parentCategory != null) {
            specs.putAll(this.parentCategory.getSpecs());
        }

        return specs;
    }

    // Add Specs
    public void addSelfSpec(Spec spec) {
        this.specs.put(spec.getId(), spec);
    }

    // Remove Specs
    public void removeSelfSpec(Spec spec) {
        this.specs.remove(spec.getId());
    }

    // Has Spec
    public boolean hasSelfSpec(Spec spec) {
        return this.specs.containsKey(spec.getId());
    }



    // Get Parent Category
    public Category getParentCategory() {
        return this.parentCategory;
    }

    // Set Parent Category
    public void setParentCategory(Category category) {
        this.parentCategory = category;
    }

    // Remove Parent Category
    public void removeParentCategory() {
        this.parentCategory = null;

        //Remove this category from the parent category's child categories
        this.parentCategory.removeChildCategory(this);
    
    }

    // Remove Child Category
    public void removeChildCategory(Category category) {
        this.childCategories.remove(category.getId());
    }

    // Add Child Category
    public void addChildCategory(Category category) {
        // check if the category is already a parent category
        if (category.getParentCategory() != null) {
            System.out.println("This category is already a child category of another category.");
            return;
        }

        // add the category to the child categories
        this.childCategories.put(category.getId(), category);
        // set the parent category of the category
        category.setParentCategory(this);


    }

    // Get Child Categories
    public HashMap<Integer, Category> getChildCategories() {
        return this.childCategories;
    }

    // Get All Child Categories
    public HashMap<Integer, Category> getAllChildCategories() {
        HashMap<Integer, Category> childCategories = new HashMap<Integer, Category>();
        childCategories.putAll(this.childCategories);

        for (Category category : this.childCategories.values()) {
            childCategories.putAll(category.getAllChildCategories());
        }

        return childCategories;
    }

    // Register Product
    public void registerProduct(Product product) {
        // TODO: check if the product has all the required specs

        // add the product to the products
        this.products.put(product.getId(), product);

        // Set the category of the product
        product.setCategory(this);

    }

    // Unregister Product
    public void unregisterProduct(Product product) {
        // remove the product from the products
        this.products.remove(product.getId());

        // Remove the category of the product
        product.removeCategory();
    }

    // Get Products self
    public HashMap<Integer, Product> getSelfProducts() {
        return this.products;
    }

    // Get Products
    public HashMap<Integer, Product> getProducts() {
        HashMap<Integer, Product> products = new HashMap<Integer, Product>();
        products.putAll(this.products);

        for (Category category : this.childCategories.values()) {
            products.putAll(category.getProducts());
        }

        return products;
    }


    // Print Products
    public void printProducts() {
        System.out.println("Category: " + this.name);
        System.out.println("\n--- Products ---");
        for (Product product : this.products.values()) {
            System.out.println("Product: " + product.getName());
        }

    }

    public HashMap<Integer, Product> getAllProducts() {
        HashMap<Integer, Product> products = new HashMap<Integer, Product>();
        products.putAll(this.products);

        for (Category category : this.childCategories.values()) {
            products.putAll(category.getAllProducts());
        }

        return products;
    }

    public HashMap<Integer, Spec> getAllSpecs() {
        HashMap<Integer, Spec> specs = new HashMap<Integer, Spec>();
        specs.putAll(this.specs);

        if (this.parentCategory != null) {
            specs.putAll(this.parentCategory.getAllSpecs());
        }

        return specs;
    }

    public void addProduct(Product product) {
        // check if the product has all the required specs
        for (Spec spec : this.getAllSpecs().values()) {
            if (!product.hasSpec(spec)) {
                System.out.println("Product does not have the required spec: " + spec.getName());
                return;
            }
        }

        // add the product to the products
        this.products.put(product.getId(), product);

        // Set the category of the product
        product.setCategory(this);
    }

}


