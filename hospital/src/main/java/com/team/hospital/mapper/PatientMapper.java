package com.team.hospital.mapper;

import com.team.hospital.entity.Patient;
import com.team.hospital.entity.PatientExample;
import java.util.List;

public interface PatientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Patient record);

    int insertSelective(Patient record);

    List<Patient> selectByExample(PatientExample example);

    Patient selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);

    //通过身份证查询单条病人数据
    Patient getPatient(String cardid);
}