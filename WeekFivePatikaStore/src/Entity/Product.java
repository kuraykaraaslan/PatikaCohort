package Entity;
import java.util.HashMap;

public class Product {
    private static int nextId = 1;
    private int id;

    private String name;
    private String description;

    private String brand;

    private double price;
    private int quantity;

    private double discount;

    private Category category;

    private HashMap<Spec, Object> specValues = new HashMap<Spec, Object>();

    public Product(String name)
    {
        this.name = name;
        this.id = Product.nextId;
        Product.nextId++;
    }

    public void createSpecValues(Spec spec, Object value)
    {
        // get spec value type
        Class<?> specValueType = spec.getType();

        // check if value is instance of spec value type
        if (value.getClass() != specValueType) {
            System.out.println("Spec value type and given value type does not match for spec: " + spec.getName());
            System.out.println("product: " + this.name);
            System.out.println("Expected type: " + specValueType.getName());
            System.out.println("Given type: " + value.getClass().getName());
            return;
        }

        // check if value is valid for regex rule
        if (spec.getRegexRule() != null) {
            // TODO: check if value is valid for regex rule
        }
        

        // Create spec value
        this.specValues.put(spec, value);
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public Category getCategory()
    {
        return this.category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public void removeCategory()
    {
        this.category = null;
    }

}
        



