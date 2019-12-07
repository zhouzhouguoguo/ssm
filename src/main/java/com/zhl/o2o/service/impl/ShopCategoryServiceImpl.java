package com.zhl.o2o.service.impl;

import com.zhl.o2o.dao.ShopCategoryDao;
import com.zhl.o2o.entity.ShopCategory;
import com.zhl.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    ShopCategoryDao shopCategoryDao;
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) throws IOException {
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}
