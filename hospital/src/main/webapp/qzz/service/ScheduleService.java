package com.team.hospital.service;

import com.github.pagehelper.PageInfo;
import com.team.hospital.dto.ScheduleDto;
import com.team.hospital.entity.Schedule;
import com.team.hospital.util.ScheduleParam;


public interface ScheduleService {
    //查询所有
    PageInfo<ScheduleDto> getSchedule(ScheduleParam scheduleParam);
    //添加
    int add(Schedule schedule);
    //删除
    int del(long id);
}
