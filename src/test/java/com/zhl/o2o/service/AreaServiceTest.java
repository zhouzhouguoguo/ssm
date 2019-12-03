package com.zhl.o2o.service;

import com.zhl.o2o.BaseTest;
import com.zhl.o2o.dao.AreaDao;
import com.zhl.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;

    @Test
    public void testGetAreaList(){
        List<Area> areaList = areaService.getAreaList();
        assertEquals(2,areaList.size());
    }
}
