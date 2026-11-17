package petModels;

public class PetTags {
    private int id;
    private String name;

    public PetTags(){};

    public PetTags(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
