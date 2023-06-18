package com.team.hospital.service;

import com.team.hospital.dto.RoomDto;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/14 23:36
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.service
 * @Classname RoomService
 * @Created by Administrator
 * @Description:房间业务
 */
public interface RoomService {
    //查询就诊房间
    public RoomDto getRoomByDtd(Long departmentId, Long uid, Byte sign);
}
