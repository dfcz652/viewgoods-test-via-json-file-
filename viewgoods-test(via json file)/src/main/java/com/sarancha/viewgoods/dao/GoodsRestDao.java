package com.sarancha.viewgoods.dao;

import com.sarancha.viewgoods.entity.GoodRest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRestDao extends JpaRepository<GoodRest, Long>{

    String TextRestSQL = "select g.goods_id,g.goods_barcode, g.goods_name from goods g";

        @Query(nativeQuery = true, value = TextRestSQL)
        GoodRest getAllGoods();

    GoodRest findFirstByBarcode(String barcode);
}
