package com.team.hospital.service;

import com.team.hospital.entity.Registry;

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
}
