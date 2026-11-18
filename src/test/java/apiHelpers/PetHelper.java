package apiHelpers;

import petModels.PetCategory;
import petModels.PetObject;
import petModels.PetResponseData;
import petModels.PetTags;


import static io.restassured.RestAssured.given;

public class PetHelper {
    private final InfoApi info = new InfoApi();
    private final DataGenerator generator = new DataGenerator();


    public PetObject createPet() {
        PetTags tags = new PetTags(1, generator.generateTag());
        PetCategory category = new PetCategory(2, generator.generateCategory());

        return new PetObject(
                1234,
                category,
                generator.generateValidName(),
                "",
                tags,
                generator.generateStatus()
        );
    }

    public PetObject updatedPet(int id) {
        PetTags tags = new PetTags(2, generator.generateTag());
        PetCategory category = new PetCategory(3, generator.generateCategory());

        return new PetObject(
                id,
                category,
                generator.generateValidName(),
                "",
                tags,
                generator.generateStatus()
        );

    }

    public int getIdOfCreatedPet(PetObject pet) {
        PetResponseData response = given()
                .spec(info.getStoreSpec())
                .body(pet)
                .when().post("/pet")
                .then()
                .statusCode(200)
                .extract().as(PetResponseData.class);

        return response.getId();
    }
}
