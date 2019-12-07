package com.zhl.o2o.service;

import com.zhl.o2o.entity.ShopCategory;

import java.io.IOException;
import java.util.List;

public interface ShopCategoryService {
    /**
     *
     * @param shopCategoryCondition
     * @return
     * @throws IOException
     */
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) throws IOException;
}
