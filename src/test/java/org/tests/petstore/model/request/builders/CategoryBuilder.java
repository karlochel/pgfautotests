package org.tests.petstore.model.request.builders;

import org.tests.petstore.model.Category;

public class CategoryBuilder {
    Category category = new Category();

    public CategoryBuilder setID(Long id) {
        category.setId(id);
        return this;
    }

    public CategoryBuilder setName(String name) {
        category.setName(name);
        return this;
    }

    public Category build() {
        return  category;
    }

}
