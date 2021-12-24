package com.sarancha.viewgoods.service;

import com.sarancha.viewgoods.dao.Data_Shop1Dao;

import com.sarancha.viewgoods.entity.Data_Shop1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Data_Shop1ServiceImpl implements Data_Shop1Service {

    @Autowired
    private Data_Shop1Dao data_shop1Dao;

    @Override
    public Data_Shop1 save(Data_Shop1 data_shop1) {
        return data_shop1Dao.save(data_shop1);
    }
}
