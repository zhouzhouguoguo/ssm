package com.zhl.o2o.web.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhl.o2o.dto.ShopExecution;
import com.zhl.o2o.entity.Area;
import com.zhl.o2o.entity.PersonInfo;
import com.zhl.o2o.entity.Shop;
import com.zhl.o2o.entity.ShopCategory;
import com.zhl.o2o.enums.ShopStateEnum;
import com.zhl.o2o.service.AreaService;
import com.zhl.o2o.service.ShopCategoryService;
import com.zhl.o2o.service.ShopService;
import com.zhl.o2o.util.CodeUtil;
import com.zhl.o2o.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "shopadmin")
public class ShopManagementController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopCategoryService shopCategoryService;

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/getshopinitinfo", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getShopInitInfo(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
        List<Area> areaList = new ArrayList<Area>();
        try{
            shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
            areaList = areaService.getAreaList();
            modelMap.put("shopCategoryList", shopCategoryList);
            modelMap.put("areaList", areaList);
            modelMap.put("success", true);
        }catch (Exception e){
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }

        return modelMap;
    }



    @RequestMapping(value = "/registershop", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> registerShop(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (!CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "输入了错误的验证码");
            return modelMap;
        }
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        MultipartHttpServletRequest multipartRequest = null;
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            multipartRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartRequest
                    .getFile("shopImg");
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "上传图片不能为空");
            return modelMap;
        }
        try {
            shop = mapper.readValue(shopStr, Shop.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        if (shop != null && shopImg != null) {
            try {
//                PersonInfo user = (PersonInfo) request.getSession()
//                        .getAttribute("user");
//                shop.setOwner(user);
                PersonInfo owner = new PersonInfo();
                owner.setUserId(1L);
                shop.setOwner(owner);
                ShopExecution se = shopService.addShop(shop, shopImg);
                if (se.getState() == ShopStateEnum.CHECK.getState()) {
                    modelMap.put("success", true);
                    // 若shop创建成功，则加入session中，作为权限使用
//                    @SuppressWarnings("unchecked")
//                    List<Shop> shopList = (List<Shop>) request.getSession()
//                            .getAttribute("shopList");
//                    if (shopList != null && shopList.size() > 0) {
//                        shopList.add(se.getShop());
//                        request.getSession().setAttribute("shopList", shopList);
//                    } else {
//                        shopList = new ArrayList<Shop>();
//                        shopList.add(se.getShop());
//                        request.getSession().setAttribute("shopList", shopList);
//                    }
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", se.getStateInfo());
                }
            } catch (RuntimeException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }

        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入店铺信息");
        }
        return modelMap;
    }

}
