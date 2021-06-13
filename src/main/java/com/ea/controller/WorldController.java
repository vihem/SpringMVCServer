package com.ea.controller;

import com.alibaba.fastjson.JSON;
import com.ea.service.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class WorldController {

    private final WorldService worldService;
    @Autowired(required = false)
    public  WorldController(WorldService worldService){
        System.out.println("WorldController初始化=========================");
        this.worldService = worldService;
    }

    @ResponseBody
    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public String getCity(){
        System.out.println("getCity()========================");
//        return Arrays.toString(worldService.getCity().toArray());
        return JSON.toJSONString(worldService.getCity());
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex(){
        System.out.println("getIndex()========================");
        return "index";
    }
}
