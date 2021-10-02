package com.faisal.restapispring.dto;

import javax.validation.constraints.NotEmpty;

public class CategoryData {

    @NotEmpty(message = "name required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
