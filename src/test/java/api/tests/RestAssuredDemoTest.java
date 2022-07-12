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

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static io.restassured.RestAssured.*;

public class RestAssuredDemoTest {
    String accessToken;
    String username;
    SecureRandom random;
    int userId;

    @BeforeTest
    public void setup() {
        baseURI = "http://training.skillo-bg.com:3100/";
        random = new SecureRandom();
    }

    @Parameters({"password"})
    @Test(groups = "signup")
    public void testSignUp(@Optional("dani123") String password) {
        username = "auto_" + String.valueOf(random.nextInt(100000, 999999));
        JSONObject body = new JSONObject();
        body.put("username", username);
        body.put("birthDate", "17.07.1982");
        body.put("email", username + "@test.com");
        body.put("password", password);
        body.put("publicInfo", "something here");

        Response response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/users")
                .then().log().all()
                .extract().response();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
        userId = response.jsonPath().get("id");
        Assert.assertTrue(userId != 0);

    }

    /*@Test(dependsOnGroups = "signup")*/
    @Test(dependsOnMethods = {"testSignUp", "testLogin"})
    public void testPasswordUpdate() {
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

    @Parameters({"password"})
    @Test(groups = "signup",dependsOnMethods = "testSignUp")
    public void testLogin(@Optional("dani123") String password) {

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
        String usernameFromResponse = response.jsonPath().get("user.username");
        Assert.assertEquals(usernameFromResponse, username);
        int userIdFromResponse = response.jsonPath().get("user.id");
        Assert.assertEquals(userIdFromResponse, userId);
        String token = response.jsonPath().get("token");
        accessToken = "Bearer " + token;
    }

    @Test(dependsOnGroups = "signup")
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

    @Test(dependsOnGroups = "signup")
    public void testLogout() {
        Response response = given()
                .log().all()
                .header("Authorization", accessToken)
                .when()
                .delete("/users/logout")
                .then()
                .log()
                .all()
                .extract()
                .response();

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
        Assert.assertEquals(response.jsonPath().get("msg"),"User successfully logged out.");
    }

    @Test
    public void testGetPosts() {
        int numberOfPosts = 3;
        int numberOfSkippedPosts = 3;
        Response response = given()
                .queryParam("take", numberOfPosts)
                .queryParam("skip", numberOfSkippedPosts)
                .log().all()
                .when()
                .get("/posts")
                .then()
                .log()
                .all()
                .extract()
                .response();

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
        List<LinkedHashMap <Object, Object>> posts = response.jsonPath().get();
        Assert.assertEquals(posts.size(), numberOfPosts);
        posts.forEach(post ->{
            Assert.assertTrue(post.get("postStatus").toString().contentEquals("private") ||
                    post.get("postStatus").toString().contentEquals("public") );
        });
    }

    @Test(dependsOnGroups = "signup")
    public void testCreatPublicPost() {
        String caption = "wine";
        String coverUrl = "https://i.imgur.com/duYnaoX.jpg";
        String postStatus = "public";

        JSONObject body = new JSONObject();
        body.put("caption", caption);
        body.put("coverUrl", coverUrl);
        body.put("postStatus", postStatus);
        Response response = given()
                .log().all()
                .header("Authorization", accessToken)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post("/posts")
                .then()
                .log()
                .all()
                .extract()
                .response();

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, HttpStatus.SC_CREATED);
        Assert.assertNotNull(response.jsonPath().get("id"));
        Assert.assertEquals(response.jsonPath().get("postStatus"), postStatus);
        Assert.assertEquals(response.jsonPath().get("coverUrl"), coverUrl);
        Assert.assertEquals(response.jsonPath().get("caption"), caption);
        Assert.assertEquals(response.jsonPath().get("user.username"), username);
    }



}
