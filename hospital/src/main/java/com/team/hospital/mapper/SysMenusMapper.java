package com.team.hospital.mapper;

import com.team.hospital.entity.SysMenus;
import com.team.hospital.entity.SysMenusExample;
import java.util.List;

public interface SysMenusMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenus record);

    int insertSelective(SysMenus record);

    List<SysMenus> selectByExample(SysMenusExample example);

    SysMenus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenus record);

    int updateByPrimaryKey(SysMenus record);
}