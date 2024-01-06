import java.lang.*;

// Entities
import Entity.Category;
import Entity.Product;
import Entity.Spec;
import Entity.Store;

// Test Dummy Data
import Test.Test;

//import Screen
import Screen.Screen;

public class Main {
    public static void main(String[] args) {

        // Create a store
        Store store = new Store("PatikaStore", "Patika.dev", "Kadiköy", "İstanbul");

        // Load dummy data
        Test.load(store);

        // Create a screen
        Screen screen = new Screen(store);

        // Show main menu
        screen.mainMenu();


    }
}


