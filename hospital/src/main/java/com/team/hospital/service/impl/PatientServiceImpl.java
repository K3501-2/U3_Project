package com.team.hospital.service.impl;

import com.team.hospital.entity.Patient;
import com.team.hospital.mapper.PatientMapper;
import com.team.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/14 9:52
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.service.impl
 * @Classname PatientServiceImpl
 * @Created by Administrator
 * @Description:病人相关业务实现
 */
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientMapper patientMapper;

    //添加就诊卡业务实现
    @Override
    public int addPatient(Patient patient) {
        return this.patientMapper.insertSelective(patient);
    }

    //查询单条病人信息
    @Override
    public Patient getPatient(String cardid) {
        return this.patientMapper.getPatient(cardid);
    }

    //查询单条病人信息

    @Override
    public Patient getPatient2(Long id) {
        return this.patientMapper.selectByPrimaryKey(id);
    }
}
