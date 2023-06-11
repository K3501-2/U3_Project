package com.team.hospital.mapper;

import com.team.hospital.entity.Registry;
import com.team.hospital.entity.RegistryExample;
import java.util.List;

public interface RegistryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Registry record);

    int insertSelective(Registry record);

    List<Registry> selectByExample(RegistryExample example);

    Registry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Registry record);

    int updateByPrimaryKey(Registry record);
}