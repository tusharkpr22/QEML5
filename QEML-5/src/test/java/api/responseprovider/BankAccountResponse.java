package api.responseprovider;

import io.restassured.response.Response;
import utilities.SpecBuilder;

import static io.restassured.RestAssured.given;

public class BankAccountResponse {


    public static Response getBankAccountResponseByID(String id){
        return given()
                .spec(SpecBuilder.getRequestSpecification("bank-accounts", id))
                .when()
                .get();
    }

}
