package com.team.hospital.controller;

import com.github.pagehelper.PageInfo;
import com.team.hospital.entity.SysUsers;
import com.team.hospital.service.UserService;
import com.team.hospital.util.PageParmeter;
import com.team.hospital.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/9 15:52
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.controller
 * @Classname UserController
 * @Created by Administrator
 * @Description:用户控制器组件
 */
@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    //登录控制器
    // user/login?username=?&password=?
    @RequestMapping("login")
    @ResponseBody
    public Result<SysUsers> login(String username, String password, HttpSession session){
        //调用业务
        SysUsers sysUsers = userService.login(username, password);

        if (sysUsers == null) {
            return new Result<>("1001", "登入失败");
        } else {
            //将用户信息保存到session
            session.setAttribute("userInfo", sysUsers);
            //表示登入成功
            return new Result<SysUsers>("1000", "登入成功", sysUsers);
        }
    }

    //分页获取用户信息
    //userList?page=页码&pageSize=页大小
    //获取所有用户控制器
    @RequestMapping("userList")
    @ResponseBody
    public Result<Map<String, Object>> userList(PageParmeter pageParmeter){
        //1.获取页码和页大小 利有参数绑定
        //2.调用业务
        PageInfo<SysUsers> pageInfo = userService.getUsers(pageParmeter);

        //将返回的多个数据封装map中
        Map<String, Object> map = new HashMap<>();
        map.put("list", pageInfo.getList());  //获取当前面数据
        map.put("totalRecord", pageInfo.getTotal()); //获取总记当数
        //3.返回
        return new Result<>("1", "查询用户信息", map); //1表示成功
    }
}
