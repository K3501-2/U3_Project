package com.team.hospital.mapper;

import com.team.hospital.entity.PrescriptionDetail;
import com.team.hospital.entity.PrescriptionDetailExample;
import java.util.List;

public interface PrescriptionDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PrescriptionDetail record);

    int insertSelective(PrescriptionDetail record);

    List<PrescriptionDetail> selectByExample(PrescriptionDetailExample example);

    PrescriptionDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PrescriptionDetail record);

    int updateByPrimaryKey(PrescriptionDetail record);
}