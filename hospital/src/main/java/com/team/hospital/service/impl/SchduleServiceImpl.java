package com.team.hospital.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.hospital.dto.ScheduleDto;
import com.team.hospital.entity.Schedule;
import com.team.hospital.mapper.ScheduleMapper;
import com.team.hospital.service.ScheduleService;
import com.team.hospital.util.ScheduleParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/26 16:49
 * @Java version: 1.8.0_361
 * @Project U3_Project
 * @Package com.team.hospital.service.impl
 * @Classname SchduleServiceImpl
 * @Created by Administrator
 * @Description:NULL
 */
@Service
public class SchduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public PageInfo<ScheduleDto> getSchedule(ScheduleParam scheduleParam) {
        PageHelper.startPage(scheduleParam.getPage(),scheduleParam.getPageSize());
        List<ScheduleDto> list = scheduleMapper.getSchedule(scheduleParam);
        return new PageInfo<>(list);
    }

    @Override
    public int add(Schedule schedule) {
        return scheduleMapper.insertSelective(schedule);
    }

    @Override
    public int del(long id) {
        return scheduleMapper.deleteByPrimaryKey(id);
    }
}
