package tests;

import apiHelpers.InfoApi;
import apiHelpers.StoreHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import storeModels.OrderObject;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

@Epic("Checking store")
public class StoreTest {
    private final InfoApi info = new InfoApi();
    private final StoreHelper storeHelper = new StoreHelper();
    private Integer orderId;
    private OrderObject order;

    @BeforeEach
    void createOrder() {
        order = storeHelper.newOrder();
        orderId = storeHelper.getIdOfCreatedOrder(order);
    }

    @AfterEach
    void clear() {
        if (orderId != null) {
            given()
                    .spec(info.getStoreSpec())
                    .when().delete("/store/order/" + orderId)
                    .then()
                    .statusCode(200);
        }
    }

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

    @DisplayName("Проверка заказа по id")
    @Description("Создаём заказ, затем проверяем его поля на соответствие")
    @Test
    void checkOrderId() {
        given()
                .spec(info.getStoreSpec())
                .when().get("/store/order/" + orderId)
                .then()
                .statusCode(200)
                .body(
                        matchesJsonSchemaInClasspath(
                                "schemas/order-schema.json"))
                .body("id" , equalTo(order.getId()))
                .body("petId", equalTo(order.getPetId()))
                .body("quantity", equalTo(order.getQuantity()));
    }

    @DisplayName("Создаём фейковый заказ")
    @Description("Заказ с некорректным body, проверяем на статус код и message")
    @Test
    void createFakeOrder() {
        storeHelper.fakeBody()
                .when().post("/store/order")
                .then()
                .log().all()
                .statusCode(500)
                .body("message", equalTo("something bad happened"));
    }
}
