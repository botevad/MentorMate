package api.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static io.restassured.RestAssured.*;

public class RestAssuredDemoTest {
    String accessToken;

    @BeforeTest
    public void setup() {
        baseURI = "http://training.skillo-bg.com:3100/";
    }

    @Test(dependsOnMethods = "testLogin")
    public void testPasswordUpdate(){
        String newPassword = "dani1234";
        JSONObject passwordUpdate = new JSONObject();
        passwordUpdate.put("username", "danibot");
        passwordUpdate.put("email", "danifeya@gmail.com");
        passwordUpdate.put("birthDate", "17.07.1982");
        passwordUpdate.put("password", newPassword);
        passwordUpdate.put("publicInfo", "new public info");
        passwordUpdate.put("profilePicUrl", "https://i.imgur.com/u62Rlx8.jpg");

        Response response = given().contentType(ContentType.JSON)
                .log().all()
                //.header("Content-Type", "application/json")
                .header("Authorization", accessToken)
                .body(passwordUpdate)
                .when()
                .put("/users")
                .then()
                .log()
                .all()
                .extract()
                .response();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(response.jsonPath().get("user.password"), newPassword);

    }

    @Parameters({"username", "password"})
    @Test
    public void testLogin(@Optional("danibot") String username, @Optional("dani123") String password) {

        JSONObject object = new JSONObject();
        object.put("usernameOrEmail", username);
        object.put("password", password);
        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(object)
                .when()
                .post("/users/login")
                .then()
                .log()
                .all()
                .extract()
                .response();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, HttpStatus.SC_CREATED);
        String token = response.jsonPath().get("token");
        accessToken = "Bearer " + token;
    }

    @Test(dependsOnMethods = "testLogin")
    public void testListAllUsers() {
        Response response = given()
                .log().all()
                .header("Authorization", accessToken)
                .when()
                .get("/users")
                .then()
                .log()
                .all()
                .extract()
                .response();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

        ArrayList<Object> listOfUsers = response.jsonPath().get();
        Assert.assertFalse(listOfUsers.isEmpty());

/*   listOfUsers.forEach(user ->
           {
               LinkedHashMap userObject = (LinkedHashMap) user;
               System.out.println(userObject.get("email"));

           });*/
    }
}
