package com.zhl.o2o.service.impl;

import com.zhl.o2o.dao.ShopDao;
import com.zhl.o2o.dto.ShopExecution;
import com.zhl.o2o.entity.Shop;
import com.zhl.o2o.entity.ShopCategory;
import com.zhl.o2o.enums.ShopStateEnum;
import com.zhl.o2o.service.ShopService;
import com.zhl.o2o.util.FileUtil;
import com.zhl.o2o.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Date;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopDao shopDao;

    public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) throws RuntimeException{
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
        }
        try {
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <= 0) {
                throw new RuntimeException("店铺创建失败");
            } else {
                try {
                    if (shopImg != null) {
                        addShopImg(shop, shopImg);
                        effectedNum = shopDao.updateShop(shop);
                        if (effectedNum <= 0) {
                            throw new RuntimeException("创建图片地址失败");
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException("addShopImg error: "
                            + e.getMessage());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("insertShop error: " + e.getMessage());
        }

        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    private void addShopImg(Shop shop, CommonsMultipartFile shopImg) {
        String dest = FileUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
        shop.setShopImg(shopImgAddr);
    }
}
