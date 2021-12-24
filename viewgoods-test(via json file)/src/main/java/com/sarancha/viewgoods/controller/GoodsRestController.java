package com.sarancha.viewgoods.controller;

import com.sarancha.viewgoods.dao.GoodsRestDao;
import com.sarancha.viewgoods.entity.Data_Shop1;
import com.sarancha.viewgoods.entity.Data_Shop2;
import com.sarancha.viewgoods.entity.Data_Shop3;
import com.sarancha.viewgoods.entity.GoodRest;
import com.sarancha.viewgoods.rest.GoodsRestNotSynchronizedWithDatabase;

import com.sarancha.viewgoods.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GoodsRestController {

    @Autowired
    private GoodsRestService goodsRestService;

    @Autowired
    private Data_Shop1Service data_shop1Service;

    @Autowired
    private Data_Shop2Service data_shop2Service;

    @Autowired
    private Data_Shop3Service data_shop3Service;

    @Autowired
    private GoodsRestDao goodsRestDao;

    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello, %s!";

    @PostMapping(value="borrow",produces = MediaType.APPLICATION_JSON_VALUE)
    public Object value1(@RequestBody GoodsRestNotSynchronizedWithDatabase goodsRestNotSynchronizedWithDatabase) {
        System.out.println(goodsRestNotSynchronizedWithDatabase);

        Long goodsId = Long.valueOf(0);

        GoodRest goodRest = new GoodRest();

        //Перевіряємо чи є продукт чи нема і присвоюємо його в goodRest
        goodRest = goodsRestDao.findFirstByBarcode(goodsRestNotSynchronizedWithDatabase.getBarcode());

        //Перевірка чи продукт null значення і якщо null то записує його в новий обьект(для того щоб обійти NullPointerException)
        if(goodRest == null) {
            GoodRest goodRest1 = new GoodRest();

            goodRest1.setBarcode(goodsRestNotSynchronizedWithDatabase.getBarcode());
            goodRest1.setName(goodsRestNotSynchronizedWithDatabase.getName());
            goodsRestService.save(goodRest1);

            goodsId = goodRest1.getGoodsId();
        } else {
            goodRest.setName(goodsRestNotSynchronizedWithDatabase.getName());
            goodsRestService.save(goodRest);

            goodsId = goodRest.getGoodsId();
        }

        Data_Shop1 data_shop1 = new Data_Shop1();

        Data_Shop2 data_shop2 = new Data_Shop2();

        Data_Shop3 data_shop3 = new Data_Shop3();

        //Записуємо усі данні в таблицю з певним shop_id який вказаний в json-файлі
        switch (goodsRestNotSynchronizedWithDatabase.getShop_id()) {
            case 1:
                data_shop1.setGoods_id(goodsId);
                data_shop1.setShop_id(goodsRestNotSynchronizedWithDatabase.getShop_id());
                data_shop1.setPrice(goodsRestNotSynchronizedWithDatabase.getPrice());
                data_shop1.setRemnant(goodsRestNotSynchronizedWithDatabase.getRemnant());

                data_shop1Service.save(data_shop1);
                break;
            case 2:
                data_shop2.setGoods_id(goodsId);
                data_shop2.setShop_id(goodsRestNotSynchronizedWithDatabase.getShop_id());
                data_shop2.setPrice(goodsRestNotSynchronizedWithDatabase.getPrice());
                data_shop2.setRemnant(goodsRestNotSynchronizedWithDatabase.getRemnant());

                data_shop2Service.save(data_shop2);
                break;
            case 3:
                data_shop3.setGoods_id(goodsId);
                data_shop3.setShop_id(goodsRestNotSynchronizedWithDatabase.getShop_id());
                data_shop3.setPrice(goodsRestNotSynchronizedWithDatabase.getPrice());
                data_shop3.setRemnant(goodsRestNotSynchronizedWithDatabase.getRemnant());

                data_shop3Service.save(data_shop3);
                break;
            default:
                return "ERROR";
        }
        return "OK";
    }
}
