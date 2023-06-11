package com.team.hospital.mapper;

import com.team.hospital.entity.ChargeRecords;
import com.team.hospital.entity.ChargeRecordsExample;
import java.util.List;

public interface ChargeRecordsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChargeRecords record);

    int insertSelective(ChargeRecords record);

    List<ChargeRecords> selectByExample(ChargeRecordsExample example);

    ChargeRecords selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChargeRecords record);

    int updateByPrimaryKey(ChargeRecords record);
}