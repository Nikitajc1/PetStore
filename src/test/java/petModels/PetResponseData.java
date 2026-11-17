package petModels;

public class PetResponseData {
    private int id;
    private PetCategory category;
    private String name;
    private String[] photoUrls;
    private String status;
    private PetTags[] tags;

    public PetResponseData(){}

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
