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

    //条件查询挂号信息
    List<RegistryDto> getRegistryByCondition(RegCondition condition);

    //查看某条挂号信息详情
    RegistryDescDto getRegistryDesc(Long rid);

    //条件查询
    List<RegistryDto> getRegistryByCondition2(RegCondition condition);
}