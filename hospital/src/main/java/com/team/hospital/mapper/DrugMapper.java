package com.team.hospital.mapper;

import com.team.hospital.entity.Drug;
import com.team.hospital.entity.DrugExample;
import java.util.List;

public interface DrugMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Drug record);

    int insertSelective(Drug record);

    List<Drug> selectByExample(DrugExample example);

    Drug selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Drug record);

    int updateByPrimaryKey(Drug record);
}