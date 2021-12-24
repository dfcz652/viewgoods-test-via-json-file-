package com.sarancha.viewgoods.service;

import com.sarancha.viewgoods.dao.Data_Shop3Dao;

import com.sarancha.viewgoods.entity.Data_Shop3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Data_Shop3ServiceImpl implements Data_Shop3Service {

    @Autowired
    private Data_Shop3Dao data_shop3Dao;

    @Override
    public Data_Shop3 save(Data_Shop3 data_shop3) {
        return data_shop3Dao.save(data_shop3);
    }
}
