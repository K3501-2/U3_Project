package com.team.hospital.service;

import com.team.hospital.entity.Patient;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/14 9:48
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.service
 * @Classname PatientService
 * @Created by Administrator
 * @Description:病人业务接口
 */
public interface PatientService {
    //添加就诊卡
    public int addPatient(Patient patient);

    //查询单条病人信息
    public Patient getPatient(String cardid);

    //查询单条病人信息
    public Patient getPatient2(Long id);
}
