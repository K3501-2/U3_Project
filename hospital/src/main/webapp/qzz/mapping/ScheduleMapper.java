package com.team.hospital.mapper;

import com.team.hospital.dto.ScheduleDto;
import com.team.hospital.entity.Schedule;
import com.team.hospital.entity.ScheduleExample;
import com.team.hospital.util.ScheduleParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    List<Schedule> selectByExample(ScheduleExample example);

    Schedule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
    //查询所有
    List<ScheduleDto> getSchedule(ScheduleParam scheduleParam);
}