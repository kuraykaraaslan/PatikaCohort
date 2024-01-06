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
            System.out.println("2) List Child Categories");

            if (category.getParentCategory() != null) {
                System.out.println("3) Go Back");
            } else {
                System.out.println("3) Exit");
            }

            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    this.renderProducts(category);
                    break;
                case 2:
                    this.renderChildCategories(category);
                    break;
                case 3:
                    if (category.getParentCategory() != null) {
                        this._singleCategoryMenu(category.getParentCategory());
                    } else {
                        return;
                    }
                    break;
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
            System.out.println("3) Go Back");

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



