package com.ea.service.impl;

import com.ea.dao.WorldDao;
import com.ea.service.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorldServiceImpl implements WorldService {

    private WorldDao worldDao;
    @Autowired
    public WorldServiceImpl(WorldDao worldDao){
        System.out.println("WorldServiceImpl初始化了=========================");
        this.worldDao = worldDao;
    }
    @Override
    public List<Map<String, Object>> getCity() {
        return worldDao.getCity();
    }
}
