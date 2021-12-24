package com.sarancha.viewgoods.service;

import com.sarancha.viewgoods.dao.GoodsRestDao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getRemnantsAndPriceOfGoodsForShop() {
        String textSQL = "select g.goods_id::TEXT AS goods_id, ";
               textSQL = textSQL + "g.goods_barcode::TEXT AS goods_barcode, ";
               textSQL = textSQL + "g.goods_name::TEXT AS goods_name, ";
               textSQL = textSQL + "d1.price::TEXT AS shop_price1, ";
               textSQL = textSQL + "d1.remnant::TEXT AS shop_remnant1, ";
               textSQL = textSQL + "d2.price::TEXT AS shop_price2, ";
               textSQL = textSQL + "d2.remnant::TEXT AS shop_remnant2, ";
               textSQL = textSQL + "d3.price::TEXT AS shop_price3, ";
               textSQL = textSQL + "d3.remnant::TEXT AS shop_remnant3 ";
               textSQL = textSQL + "from goods g";
               textSQL = textSQL + " left join data_shop1 d1 on d1.goods_id = g.goods_id";
               textSQL = textSQL + " left join data_shop2 d2 on d2.goods_id = g.goods_id ";
               textSQL = textSQL + " left join data_shop3 d3 on d3.goods_id = g.goods_id";

        List<Map<String, Object>> listRemnantsAndPriceOfGoodsForShop = jdbcTemplate.queryForList(textSQL);
        return listRemnantsAndPriceOfGoodsForShop;
    }
}
