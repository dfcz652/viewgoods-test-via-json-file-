package com.sarancha.viewgoods.controller;

import com.sarancha.viewgoods.entity.Goods;
import com.sarancha.viewgoods.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GoodsController {
    @Autowired
    private GoodService goodsService;

    @GetMapping("/goods")
    public String getGoods(Model model) {
        model.addAttribute("goodsList", goodsService.getRemnantsAndPriceOfGoodsForShop());
        return "goods";
    }

}
