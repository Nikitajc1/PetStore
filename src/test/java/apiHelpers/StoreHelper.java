package apiHelpers;

import io.restassured.specification.RequestSpecification;
import storeModels.OrderObject;
import java.time.OffsetDateTime;
import static io.restassured.RestAssured.given;

public class StoreHelper {
    private final ApiConfig info = new ApiConfig();
    private final DataGenerator data = new DataGenerator();

    public OrderObject newOrder(){
        return new OrderObject(
                data.generateOrderId(),
                2,
                2,
                OffsetDateTime.now().toString(),
                data.generateOrderStatus(),
                true
        );
    }

    public RequestSpecification fakeBody() {
        return given()
                .spec(info.getStoreSpec())
                .body("""
                        {
                        "id": "asd",
                        "petId": 123,
                        "quantity": 1,
                        "shipDate": "asd",
                        "status": "asd",
                        "complete": "true"
                        }
                        """);
    }

    public int getIdOfCreatedOrder(OrderObject order) {
        OrderObject response = given()
                .spec(info.getStoreSpec())
                .body(order)
                .when().post("/store/order")
                .then()
                .statusCode(200)
                .extract().as(OrderObject.class);

        return response.getId();
    }
}
