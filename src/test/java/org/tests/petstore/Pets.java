package org.tests.petstore;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import org.tests.petstore.model.PetStatus;
import org.tests.petstore.model.request.builders.CategoryBuilder;
import org.tests.petstore.model.request.builders.PetRequestBuilder;
import org.tests.petstore.model.request.builders.TagBuilder;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class Pets {

    private static final String PET_URL =  "https://petstore.swagger.io/v2/pet";


    String petRequestString = new PetRequestBuilder()
            .setId(1L)
            .setCategory(new CategoryBuilder().setID(1L).setName("Puppy").build())
            .setName("Azor")
            .addPhoto("/MyPhotos/Azor1.jpg")
            .addTag(new TagBuilder().setID(1L).setName("Cute").build())
            .setStatus(PetStatus.available)
            .buildJsonString();

    @Test
    public void addNewPet() {
        given()
                .header("Content-Type", "application/json")
                .body(petRequestString)
                .when()
                .post(PET_URL)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void uploadPhoto() {
        File photoFile;

        try {
            URI photoUri = this.getClass().getResource("../../../testData/pet.jpg").toURI();
            photoFile = new File(photoUri);
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        given()
                .multiPart("file", photoFile)
                .accept(ContentType.JSON)
                .post(PET_URL + "/1/uploadImage")
                .then()
                .assertThat()
                .statusCode(200);
    }
}