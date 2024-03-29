package com.team.hospital.service.impl;

import com.team.hospital.dto.RoomDto;
import com.team.hospital.entity.Room;
import com.team.hospital.mapper.RoomMapper;
import com.team.hospital.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/14 23:39
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.service.impl
 * @Classname RoomServiceImpl
 * @Created by Administrator
 * @Description:房间业务接口实现
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    //查询就诊房间业务实现
    @Override
    public RoomDto getRoomByDtd(Long departmentId, Long uid, Byte sign) {
        return roomMapper.getRoomByDtd(departmentId, uid, sign);
    }

    //通过部门号查询房间
    @Override
    public List<RoomDto> getRoomByDepart(Long departmentId) {
        return roomMapper.getRoomByDepart(departmentId);
    }
}
