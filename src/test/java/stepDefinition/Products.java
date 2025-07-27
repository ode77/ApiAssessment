package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class Products {
    public RequestSpecification httpRequest;
    public int statusCode;
    public Response response;
    public int ResponseCode;
    public ResponseBody body;
    public String productID;
    public String productNumber;

    @Given("I hit the url of products api endpoint")
    public void i_hit_the_url_of_products_api_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";

    }
    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {
        httpRequest = RestAssured.given();
        response = httpRequest.get("products");
    }
    @Then("I receive response code of {int}")
    public void i_receive_response_code_of(Integer int1) {
        ResponseCode = response.getStatusCode();
        assertThat(ResponseCode,is(equalTo(200)));

    }

    @Then("I verify that the rate of the first product is {string}")
    public void iVerifyThatTheRateOfTheFirstProductIs(String arg0) {
        body = response.getBody();
        String responseBody = body.asString();

        JsonPath jsonPath = response.jsonPath();
        String s = jsonPath.getJsonObject("rating[0].rate").toString();

    }

    @Given("I hit the url of Post products api endpoint")
    public void iHitTheUrlOfPostProductsApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        response = RestAssured.given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("title ", "Boot")
                .formParam("price ", 200)
                .formParam("description ", "Good for everyday outing")
                .formParam("category", "Men's everyday")
                .formParam("image", "http://example.com")
                .when()
                .post(RestAssured.baseURI + "products");
        body = response.getBody();
        String responseBody = body.asString();
        System.out.println(body.asString());
        System.out.println(responseBody);
        JsonPath jsonPath = response.jsonPath();
        productID = jsonPath.getJsonObject("id").toString();

    }

    @And("I pass the request body of product title {string}")
    public void iPassTheRequestBodyOfProductTitle(String title) {
        response = RestAssured.given()
        .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("title ", title)
                .formParam("price ", 200)
                .formParam("description ", "Good for everyday outing")
                .formParam("category", "Men's everyday")
                .formParam("image", "http://example.com")
                .when()
                .post(RestAssured.baseURI + "products");
        body = response.getBody();
        String responseBody = body.asString();
        System.out.println(body.asString());
        System.out.println(responseBody);
        JsonPath jsonPath = response.jsonPath();
        productID = jsonPath.getJsonObject("id").toString();

    }

    @Then("I receive the response body with id as {string}")
    public void iReceiveTheResponseBodyWithIdAs(String id) {
        assertThat(productID,is(equalTo(id)));

    }

    @Given("I hit the url of Put products api endpoint")
    public void iHitTheUrlOfPutProductsApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";

    }

    @When("I pass the url of products in the request with {string}")
    public void iPassTheUrlOfProductsInTheRequestWith(String productNum) {
        httpRequest = RestAssured.given();
        response = httpRequest.put("products"+productNum);
        response = RestAssured.given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("title ", "test new product")
                .formParam("price ", 200)
                .formParam("description ", "Good for everyday outing")
                .formParam("category", "Men's everyday")
                .formParam("image", "http://example.com")
                .when()
                .post(RestAssured.baseURI + "products");
        body = response.getBody();
        String responseBody = body.asString();
        System.out.println(body.asString());
        System.out.println(responseBody);
        JsonPath jsonPath = response.jsonPath();
        productID = jsonPath.getJsonObject("id").toString();

    }

    @Given("I hit the url of Delete products api endpoint")
    public void iHitTheUrlOfDeleteProductsApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";

    }

    @When("I pass the url of delete products in the request with {string}")
    public void iPassTheUrlOfDeleteProductsInTheRequestWith(String productNum) {
        httpRequest = RestAssured.given();
        response = httpRequest.delete("products"+productNum);
        response = RestAssured.given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("title ", "test new product")
                .formParam("price ", 200)
                .formParam("description ", "Good for everyday outing")
                .formParam("category", "Men's everyday")
                .formParam("image", "http://example.com")
                .when()
                .post(RestAssured.baseURI + "products");
        body = response.getBody();
        JsonPath jsonPath = response.jsonPath();
        String s = jsonPath.getJsonObject("id").toString();
        String responseBody = body.asString();
        System.out.println(body.asString());
        System.out.println(responseBody);
    }
}
