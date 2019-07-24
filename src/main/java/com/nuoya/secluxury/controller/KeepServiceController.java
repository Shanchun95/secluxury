package com.nuoya.secluxury.controller;


import com.nuoya.secluxury.pojo.KeepService;
import com.nuoya.secluxury.service.KeepSerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/keepService")
public class KeepServiceController {
    @Autowired
    KeepSerService keepSerService;

    @RequestMapping("/getAllService")
    @ResponseBody
    @ApiOperation("养护服务界面：有5个服务类别serviceType，传送后端一个serviceType，传回一个json数组，包含该类别下的所有服务")
    public List<KeepService> getAllService(@ApiParam("serviceType是服务类别") Integer serviceType){
        System.out.println(serviceType);
        return keepSerService.getAllService(serviceType);
    }
}
