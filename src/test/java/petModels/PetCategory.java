package petModels;

public class PetCategory {
    private int id;
    private String name;

    public PetCategory(){}

    public PetCategory(int id, String nameOfCategory) {
        this.id = id;
        this.name = nameOfCategory;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
