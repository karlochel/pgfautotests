package org.tests.petstore.model.request.builders;

import org.tests.petstore.model.Tag;

public class TagBuilder {
    Tag tag = new Tag();

    public TagBuilder setID(Long id) {
        tag.setId(id);
        return this;
    }

    public TagBuilder setName(String name) {
        tag.setName(name);
        return this;
    }

    public Tag build() {
        return  tag;
    }
}
