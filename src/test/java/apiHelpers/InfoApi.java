package apiHelpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class InfoApi {
    private final String urlOfStore = "https://petstore.swagger.io/v2";
    private final RequestSpecification storeSpec;

    public InfoApi() {
        storeSpec = new RequestSpecBuilder()
                .setBaseUri(urlOfStore)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    public String getUrlOfStore() {
        return urlOfStore;
    }

    public RequestSpecification getStoreSpec() {
        return storeSpec;
    }
}
