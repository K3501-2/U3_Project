package com.team.hospital.controller;

import com.team.hospital.entity.Registry;
import com.team.hospital.service.RegistryService;
import com.team.hospital.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/16 14:03
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.controller
 * @Classname RegistryController
 * @Created by Administrator
 * @Description:挂号业务控制器
 */
@Controller
@RequestMapping("/registry/")
public class RegistryController {
    @Autowired
    private RegistryService registryService;

    @RequestMapping("save")
    @ResponseBody
    public Result save(@RequestBody Registry registry){
        int result = this.registryService.addRegistry(registry);
        if (result > 0)
            return new Result<>("1", "挂号成功！");
        else
            return new Result<>("0", "挂号失败!");
    }
}
