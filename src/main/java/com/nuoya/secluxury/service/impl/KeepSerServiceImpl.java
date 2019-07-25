package com.nuoya.secluxury.service.impl;

import com.nuoya.secluxury.mapper.KeepServiceMapper;
import com.nuoya.secluxury.pojo.KeepService;
import com.nuoya.secluxury.service.KeepSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeepSerServiceImpl implements KeepSerService {

    @Autowired
    KeepServiceMapper keepServiceMapper;

    @Override
    public List<KeepService> getAllService(Integer serviceType) {
        return keepServiceMapper.getAllService(serviceType);
    }
}
