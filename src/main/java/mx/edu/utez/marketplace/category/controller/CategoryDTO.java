package mx.edu.utez.marketplace.category.controller;

import mx.edu.utez.marketplace.status.model.Status;

public class CategoryDTO {
    private long id;
    private String description;
    private Status status;

    public CategoryDTO() {
    }

    public CategoryDTO(String description) {
        this.description = description;
    }

    public CategoryDTO(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public CategoryDTO(long id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
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
}
