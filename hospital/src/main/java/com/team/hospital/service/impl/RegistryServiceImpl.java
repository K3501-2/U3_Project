package com.team.hospital.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.hospital.dto.RegistryDescDto;
import com.team.hospital.dto.RegistryDto;
import com.team.hospital.entity.Registry;
import com.team.hospital.mapper.RegistryMapper;
import com.team.hospital.service.RegistryService;
import com.team.hospital.util.RegCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/16 0:53
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.service.impl
 * @Classname RegistryServiceImpl
 * @Created by Administrator
 * @Description:排班表业务接口实现
 */
@Service
public class RegistryServiceImpl implements RegistryService {
    @Autowired
    private RegistryMapper registryMapper;

    //新增单条排班信息
    @Override
    public int addRegistry(Registry registry) {
        return registryMapper.insertSelective(registry);
    }

    //分页查询挂号信息
    @Override
    public PageInfo<RegistryDto> searchRegistry(RegCondition condition) {
        //1.开启分页
        PageHelper.startPage(condition.getPage(), condition.getPageSize());
        //2.条件查询所有---调用dao
        List<RegistryDto> list = registryMapper.getRegistryByCondition(condition);
        //返回分页信息
        return new PageInfo<>(list);
    }

    //查看详细挂号信息
    @Override
    public RegistryDescDto getRegistryDesc(Long rid) {
        return this.registryMapper.getRegistryDesc(rid);
    }
}
