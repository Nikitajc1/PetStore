package tests;

import apiHelpers.ApiConfig;
import apiHelpers.PetHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import petModels.PetObject;
import petModels.PetResponseData;
import petModels.PetTags;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Pet tests")
@Feature("API of pets")
public class PetTest {
    private final ApiConfig info = new ApiConfig();
    private final PetHelper help = new PetHelper();
    private Integer petId;
    private PetObject pet;

    @BeforeEach
    void createPet() {
        pet = help.createPet();
        petId = help.getIdOfCreatedPet(pet);
    }

    @AfterEach
    void clean() {
        if (petId != null) {
            given()
                    .baseUri(info.getUrlOfStore())
                    .when().delete("/pet/" + petId)
                    .then()
                    .statusCode(200);
        }
    }

    @DisplayName("Проверяем id созданного питомца")
    @Description("Проверка, что id и данные питомца отобразились в api")
    @Test
    void checkIdOfPet() {

        PetResponseData response = given()
                .baseUri(info.getUrlOfStore())
                .when().get("/pet/" + petId)
                .then()
                .statusCode(200)
                .body(
                        matchesJsonSchemaInClasspath(
                                "schemas/pet-schema.json"))
                .extract().as(PetResponseData.class);

        PetTags[] tags = response.getTags();
        assertNotNull(tags);
        assertTrue(tags.length > 0);

        assertAll(
                () -> assertEquals(response.getId(), petId),
                () -> assertNotNull(response.getName()),
                () -> assertEquals(pet.getName(), response.getName()),
                () -> assertNotNull(tags[0].getName()),
                () -> assertEquals(pet.getTags()[0].getName(), tags[0].getName()),
                () -> assertEquals(pet.getTags()[0].getId(), tags[0].getId()),
                () -> assertNotNull(response.getCategory()),
                () -> assertEquals(pet.getCategory().getName(), response.getCategory().getName())
        );
    }

    @DisplayName("Проверяем PUT питомца")
    @Description("Сначала создаем нового питомца, заменяем данные и сверяем")
    @Test
    void updatePet() {
        PetObject updatedPet = help.updatedPet(petId);

        PetResponseData response = given()
                .baseUri(info.getUrlOfStore())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(updatedPet)
                .when().put("/pet")
                .then()
                .statusCode(200)
                .body(
                        matchesJsonSchemaInClasspath(
                                "schemas/pet-schema.json"))
                .extract().as(PetResponseData.class);

        assertAll(
                () -> assertEquals(petId, response.getId()),
                () -> assertNotNull(response.getName()),
                () -> assertNotEquals(pet.getName(), response.getName()),
                () -> assertNotEquals(pet.getTags()[0].getName(), response.getTags()[0].getName()),
                () -> assertNotEquals(pet.getCategory().getName(),
                        response.getCategory().getName())
        );

    }

    @DisplayName("Удаление питомца")
    @Description("Проверяем, что питомца действительно нет в списке")
    @Test
    void deletePet() {
        int deletedId = petId;

        given()
                .baseUri(info.getUrlOfStore())
                .when().delete("/pet/" + deletedId)
                .then()
                .statusCode(200);

        petId = null;

        given()
                .baseUri(info.getUrlOfStore())
                .when().get("/pet/" + deletedId)
                .then()
                .statusCode(404);
    }

    @DisplayName("Проверка на создание с невалидным полем")
    @Description("Проверяем поле id")
    @Test
    void checkNonValidPet() {
        given()
                .spec(info.getStoreSpec())
                .body("""
                        {
                        "id": "asd"
                        }
                        """)
                .when().post("/pet")
                .then()
                .statusCode(500)
                .body("message", equalTo("something bad happened"));

    }



}
