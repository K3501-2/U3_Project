package com.team.hospital.service.impl;

import com.team.hospital.entity.Registry;
import com.team.hospital.mapper.RegistryMapper;
import com.team.hospital.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
