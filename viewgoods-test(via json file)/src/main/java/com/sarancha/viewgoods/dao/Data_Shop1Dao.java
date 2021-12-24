package com.sarancha.viewgoods.dao;

import com.sarancha.viewgoods.entity.Data_Shop1;
import com.sarancha.viewgoods.entity.GoodRest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Data_Shop1Dao extends JpaRepository<Data_Shop1,Long> {

    String TextRestSQL = "select ds.goods_id,ds.shop_id, ds.price, ds.remnant from data_shop1 ds";

    @Query(nativeQuery = true, value = TextRestSQL)
    Data_Shop1 getAllGoods();
}
