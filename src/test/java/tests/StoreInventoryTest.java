package tests;

import apiHelpers.ApiConfig;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class StoreInventoryTest {
    private final ApiConfig info = new ApiConfig();

    @DisplayName("Проверяем инвентарь")
    @Description("Проверка на наличие основных статусов")
    @Test
    void checkInventory() {
        given()
                .spec(info.getStoreSpec())
                .when().get("/store/inventory")
                .then()
                .statusCode(200)
                .body("string", notNullValue())
                .body("sold", notNullValue());
    }
}
