package org.tests.petstore.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.tests.petstore.model.Category;
import org.tests.petstore.model.PetStatus;
import org.tests.petstore.model.Tag;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PetRequest {

    Long id;
    Category category;
    String name;
    List<String> photoUrls;
    List<Tag> tags;
    PetStatus status;

    public PetRequest() {
        category= new Category();
        photoUrls = new ArrayList<String>();
        tags = new ArrayList<Tag>();
    }

}