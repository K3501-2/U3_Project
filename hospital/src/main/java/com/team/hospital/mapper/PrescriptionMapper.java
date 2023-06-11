package com.team.hospital.mapper;

import com.team.hospital.entity.Prescription;
import com.team.hospital.entity.PrescriptionExample;
import java.util.List;

public interface PrescriptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Prescription record);

    int insertSelective(Prescription record);

    List<Prescription> selectByExample(PrescriptionExample example);

    Prescription selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Prescription record);

    int updateByPrimaryKey(Prescription record);
}