package com.sarancha.viewgoods.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "data_shop3")
public class Data_Shop3 {

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "remnant")
    BigDecimal remnant;

    @Id
    @Column(name = "goods_id")
    Long goods_id;

    @Column(name = "shop_id")
    int shop_id;

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

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }
}
