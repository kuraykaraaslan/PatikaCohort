package Tool.Armor;

import Tool.Tool;

public abstract class Armor extends Tool {
    private final int protection;

    // Constructor to initialize the armor object
    public Armor(String name, int protection, int price) {
        super(name, price); // Call the constructor of the base class (Tool)
        this.protection = protection; // Set the value of the protection property
    }

    // Getter method to retrieve the protection value of the armor
    public int getProtection() {
        return protection;
    }
}
