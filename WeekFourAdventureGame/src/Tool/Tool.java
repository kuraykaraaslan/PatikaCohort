// This code is for a Tool class that is part of the Tool package

package Tool;

public abstract class Tool {
    private final String name; // Declaring a private final variable "name" of type String
    private final int price; // Declaring a private final variable "price" of type int

    protected Tool(String name, int price) {
        this.name = name; // Assigning the name parameter to the name variable
        this.price = price; // Assigning the price parameter to the price variable
    }

    public String getName() {
        return name; // Returning the value of the name variable
    }

    public int getPrice() {
        return price; // Returning the value of the price variable
    }
}
