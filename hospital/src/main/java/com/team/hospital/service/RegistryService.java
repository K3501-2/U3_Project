package com.team.hospital.service;

import com.github.pagehelper.PageInfo;
import com.team.hospital.dto.RegistryDescDto;
import com.team.hospital.dto.RegistryDto;
import com.team.hospital.entity.Registry;
import com.team.hospital.util.RegCondition;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/16 8:40
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.service
 * @Classname RegisterService
 * @Created by Administrator
 * @Description:挂号业务接口
 */
public interface RegistryService {
    //添加挂号信息
    public int addRegistry(Registry registry);

    //分页查询挂号信息
    public PageInfo<RegistryDto> searchRegistry(RegCondition condition);

    //查询挂号详情
    RegistryDescDto getRegistryDesc(Long rid);
}
