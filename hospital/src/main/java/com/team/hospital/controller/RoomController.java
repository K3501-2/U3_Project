package com.team.hospital.controller;

import com.team.hospital.dto.RoomDto;
import com.team.hospital.service.RoomService;
import com.team.hospital.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/14 23:43
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.controller
 * @Classname RoomController
 * @Created by Administrator
 * @Description:NULL
 */
@Controller
@RequestMapping("/room/")
public class RoomController {
    @Autowired
    private RoomService roomService;

    //获取所有的科室  getRoomByD?departmentid=&sign=&uid
    @RequestMapping("getRoomByD")
    @ResponseBody
    public Result<RoomDto> getRoomByD(Long departmentId, Long uid, Byte sign){
        try {
            RoomDto rooms = roomService.getRoomByDtd(departmentId, uid, sign);
            return new Result<>("1", "查询房间成功", rooms);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>("0", "查询房间信息失败");
        }
    }

    //通过科室获取所有的房间  getRoomByD?departmentid=&sign=&uid
    @RequestMapping("getRoomByDepart")
    @ResponseBody
    public Result<List<RoomDto>> getRoomByDepart(Long departmentId){
        try {
            List<RoomDto> roomList = roomService.getRoomByDepart(departmentId);
            return new Result<>("1", "查询房间成功", roomList);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>("0", "查询房间信息失败");
        }
    }
}
