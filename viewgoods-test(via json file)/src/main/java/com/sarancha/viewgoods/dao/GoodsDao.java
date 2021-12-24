package com.sarancha.viewgoods.dao;

import com.sarancha.viewgoods.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GoodsDao extends JpaRepository<Goods, Long>{

    String TextSQL = "select g1.goods_barcode, g1.goods_name, \n" +
            "\t\tg1.goods_id id_1, g1.goods_price price_1, g1.goods_remnant remnant_1, \n" +
            "\t\tg2.goods_id id_2, g2.goods_price price_2, g2.goods_remnant remnant_2,\n" +
            "\t\tg3.goods_id id_3, g3.goods_price price_3, g3.goods_remnant remnant_3\n" +
            "from goods g1 \n" +
            "     left join goods g2 on g1.goods_barcode = g2.goods_barcode and g2.goods_shop_id = 2\n" +
            "\t left join goods g3 on g1.goods_barcode = g3.goods_barcode and g3.goods_shop_id = 3\n" +
            "where g1.goods_shop_id = 1";

    @Query(nativeQuery = true, value = TextSQL)
    List<Goods> getAllGoods();
//    List<Goods> getAllByOrderByName();

    List<Goods> getAllByOrderByNameDesc();

    List<Goods> getFirst2ByOrderByNameDesc();
}
