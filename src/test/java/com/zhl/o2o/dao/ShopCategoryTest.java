package com.zhl.o2o.dao;

import com.zhl.o2o.BaseTest;
import com.zhl.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopCategoryTest extends BaseTest {
    @Autowired
    ShopCategoryDao shopCategoryDao;

    @Test
    public void queryShopCategory(){
        ShopCategory sc = new ShopCategory();
        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(sc);
        assertEquals(1, shopCategoryList.size());
    }
}
