package com.zhl.o2o.service;

import com.zhl.o2o.dto.ShopExecution;
import com.zhl.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface ShopService {
    public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
}
