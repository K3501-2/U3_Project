package com.team.hospital.controller;

import com.team.hospital.entity.Department;
import com.team.hospital.service.DepartmentService;
import com.team.hospital.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/14 11:59
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.controller
 * @Classname DepartmentController
 * @Created by Administrator
 * @Description:科室操作控制器
 */
@Controller
@RequestMapping("/department/")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("getAll")
    @ResponseBody
    public Result<List<Department>> getAll(){
        //调用业务
        return new Result<List<Department>>(
                "1",
                "查询成功",
                this.departmentService.getAllDepartment());
    }
}
