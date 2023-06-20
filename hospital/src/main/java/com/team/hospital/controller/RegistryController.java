package com.team.hospital.controller;

import com.github.pagehelper.PageInfo;
import com.team.hospital.dto.RegistryDescDto;
import com.team.hospital.dto.RegistryDto;
import com.team.hospital.entity.Registry;
import com.team.hospital.service.RegistryService;
import com.team.hospital.util.RegCondition;
import com.team.hospital.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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

    //条件查询  regSearch?page=&pageSize=&......
    @RequestMapping("regSearch")
    @ResponseBody
    public Result<Map<String, Object>> regSearch(RegCondition condition){
        //获取分页信息
        PageInfo<RegistryDto> pageInfo = this.registryService.searchRegistry2(condition);
        //返回结果
        /*Map<String,Object> map=new HashMap<>();
        map.put("list",pageInfo.getList());
        map.put("totalRecord",pageInfo.getTotal());*/
        Map<String, Object> map = new HashMap<String, Object>(){{
            put("list", pageInfo.getList());
            put("totalRecord", pageInfo.getTotal());
        }};
        return new Result<>("1", "搜索挂号信息成功", map);
    }

    //查询挂号详情  regDesc?id=挂号的id
    @RequestMapping("regDesc")
    @ResponseBody
    public Result<RegistryDescDto> regDesc(Long rid){
        //获取分页信息
        RegistryDescDto dto = this.registryService.getRegistryDesc(rid);
        //返回
        return new Result<>("1", "查询挂号详情成功", dto);
    }
}
