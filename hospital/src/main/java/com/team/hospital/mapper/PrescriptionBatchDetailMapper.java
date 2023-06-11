package com.team.hospital.mapper;

import com.team.hospital.entity.PrescriptionBatchDetail;
import com.team.hospital.entity.PrescriptionBatchDetailExample;
import java.util.List;

public interface PrescriptionBatchDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PrescriptionBatchDetail record);

    int insertSelective(PrescriptionBatchDetail record);

    List<PrescriptionBatchDetail> selectByExample(PrescriptionBatchDetailExample example);

    PrescriptionBatchDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PrescriptionBatchDetail record);

    int updateByPrimaryKey(PrescriptionBatchDetail record);
}