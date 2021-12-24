package com.sarancha.viewgoods.entity;

import java.math.BigDecimal;

import java.util.Objects;


public class Goods implements Comparable<Goods> {

    Long goodsId;

    String barcode;

    String name;

    BigDecimal prices1;

    BigDecimal remnants1;

    BigDecimal prices2;

    BigDecimal remnants2;

    BigDecimal prices3;

    BigDecimal remnants3;

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

    public BigDecimal getPrices1() {
        return prices1;
    }

    public void setPrices1(BigDecimal price) {
        this.prices1 = price;
    }

    public BigDecimal getPrices2() {
        return prices2;
    }

    public void setPrices2(BigDecimal price) {
        this.prices2 = price;
    }

    public BigDecimal getPrices3() {
        return prices3;
    }

    public void setPrices3(BigDecimal price) {
        this.prices3 = price;
    }

    public Goods(long id, String content) {
        this.goodsId = id;
        this.name = content;
    }

    public Goods() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRemnants1() {
        return remnants1;
    }

    public void setRemnants1(BigDecimal remnant) {
        this.remnants1 = remnant;
    }

    public BigDecimal getRemnants2() {
        return remnants2;
    }

    public void setRemnants2(BigDecimal remnant) {
        this.remnants2 = remnant;
    }

    public BigDecimal getRemnants3() {
        return remnants3;
    }

    public void setRemnants3(BigDecimal remnant) {
        this.remnants3 = remnant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(goodsId, goods.goodsId) &&
                Objects.equals(barcode, goods.barcode) &&
                Objects.equals(name, goods.name) &&
                Objects.equals(prices1, goods.prices1) &&
                Objects.equals(remnants1, goods.remnants1) &&
                Objects.equals(prices2, goods.prices2) &&
                Objects.equals(remnants2, goods.remnants2) &&
                Objects.equals(prices3, goods.prices3) &&
                Objects.equals(remnants3, goods.remnants3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, barcode, name, prices1, remnants1,prices2, remnants2,prices3, remnants3);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", barcode=" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", prices1='" + prices1 + '\'' +
                ", remnants1=" + remnants1 + '\'' +
                ", prices2='" + prices2 + '\'' +
                ", remnants2=" + remnants2 + '\'' +
                ", prices3='" + prices3 + '\'' +
                ", remnants3=" + remnants3 +
                '}';
    }

    @Override
    public int compareTo(Goods o) {
        return this.getGoodsId().compareTo(o.getGoodsId());
    }
}
