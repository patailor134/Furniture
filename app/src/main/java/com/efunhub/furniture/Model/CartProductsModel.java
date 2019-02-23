package com.efunhub.furniture.Model;

/**
 * Created by Admin on 22-01-2018.
 */

public class CartProductsModel {

    String productName, productSize, productQty, productImage;
    int productimage;

    public CartProductsModel() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductQty() {
        return productQty;
    }

    public void setProductQty(String productQty)
    {
        this.productQty = productQty;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getProductimage()
    {
        return productimage;
    }

    public void setProductimage(int productimage) {
        this.productimage = productimage;
    }
}
