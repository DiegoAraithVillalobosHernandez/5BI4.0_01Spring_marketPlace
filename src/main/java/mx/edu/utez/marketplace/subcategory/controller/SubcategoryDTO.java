package mx.edu.utez.marketplace.subcategory.controller;

import mx.edu.utez.marketplace.category.model.Category;
import mx.edu.utez.marketplace.status.model.Status;


public class SubcategoryDTO {
    private long id;
    private String description;
    private Status status;
    private Category category;

    public SubcategoryDTO() {
    }

    public SubcategoryDTO(String description, Status status, Category category) {
        this.description = description;
        this.status = status;
        this.category = category;
    }

    public SubcategoryDTO(long id, String description, Status status, Category category) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
