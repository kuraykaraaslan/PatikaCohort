package Screen;

import java.util.Scanner;

import Entity.Category;
import Entity.Product;
import Entity.Spec;

import Entity.Store;

import java.util.HashMap;

public class Screen {

    private Store store;

    public Screen(Store store) {
        this.store = store;
    }

    public static void clrscr() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        // wait(1);
    }

    public static void clrscr(int seconds) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        wait(seconds);
    }

    public static void wait(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void render() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("Welcome to " + this.store.getName());
        System.out.println("--------------------");

        while (true) {
            System.out.println("1) Categories");
            System.out.println("2) Products");
            System.out.println("3) Exit");

            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    this.renderCategoriesMenu();
                    break;
                case 2:
                    this.renderProductsMenu();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }

    }

    public void singleCategoryMenu(Category category) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------");
            System.out.println(category.getName());
            System.out.println("--------------------");

            System.out.println("1) List All Products");
            System.out.println("2) Add Product");
            System.out.println("3) Go Back");

            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    this.renderProductsList(category);
                    break;
                case 2:
                    this.renderAddProduct(category);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid selection");
                    break;
            }

        }

    }


    // This is a private method that will be used to render the single category menu
    public void renderCategoriesMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1) List Categories");
            System.out.println("2) Add Category");

            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    this.renderCategoriesList();
                    break;
                case 2:
                    this.renderAddCategory();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }

    }

    // renderCategoriesList
    public void renderCategoriesList() {

        Scanner scanner = new Scanner(System.in);

        // get all categories
        HashMap<Integer, Category> categories = this.store.getAllCategories();
        

        while (true) {
            System.out.println("--------------------");
            System.out.println("Categories");
            System.out.println("--------------------");

            for (Category category : categories.values()) {
                System.out.println(category.getId() + ") " + category.getName());
            }

            System.out.println("--------------------");

            System.out.println("Select Category: (0 to go back)");

            int selection = scanner.nextInt();

            if (selection == 0) {
                return;
            }

            Category category = categories.get(selection);

            if (category == null) {
                System.out.println("Invalid selection");
                continue;
            }

            this.singleCategoryMenu(category);

        }

    }

    // renderAddCategory
    public void renderAddCategory() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("Add Category");
        System.out.println("--------------------");

        System.out.println("Enter Category Name: ");

        String name = scanner.nextLine();

        Category category = new Category(name);

        this.store.addCategory(category);

        System.out.println("Category added successfully");

    }

    
    // renderProductsList
    public void renderProductsList(Category category) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------");
            System.out.println(category.getName());
            System.out.println("--------------------");

            HashMap<Integer, Product> products = category.getAllProducts();

            for (Product product : products.values()) {
                System.out.println(product.getId() + ") " + product.getName());
            }

            System.out.println("--------------------");

            System.out.println("Select Product: (0 to go back)");

            int selection = scanner.nextInt();

            if (selection == 0) {
                return;
            }

            Product product = products.get(selection);

            if (product == null) {
                System.out.println("Invalid selection");
                continue;
            }

            this.singleProductMenu(product);

        }

    }

    // renderAddProduct
    public void renderAddProduct(Category category) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("Add Product");
        System.out.println("--------------------");

        System.out.println("Enter Product Title: ");

        String title = scanner.nextLine();

        Product product = new Product(title);

        System.out.println("Enter Product Brand: ");

        String brand = scanner.nextLine();

        product.setBrand(brand);

        System.out.println("Enter Product Price: ");

        double price = scanner.nextDouble();

        product.setPrice(price);

        System.out.println("Enter Product Quantity: ");

        int quantity = scanner.nextInt();

        product.setQuantity(quantity);

        HashMap<Integer, Spec> specs = category.getAllSpecs();

        for (Spec spec : specs.values()) {

            System.out.println("Enter " + spec.getName() + " (" + spec.getType().getSimpleName() + ")");

            if (spec.getType().getSimpleName().equals("String")) {
                String value = scanner.next();
                product.createSpecValues(spec, value);
            } else if (spec.getType().getSimpleName().equals("Integer")) {
                int value = scanner.nextInt();
                product.createSpecValues(spec, value);
            } else if (spec.getType().getSimpleName().equals("Double")) {
                double value = scanner.nextDouble();
                product.createSpecValues(spec, value);
            }

        }

        category.addProduct(product);

        System.out.println("Product added successfully");

    }

    // renderProductsMenu
    public void renderProductsMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1) List Products");
            System.out.println("2) Add Product");

            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    this.renderProductsList();
                    break;
                case 2:
                    this.renderAddProduct();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }

    }

    // renderProductsList
    public void renderProductsList() {

        Scanner scanner = new Scanner(System.in);

        // get all categories
        HashMap<Integer, Category> categories = this.store.getAllCategories();

        while (true) {
            System.out.println("--------------------");
            System.out.println("Products");
            System.out.println("--------------------");

            for (Category category : categories.values()) {
                System.out.println(category.getId() + ") " + category.getName());
            }

            System.out.println("--------------------");

            System.out.println("Select Category: (0 to go back)");

            int selection = scanner.nextInt();

            if (selection == 0) {
                return;
            }

            Category category = categories.get(selection);

            if (category == null) {
                System.out.println("Invalid selection");
                continue;
            }

            this.renderProductsList(category);

        }

    }

    // renderAddProduct
    public void renderAddProduct() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("Add Product");
        System.out.println("--------------------");

        System.out.println("Enter Product Title: ");

        String title = scanner.nextLine();

        Product product = new Product(title);

        System.out.println("Enter Product Brand: ");

        String brand = scanner.nextLine();

        product.setBrand(brand);

        System.out.println("Enter Product Price: ");

        double price = scanner.nextDouble();

        product.setPrice(price);

        System.out.println("Enter Product Quantity: ");

        int quantity = scanner.nextInt();

        product.setQuantity(quantity);

        HashMap<Integer, Category> categories = this.store.getAllCategories();

        while (true) {
            System.out.println("--------------------");
            System.out.println("Categories");
            System.out.println("--------------------");

            for (Category category : categories.values()) {
                System.out.println(category.getId() + ") " + category.getName());
            }

            System.out.println("--------------------");

            System.out.println("Select Category: (0 to go back)");

            int selection = scanner.nextInt();

            if (selection == 0) {
                return;
            }

            Category category = categories.get(selection);

            if (category == null) {
                System.out.println("Invalid selection");
                continue;
            }

            HashMap<Integer, Spec> specs = category.getAllSpecs();

            for (Spec spec : specs.values()) {

                System.out.println("Enter " + spec.getName() + " (" + spec.getType().getSimpleName() + ")");

                if (spec.getType().getSimpleName().equals("String")) {
                    String value = scanner.next();
                    product.createSpecValues(spec, value);
                } else if (spec.getType().getSimpleName().equals("Integer")) {
                    int value = scanner.nextInt();
                    product.createSpecValues(spec, value);
                } else if (spec.getType().getSimpleName().equals("Double")) {
                    double value = scanner.nextDouble();
                    product.createSpecValues(spec, value);
                }

            }

            category.addProduct(product);

            System.out.println("Product added successfully");

            return;

        }

    }

    // singleProductMenu
    public void singleProductMenu(Product product) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------");
            System.out.println(product.getName());
            System.out.println("--------------------");

            System.out.println("1) List Specs");
            System.out.println("2) Add Spec");
            System.out.println("3) Go Back");

            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    this.renderSpecsList(product);
                    break;
                case 2:
                    this.renderAddSpec(product);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid selection");
                    break;
            }

        }

    }

    // renderSpecsList
    public void renderSpecsList(Product product) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------");
            System.out.println(product.getName());
            System.out.println("--------------------");

            HashMap<Integer, Spec> specs = product.getAllSpecs();

            for (Spec spec : specs.values()) {
                System.out.println(spec.getId() + ") " + spec.getName() + " (" + spec.getType().getSimpleName() + ")");
            }

            System.out.println("--------------------");

            System.out.println("Select Spec: (0 to go back)");

            int selection = scanner.nextInt();

            if (selection == 0) {
                return;
            }

            Spec spec = specs.get(selection);

            if (spec == null) {
                System.out.println("Invalid selection");
                continue;
            }

            this.singleSpecMenu(spec);

        }

    }

    // renderAddSpec
    public void renderAddSpec(Product product) {
            
            Scanner scanner = new Scanner(System.in);
    
            System.out.println("--------------------");
            System.out.println("Add Spec");
            System.out.println("--------------------");
    
            System.out.println("Enter Spec Name: ");
    
            String name = scanner.nextLine();
    
            System.out.println("Enter Spec Type (String, Integer, Double): ");
    
            while (true) {
                String type = scanner.nextLine();
    
                if (type.equals("String")) {
                    Spec spec = new Spec(product.getCategory(), name, String.class);
                    System.out.println("Spec added successfully");
                    return;
                } else if (type.equals("Integer")) {
                    Spec spec = new Spec(product.getCategory(), name, Integer.class);
                    System.out.println("Spec added successfully");
                    return;
                } else if (type.equals("Double")) {
                    Spec spec = new Spec(product.getCategory(), name, Double.class);
                    System.out.println("Spec added successfully");
                    return;
                } else {
                    System.out.println("Invalid type");
                }
            }

    }

    // singleSpecMenu
    public void singleSpecMenu(Spec spec) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------");
            System.out.println(spec.getName());
            System.out.println("--------------------");

            System.out.println("1) Edit Spec");
            System.out.println("2) Delete Spec");
            System.out.println("3) Go Back");

            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    this.renderEditSpec(spec);
                    break;
                case 2:
                    this.renderDeleteSpec(spec);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid selection");
                    break;
            }

        }

    }


    // renderEditSpec
    public void renderEditSpec(Spec spec) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("Edit Spec");
        System.out.println("--------------------");

        System.out.println("Enter Spec Name: ");

        String name = scanner.nextLine();

        System.out.println("Enter Spec Type (String, Integer, Double): (0 to go back)");

        while (true) {
            String type = scanner.nextLine();

            if (type.equals("String")) {
                spec.setName(name);
                spec.setType(String.class);
                System.out.println("Spec edited successfully");
                return;
            } else if (type.equals("Integer")) {
                spec.setName(name);
                spec.setType(Integer.class);
                System.out.println("Spec edited successfully");
                return;
            } else if (type.equals("Double")) {
                spec.setName(name);
                spec.setType(Double.class);
                System.out.println("Spec edited successfully");
                return;
            } else if (type.equals("0")) {
                return;
            } else {
                System.out.println("Invalid type");
            }
        }

    }

    // renderDeleteSpec
    public void renderDeleteSpec(Spec spec) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("Delete Spec");
        System.out.println("--------------------");

        System.out.println("Are you sure you want to delete this spec? (y/n)");

        String selection = scanner.nextLine();

        if (selection.equals("y")) {
            spec.cleanFromAllProducts();
            spec.getCategory().removeSpec(spec);
            System.out.println("Spec deleted successfully");
        } else {
            System.out.println("Spec not deleted");
        }

    }
    

}



