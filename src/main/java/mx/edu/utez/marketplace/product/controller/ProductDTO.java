package mx.edu.utez.marketplace.product.controller;

import com.sun.istack.NotNull;
import mx.edu.utez.marketplace.status.model.Status;
import mx.edu.utez.marketplace.subcategory.model.Subcategory;

import java.util.List;

// Los DTO nos sirven de plantilla para los datos recibidos del front
// Lo correcto es hacerlo en el service, sin embargo aqui lo hacemos en el controller
public class ProductDTO {
    private long id;
    //Anotaciones que nos ayudan a validar
    //@NotNull
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String brand;
    private Status status;
    private Subcategory subcategory;
    private List<ProductImageDTO> images;

    public ProductDTO() {
    }

    public ProductDTO(String name, String description, double price, int quantity, String brand, Status status, List<ProductImageDTO> images, Subcategory subcategory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.status = status;
        this.images = images;
        this.subcategory = subcategory;
    }

    public ProductDTO(long id, String name, String description, double price, int quantity, String brand, Status status, List<ProductImageDTO> images, Subcategory subcategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.status = status;
        this.images = images;
        this.subcategory = subcategory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ProductImageDTO> getImages() {
        return images;
    }

    public void setImages(List<ProductImageDTO> images) {
        this.images = images;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
