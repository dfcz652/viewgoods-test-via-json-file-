package com.sarancha.viewgoods.rest;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

@Component
public class GoodsRestNotSynchronizedWithDatabase {

    String barcode;

    String name;

    BigDecimal price;

    BigDecimal remnant;

    int shop_id;

    public GoodsRestNotSynchronizedWithDatabase(String barcode, String name, BigDecimal price, BigDecimal remnant, int shop_id) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.remnant = remnant;
        this.shop_id = shop_id;
    }

    public GoodsRestNotSynchronizedWithDatabase() {

    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getRemnant() {
        return remnant;
    }

    public void setRemnant(BigDecimal remnant) {
        this.remnant = remnant;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsRestNotSynchronizedWithDatabase that = (GoodsRestNotSynchronizedWithDatabase) o;
        return shop_id == that.shop_id &&
                Objects.equals(barcode, that.barcode) &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(remnant, that.remnant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode, name, price, remnant, shop_id);
    }

    @Override
    public String toString() {
        return "GoodsForRest{" +
                ", barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", remnant=" + remnant +
                ", shop_id=" + shop_id +
                '}';
    }
}
