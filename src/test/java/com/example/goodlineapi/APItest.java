package com.example.goodlineapi;

import io.qameta.allure.internal.shadowed.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;

public class APItest {
    private final static String URL = "https://petstore.swagger.io/v2";

    @Test
    public void createPet(){
        Map<String, String> pet = new HashMap<>();
        pet.put("id", "138");
        pet.put("Name", "Terry");
        given()
                .body(pet)
                .when()
                .post(URL + "/pet")
                .body("id", equalTo(138))
                .body("Name", equalTo("Terry"))
                .extract().responce();
        JsonPath jsonPath = responce.jsonPath();
        int id = jsonPath.get("id");
        String Name = jsonPath.get("Name");
        Assert.assertEquals(138, id);
        Assert.assertEquals("Terry", Name);

    }
    @Test
    public void getPetById() {
        Response response = RestAssured.get("https://petstore.swagger.io/v2/pet/138");
        System.out.println("Response: " + response.asString());
    }

    @Test
    public void updatePet() {

    }

    @Test
    public void deletePet(){

    }
}
