package com.team.hospital.controller;

import com.github.pagehelper.PageInfo;
import com.team.hospital.entity.SysUsers;
import com.team.hospital.service.UserService;
import com.team.hospital.util.MD5Utils;
import com.team.hospital.util.OSSUtils;
import com.team.hospital.util.PageParmeter;
import com.team.hospital.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
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

    //编写上传用户图像的接口
    //接收上传文件，返回文件路径
    @RequestMapping("uploadFile")
    @ResponseBody
    public Result<String> uploadFile(
            @RequestParam(value = "file", required = false)CommonsMultipartFile file
    ){
        //方式一：将上传文件保存到服务器的项目中
        //方式儿：将上传闻见保存到文件服务器（oss）中 选择
        //1.生成唯一文件名
        String fname = file.getOriginalFilename();  //15.jpg
        String extName = fname.substring(fname.lastIndexOf("."));
        String saveName = System.currentTimeMillis() + extName;

        //2.上传文件
        try{
            String path = OSSUtils.upload_File(
                    saveName,
                    (FileInputStream) file.getInputStream()
            );
            return new Result<>("1", "上传文件成功", path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result<>("0", "上传文件失败");
    }

    @RequestMapping("addUser")
    @ResponseBody
    public Result addUser(@RequestBody SysUsers users){ //将前端传递的json对象自动转化java对象（要求json的键名必需和实体的属性名相同）
        //使用实体类接受客户端数据
        //1.设置时间
        users.setCreatedTime(new Date());
        //2.对密码加密码
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        //3.设置创建的用户id，暂时给固定式1，以后从session中获取
        users.setCreatedUserId(new Long(1));
        //调用业务实现添加
        int result = this.userService.addUser(users);
        if(result > 0){
            return new Result("1","添加用户成功");
        } else {
            return new Result("0","添加用户失败");
        }
    }
}
