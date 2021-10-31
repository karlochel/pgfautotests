package org.tests.petstore.model.request.builders;

import org.json.JSONObject;
import org.tests.petstore.model.Category;
import org.tests.petstore.model.JsonParser;
import org.tests.petstore.model.PetStatus;
import org.tests.petstore.model.request.PetRequest;
import org.tests.petstore.model.Tag;

public class PetRequestBuilder {
    PetRequest pet = new PetRequest();
    JsonParser jsonParser = new JsonParser();

    public PetRequestBuilder setId(Long id) {
        pet.setId(id);
        return this;
    }

    public PetRequestBuilder setCategory(Category category) {
        pet.setCategory(category);
        return this;
    }

    public PetRequestBuilder setName(String name) {
        pet.setName(name);
        return this;
    }

    public PetRequestBuilder addPhoto(String photoLink) {
        pet.getPhotoUrls().add(photoLink);
        return this;
    }

    public PetRequestBuilder addTag(Tag tag) {
        pet.getTags().add(tag);
        return this;
    }

    public PetRequestBuilder setStatus(PetStatus status) {
        pet.setStatus(status);
        return this;
    }

    public PetRequest build() {
        return pet;
    }

    public String buildJsonString() {
        return jsonParser.classToJsonString(pet);
    }

    public JSONObject buildJsonObject() {
        return jsonParser.classToJsonObject(pet);
    }
}
