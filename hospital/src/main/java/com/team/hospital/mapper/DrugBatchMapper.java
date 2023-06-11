package com.team.hospital.mapper;

import com.team.hospital.entity.DrugBatch;
import com.team.hospital.entity.DrugBatchExample;
import java.util.List;

public interface DrugBatchMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DrugBatch record);

    int insertSelective(DrugBatch record);

    List<DrugBatch> selectByExample(DrugBatchExample example);

    DrugBatch selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DrugBatch record);

    int updateByPrimaryKey(DrugBatch record);
}