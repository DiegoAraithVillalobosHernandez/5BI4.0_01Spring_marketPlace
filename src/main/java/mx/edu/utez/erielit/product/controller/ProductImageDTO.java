package mx.edu.utez.erielit.product.controller;

import java.util.Base64;

//Se modifica el get devuelve un byte[]
public class ProductImageDTO {
    private long id;
    private String name;
    //No recibe un byte[] sino un String
    private String fileBase64;
    //No recibe un producto, eso se hace en productImage


    public ProductImageDTO() {
    }

    public ProductImageDTO(String name, String fileBase64) {
        this.name = name;
        this.fileBase64 = fileBase64;
    }

    public ProductImageDTO(long id, String name, String fileBase64) {
        this.id = id;
        this.name = name;
        this.fileBase64 = fileBase64;
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

    //Se decodifica el archivo
    public byte[] getFileBase64() {
        return Base64.getDecoder().decode(fileBase64.replace(" ","+"));
    }

    public void setFileBase64(String fileBase64) {
        this.fileBase64 = fileBase64;
    }
}
