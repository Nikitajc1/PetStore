package petModels;

public class PetResponseData {
    private int id;
    private PetCategory category;
    private String name;
    private String[] photoUrls;
    private PetTags[] tags;
    private String status;

    public PetCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public String getStatus() {
        return status;
    }

    public PetTags[] getTags() {
        return tags;
    }

    public int getId() {
        return id;
    }
}
