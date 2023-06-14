package com.team.hospital.service;

import com.team.hospital.entity.Department;

import java.util.List;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/14 11:56
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.service
 * @Classname DepartmentService
 * @Created by Administrator
 * @Description:科室业务接口
 */
public interface DepartmentService {
    //查询所有科室
    public List<Department> getAllDepartment();
}
