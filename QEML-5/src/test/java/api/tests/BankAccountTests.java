package api.tests;

import api.responseprovider.BankAccountResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static utilities.ResponseSpec.getResponseSpecification;


public class BankAccountTests {

    @Test(groups = {"positive"})
    public void getBankAccountWithValidId() {
        Response response = BankAccountResponse.getBankAccountResponseByID("1");
        response.then()
                .spec(getResponseSpecification(200))
                .body("balance", equalTo(5211.44F));
    }
}