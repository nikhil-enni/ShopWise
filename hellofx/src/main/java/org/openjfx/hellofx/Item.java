package org.openjfx.hellofx;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author enni.s
 */
public class Item {
    public int id;
    public String email_id;
    public String product;
    public String product_category;
    public String membership;
    public String payment_method;

    public Item() {
    }

    public Item(int id, String email_id, String product, String product_category, String membership, String payment_method) {
        this.id = id;
        this.email_id = email_id;
        this.product = product;
        this.product_category = product_category;
        this.membership = membership;
        this.payment_method = payment_method;
    }

    public int getId() {
        return id;
    }

    public String getEmail_id() {
        return email_id;
    }

    public String getProduct() {
        return product;
    }

    public String getProductCategory() {
        return product_category;
    }

    public String getMembership() {
        return membership;
    }

    public String getPaymentMethod() {
        return payment_method;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setProductCategory(String product_category) {
        this.product_category = product_category;
    }

    public void setMonthly_premium(String membership) {
        this.membership = membership;
    }

    public void setTenure(String payment_method) {
        this.payment_method = payment_method;
    }
    
    
}
