package org.tests.petstore.model.request;

import lombok.Getter;
import lombok.Setter;
import org.tests.petstore.model.OrderStatus;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OrderRequest {

    Long id;
    Long petId;
    Integer quantity;
    String shipDate;
    OrderStatus status;
    boolean complete;
}
