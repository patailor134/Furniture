package com.efunhub.furniture.Model;

import java.io.Serializable;

/**
 * Created by PATailor on 14-02-2018.
 */

public class SofaDescriptionModel  implements Serializable
{
    String product_image;

    public SofaDescriptionModel() {
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }
}
