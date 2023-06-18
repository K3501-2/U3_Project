package com.team.hospital.mapper;

import com.team.hospital.dto.RegistryDescDto;
import com.team.hospital.dto.RegistryDto;
import com.team.hospital.entity.Patient;
import com.team.hospital.entity.Registry;
import com.team.hospital.entity.RegistryExample;
import com.team.hospital.util.RegCondition;

import java.util.List;

public interface RegistryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Registry record);

    int insertSelective(Registry record);

    List<Registry> selectByExample(RegistryExample example);

    Registry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Registry record);

    int updateByPrimaryKey(Registry record);

    List<RegistryDto> getRegistryByCondition(RegCondition condition);

    RegistryDescDto getRegistryDesc(Long rid);
}