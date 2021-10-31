package org.tests.petstore.model.request.builders;

import org.json.JSONObject;
import org.tests.petstore.model.JsonParser;
import org.tests.petstore.model.OrderStatus;
import org.tests.petstore.model.request.OrderRequest;

import java.time.OffsetDateTime;

public class OrderRequestBuilder {
    OrderRequest order = new OrderRequest();
    JsonParser jsonParser = new JsonParser();

    public OrderRequestBuilder setId(Long id) {
        order.setId(id);
        return this;
    }

    public OrderRequestBuilder setPetId(Long id) {
        order.setPetId(id);
        return this;
    }

    public OrderRequestBuilder setQuantity(Integer quantity) {
        order.setQuantity(quantity);
        return this;
    }

    public OrderRequestBuilder setShipDate(OffsetDateTime shipDate) {
        order.setShipDate(shipDate.toString());
        return this;
    }

    public OrderRequestBuilder setStatus(OrderStatus status) {
        order.setStatus(status);
        return this;
    }

    public OrderRequestBuilder setComplete(boolean complete) {
        order.setComplete(complete);
        return this;
    }

    public OrderRequest build() {
        return order;
    }

    public String buildJsonString() {
        return jsonParser.classToJsonString(order);
    }

    public JSONObject buildJsonObject() {
        return jsonParser.classToJsonObject(order);
    }
}
