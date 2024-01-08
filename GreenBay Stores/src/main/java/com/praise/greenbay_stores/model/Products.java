package com.praise.greenbay_stores.model;

import java.math.BigDecimal;

public class Products {
    protected int prod_id;
    protected String category;
    protected String prodName;
    protected BigDecimal price;
    protected int quantity;

    public Products() {
    }

    public Products(int prod_id) {
        this.prod_id = prod_id;
    }

    public Products(int prod_id, String category, String prodName, BigDecimal price, int quantity) {
        this.prod_id = prod_id;
        this.category = category;
        this.prodName = prodName;
        this.price = price;
        this.quantity = quantity;
    }

    public Products(String category, String prodName, BigDecimal price, int quantity) {
        this.category = category;
        this.prodName = prodName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
