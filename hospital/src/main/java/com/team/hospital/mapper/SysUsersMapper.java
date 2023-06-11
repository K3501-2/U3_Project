package com.team.hospital.mapper;

import com.team.hospital.entity.SysUsers;
import com.team.hospital.entity.SysUsersExample;
import java.util.List;

public interface SysUsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUsers record);

    int insertSelective(SysUsers record);

    List<SysUsers> selectByExample(SysUsersExample example);

    SysUsers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUsers record);

    int updateByPrimaryKey(SysUsers record);

    List<SysUsers> getAllUser();
}