package com.team.hospital.service;

import com.github.pagehelper.PageInfo;
import com.team.hospital.dto.ScheduleDto;
import com.team.hospital.entity.Schedule;
import com.team.hospital.util.ScheduleParam;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/26 16:49
 * @Java version: 1.8.0_361
 * @Project U3_Project
 * @Package com.team.hospital.service
 * @Classname ScheduleService
 * @Created by Administrator
 * @Description:NULL
 */
public interface ScheduleService {
    //查询所有
    PageInfo<ScheduleDto> getSchedule(ScheduleParam scheduleParam);
    //添加
    int add(Schedule schedule);
    //删除
    int del(long id);
}
