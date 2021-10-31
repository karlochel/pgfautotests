package org.tests.petstore;

import org.testng.annotations.Test;
import org.tests.petstore.model.OrderStatus;
import org.tests.petstore.model.request.builders.OrderRequestBuilder;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Store {
    private static final String STORE_URL = "https://petstore.swagger.io/v2/store";

    @Test
    public void orderPetWithBuilder() {

        LocalDateTime shipDateLocal = LocalDateTime.of(2021,10,28,10,12,0,0);
        ZoneId zoneId = ZoneId.of("UTC");
        ZoneOffset zoneOffSet = zoneId.getRules().getOffset(shipDateLocal);
        OffsetDateTime shipDate = OffsetDateTime.of(shipDateLocal,zoneOffSet);

        OrderRequestBuilder orderRequestBuilder = new OrderRequestBuilder();
        String orderRequestJsonString =
                orderRequestBuilder
                    .setId(200L)
                    .setPetId(1L)
                    .setQuantity(1)
                    .setShipDate(shipDate)
                    .setStatus(OrderStatus.placed)
                    .setComplete(true)
                    .buildJsonString();

        given()
                .header("Content-Type", "application/json")
                .body(orderRequestJsonString)
                .when()
                .post(STORE_URL + "/order")
                .then()
                .assertThat()
                .statusCode(200)
                .body("id", equalTo(200))
                .body("petId", equalTo(1))
                .body("quantity", equalTo(1))
                .body("shipDate", equalTo(shipDate.toString().replaceFirst("Z",":00.000+0000")));
    }
}
