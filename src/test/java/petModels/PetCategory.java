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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
