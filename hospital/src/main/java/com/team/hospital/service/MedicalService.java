package com.team.hospital.service;

import com.team.hospital.entity.MedicalAdvice;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/19 17:26
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.service
 * @Classname MedicalService
 * @Created by Administrator
 * @Description:医嘱业务
 */
public interface MedicalService {
    //添加医嘱
    public int addMedical(MedicalAdvice advice);
}
