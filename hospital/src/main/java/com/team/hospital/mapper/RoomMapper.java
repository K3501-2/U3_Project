package com.team.hospital.mapper;

import com.team.hospital.dto.RoomDto;
import com.team.hospital.entity.Room;
import com.team.hospital.entity.RoomExample;
import com.team.hospital.entity.SysUsers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Room record);

    int insertSelective(Room record);

    List<Room> selectByExample(RoomExample example);

    Room selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    //查询坐诊医生对应的房间信息
    RoomDto getRoomByDtd(
            @Param(value = "departmentId") Long departmentId,
            @Param(value = "uid") Long uid,
            @Param(value = "sign") Byte sign
    );
}