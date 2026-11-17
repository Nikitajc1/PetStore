package petModels;

public class PetObject {
    private final int id;
    private PetCategory category;
    private String name;
    private String[] photoUrls;
    private String status;
    private PetTags[] tags;

    public PetObject(int id, PetCategory category, String nameOfPet, String urlsOfPhoto, String status, PetTags tags) {
        this.id = id;
        this.category = category;
        this.name = nameOfPet;
        this.photoUrls = new String[]{urlsOfPhoto};
        this.status = status;
        this.tags = new PetTags[]{tags};
    }

    public PetCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public PetTags[] getTags() {
        return tags;
    }

    public int getId() {
        return id;
    }

}
