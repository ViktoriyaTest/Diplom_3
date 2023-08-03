package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestClient {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String AUTH_URL = "/api/auth/login";
    public static final String DELETE_URL = "/api/auth/user";
    public static final String REGISTER_URL = "/api/auth/register";

    protected static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .build();
    }
}