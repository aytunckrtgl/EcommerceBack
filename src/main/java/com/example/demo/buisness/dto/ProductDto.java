package com.example.demo.buisness.dto;

public class ProductDto {
    private long productId;
    private String Name;
    private String shortDescription;
    private String longDescription;
    private Double price;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
