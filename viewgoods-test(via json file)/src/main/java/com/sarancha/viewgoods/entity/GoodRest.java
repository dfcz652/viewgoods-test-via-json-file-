package com.sarancha.viewgoods.entity;

import javax.persistence.*;

@Entity
@Table(name = "goods")
public class GoodRest {

    @Id
    @SequenceGenerator(name = "goods_seq", sequenceName = "goods_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "goods_seq")
    @Column(name = "goods_id")
    Long goodsId;

    @Column(name = "goods_barcode")
    String barcode;

    @Column(name = "goods_name")
    String name;

    public GoodRest(Long goodsId, String barcode, String name) {
        this.goodsId = goodsId;
        this.barcode = barcode;
        this.name = name;
    }

    public GoodRest() {

    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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
}
