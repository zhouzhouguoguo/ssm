package com.zhl.o2o.dao;

import com.zhl.o2o.BaseTest;
import com.zhl.o2o.entity.Area;
import com.zhl.o2o.entity.PersonInfo;
import com.zhl.o2o.entity.Shop;
import com.zhl.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInsertShop() throws Exception {
        Shop shop = new Shop();
        Area area = new Area();
        area.setAreaId(1);
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(1L);
        shop.setShopName("mytest1");
        shop.setShopDesc("mytest1");
        shop.setShopAddr("testaddr1");
        shop.setPhone("13810524526");
        shop.setShopImg("test1");
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setEnableStatus(0);
        shop.setAdvice("审核中");
        shop.setArea(area);
        shop.setShopCategory(sc);
        shop.setOwner(owner);
        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1, effectedNum);
    }

    @Test
    public void updateShop(){
        Shop shop = new Shop();
        Area area = new Area();
        area.setAreaId(1);
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(1L);
        shop.setShopId(2L);
        shop.setShopName("cccc");
        shop.setShopDesc("mytest1");
        shop.setShopAddr("testaddr1");
        shop.setPhone("18673178209");
//        shop.setShopImg("test1");
//        shop.setCreateTime(new Date());
//        shop.setLastEditTime(new Date());
//        shop.setEnableStatus(0);
//        shop.setAdvice("审核中");
//        shop.setArea(area);
//        shop.setShopCategory(sc);
//        shop.setOwner(owner);
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1, effectedNum);
    }
}
