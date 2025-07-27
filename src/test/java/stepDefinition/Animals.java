package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.specification.RequestSpecification;

public class Animals {

    public RequestSpecification httpRequest;
    public Response response;
    public ResponseBody body;
    public String accessToken;
    public String types;
    public String unauthorizedtitle;

    @Given("I am an authenticated user")
    public void i_am_an_authenticated_user() {
        RestAssured.baseURI = "https://api.petfinder.com/v2";
        response = RestAssured.given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", "7QWvZjFB97n20LEx7Wbum6s1eARs5fZ4GoShELeN9Dx5Ni5eUm")
                .formParam("client_secret", "6WMjrTmJaplHEmhXcAF63oWtWPXCGuYvGDJlB8vi")
                .when()
                .post(RestAssured.baseURI + "/oauth2/token");
        body = response.getBody();

        String responseBody = body.asString();

        System.out.println(body.asString());
        System.out.println(responseBody);

        JsonPath jsonPath = response.jsonPath();
        accessToken = jsonPath.getJsonObject("access_token").toString();

    }
    @When("I hit the get animal api url")
    public void i_hit_the_get_animal_api_url() {
        response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get(RestAssured.baseURI + "/types");
        JsonPath jsonPath2 = response.jsonPath();

        types = jsonPath2.getJsonObject("types.name[0]").toString();
        System.out.println(types);

    }
    @Then("I get {int} as the response code")
    public void i_get_as_the_response_code(Integer int1) {
        int expectedResponseCode = response.statusCode();
        assertThat(expectedResponseCode,is(equalTo(200)));

    }

    @Then("I get animal in the response body of the api")
    public void iGetAnimalInTheResponseBodyOfTheApi() {
        assertThat(types,is(equalTo("Dog")));

    }

    @Given("I am an unauthenticated user")
    public void iAmAnUnauthenticatedUser() {
        RestAssured.baseURI = "https://api.petfinder.com/v2";
        response = RestAssured.given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .when()
                .post(RestAssured.baseURI + "/oauth2/token");
        body = response.getBody();

    }

    @Then("I should get {int} as the response code")
    public void iGetAsTheresponseCode(int arg0) {
        int expectedResponseCode = response.statusCode();
        assertThat(expectedResponseCode,is(equalTo(400)));

    }

    @Given("I hit the get animal api url without access code")
    public void iHitTheGetAnimalApiUrlWithoutAccessCode() {
        response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get(RestAssured.baseURI + "/types");
        JsonPath jsonPath = response.jsonPath();
        unauthorizedtitle = jsonPath.getJsonObject("title").toString();
    }

    @Then("I get unauthorized response code of {int} the server")
    public void iGetUnauthorizedResponseCodeOfTheServer(int arg0) {
        assertThat(unauthorizedtitle,is(equalTo("Unauthorized")));
    }
}
