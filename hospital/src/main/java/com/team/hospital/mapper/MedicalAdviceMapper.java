package com.team.hospital.mapper;

import com.team.hospital.entity.MedicalAdvice;
import com.team.hospital.entity.MedicalAdviceExample;
import java.util.List;

public interface MedicalAdviceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MedicalAdvice record);

    int insertSelective(MedicalAdvice record);

    List<MedicalAdvice> selectByExample(MedicalAdviceExample example);

    MedicalAdvice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MedicalAdvice record);

    int updateByPrimaryKey(MedicalAdvice record);
}