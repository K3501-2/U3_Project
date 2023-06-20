package com.team.hospital.controller;

import com.team.hospital.entity.MedicalAdvice;
import com.team.hospital.service.MedicalService;
import com.team.hospital.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/19 18:44
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.controller
 * @Classname MedicalController
 * @Created by Administrator
 * @Description:NULL
 */
@Controller
@RequestMapping("/medical/")
public class MedicalController {
    @Autowired
    private MedicalService medicalService;

    //添加医嘱
    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody MedicalAdvice advice){
        try {
            //添加，修改
            medicalService.addMedical(advice);
            return new Result("1", "添加成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result("0", "添加失败");
    }
}
