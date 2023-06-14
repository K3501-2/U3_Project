package com.team.hospital.controller;

import com.team.hospital.entity.Patient;
import com.team.hospital.service.PatientService;
import com.team.hospital.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/14 10:05
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.controller
 * @Classname PatientController
 * @Created by Administrator
 * @Description:病人相关控制器
 */
@Controller
@RequestMapping("/patient/")
public class PatientController {
    @Autowired
    private PatientService patientService;

    //添加病人信息（就诊卡信息）
    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody Patient patient){
        //调用业务
        int result = this.patientService.addPatient(patient);
        if (result > 0)
            return new Result("1", "添加就诊卡成功");
        else
            return new Result("0", "添加就诊卡失败");
    }

    //通过身份证返回病人信息getPatient?cardid=身份证号
    //获取单条病人信息
    @RequestMapping("getPatient")
    @ResponseBody
    public Result<Patient> getPatient(String cardid){
        //调用业务
        Patient patient = this.patientService.getPatient(cardid);
        //返回
        if (patient != null)
            return new Result<>("1", "获取病人信息", patient);
        else
            return new Result<>("0", "获取病人信息失败");
    }
}
