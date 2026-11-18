package petModels;

public class PetObject {
    private final int id;
    private PetCategory category;
    private String name;
    private String[] photoUrls;
    private PetTags[] tags;
    private final String status;

    public PetObject(int id, PetCategory category, String nameOfPet, String urlsOfPhoto, PetTags tags, String status) {
        this.id = id;
        this.category = category;
        this.name = nameOfPet;
        this.photoUrls = new String[]{urlsOfPhoto};
        this.tags = new PetTags[]{tags};
        this.status = status;
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

    public String getStatus() {
        return status;
    }
}
