package com.zhl.o2o.service;

import com.zhl.o2o.BaseTest;
import com.zhl.o2o.dto.ShopExecution;
import com.zhl.o2o.entity.Area;
import com.zhl.o2o.entity.PersonInfo;
import com.zhl.o2o.entity.Shop;
import com.zhl.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    ShopService shopService;

//	@Test
//	public void testAddShop() throws Exception {
//		Shop shop = new Shop();
//        PersonInfo owner = new PersonInfo();
//        owner.setUserId(1L);
//		shop.setOwner(owner);
//		Area area = new Area();
//		area.setAreaId(1);
//		ShopCategory sc = new ShopCategory();
//		sc.setShopCategoryId(1L);
//		shop.setShopName("mytest1");
//		shop.setShopDesc("mytest1");
//		shop.setShopAddr("testaddr1");
//		shop.setPhone("13810524526");
//		shop.setShopImg("test1");
//		shop.setCreateTime(new Date());
//		shop.setLastEditTime(new Date());
//		shop.setEnableStatus(0);
//		shop.setAdvice("审核中");
//		shop.setArea(area);
//		shop.setShopCategory(sc);
//
//		ShopExecution se = shopService.addShop(shop, );
//		assertEquals("mytest1", se.getShop().getShopName());
//	}

}
