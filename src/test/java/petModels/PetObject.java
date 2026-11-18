package petModels;

public class PetObject {
    private final int id;
    private final PetCategory category;
    private final String name;
    private final String[] photoUrls;
    private final PetTags[] tags;
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
