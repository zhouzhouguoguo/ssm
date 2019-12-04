package com.zhl.o2o.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        System.out.println("what the fuck you donig");
        logger.info("fuck you do dodo");
        logger.debug("fuck you do dodo");
        return "hello";
    }

}
