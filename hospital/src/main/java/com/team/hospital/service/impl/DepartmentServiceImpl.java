package com.team.hospital.service.impl;

import com.team.hospital.entity.Department;
import com.team.hospital.entity.DepartmentExample;
import com.team.hospital.mapper.DepartmentMapper;
import com.team.hospital.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/14 11:57
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.service.impl
 * @Classname DepartmentServiceImpl
 * @Created by Administrator
 * @Description:科室操作接口实现
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    //查询所有科室业务实现
    @Override
    public List<Department> getAllDepartment() {
        return this.departmentMapper.selectByExample(new DepartmentExample());
    }
}
