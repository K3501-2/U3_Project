package com.team.hospital.controller;

import com.github.pagehelper.PageInfo;
import com.team.hospital.dto.ScheduleDto;
import com.team.hospital.entity.Schedule;
import com.team.hospital.service.ScheduleService;
import com.team.hospital.util.Result;
import com.team.hospital.util.ScheduleParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/all")
    @ResponseBody
    public Result<Map<String,Object>> all(@RequestBody ScheduleParam scheduleParam){
        PageInfo<ScheduleDto> pageInfo = scheduleService.getSchedule(scheduleParam);
        Map<String,Object> map = new HashMap<>();
        map.put("list",pageInfo.getList());
        map.put("totalRecord",pageInfo.getTotal());
        return new Result<>("1","所有排期信息",map);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Schedule schedule){
        schedule.setQuantity(0);
        schedule.setRemainingQuantity(0);
        int temp = scheduleService.add(schedule);
        if (temp > 0)
            return new Result("1","医生排期添加成功");
        return new Result("0","医生排期添加失败");
    }

    @RequestMapping("/del")
    @ResponseBody
    public Result del(Long id){
        int temp = scheduleService.del(id);
        if (temp > 0)
            return new Result("1","医生排期删除成功");
        return new Result("0","医生排期删除失败");
    }
}
