package com.sarancha.viewgoods.service;

import com.sarancha.viewgoods.dao.GoodsRestDao;

import com.sarancha.viewgoods.entity.GoodRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsRestServiceImpl implements GoodsRestService {

    @Autowired
    private GoodsRestDao goodsRestDao;

    @Override
    public GoodRest save(GoodRest goodRest) {
        return goodsRestDao.save(goodRest);
    }
}
