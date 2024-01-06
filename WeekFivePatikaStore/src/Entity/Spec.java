package Entity;
import java.util.HashMap;

public class Spec {
    // This is a static variable that will be used to generate unique IDs for each
    private static HashMap<Integer, Spec> specs = new HashMap<Integer, Spec>();

    private int id;
    private Category category;
    private String name;
    private Class<?> type;
    private boolean isRequired;

    private String regexRule;

    public Spec(Category category, String name, Class<?> type) {
        this.category = category;
        this.name = name;
        this.type = type;

        // Add this spec to the static specs HashMap
        this.id = Spec.specs.size() + 1;
        Spec.specs.put(this.id, this);

        // Add this spec to the category
        this.category.addSelfSpec(this);

    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Class<?> getType() {
        return this.type;
    }

    public boolean getIsRequired() {
        return this.isRequired;
    }

    public String getRegexRule() {
        return this.regexRule;
    }

}

