package com.team.hospital.controller;

import com.github.pagehelper.PageInfo;
import com.team.hospital.dto.MenuDto;
import com.team.hospital.dto.UserDto;
import com.team.hospital.entity.SysUsers;
import com.team.hospital.service.UserService;
import com.team.hospital.util.MD5Utils;
import com.team.hospital.util.OSSUtils;
import com.team.hospital.util.PageParmeter;
import com.team.hospital.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    //添加用户
    @RequestMapping("addUser")
    @ResponseBody
    public Result addUser(@RequestBody SysUsers users, HttpSession session){ //将前端传递的json对象自动转化java对象（要求json的键名必需和实体的属性名相同）
        //使用实体类接受客户端数据
        //1.设置时间
        users.setCreatedTime(new Date());
        //2.对密码加密码
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        //3.设置创建的用户id，从session中获取
        //users.setCreatedUserId(new Long("1"));
        SysUsers sysUsers = (SysUsers) session.getAttribute("userInfo");
        users.setCreatedUserId(sysUsers.getId());
        //调用业务实现添加
        int result = this.userService.addUser(users);
        if(result > 0){
            return new Result("1","添加用户成功");
        } else {
            return new Result("0","添加用户失败");
        }
    }

    //通过科室和时间段取医生  getUserByDt?departmentid=值&sign=值
    //Dt = Dapartment and Time
    @RequestMapping("getUserByDt")
    @ResponseBody
    public  Result<List<SysUsers>> getUserByDt(Long departmentId, Byte sign){
        //返回数据
        List<SysUsers> usersList = this.userService.getUsersByDepart(departmentId, sign);
        if (usersList.size() > 0)
            return new Result<>("1","通过科室和时间段查询医生", usersList);
        else
            return new Result<>("0", "没有查到该时段有就诊医生");
    }

    //通过科室医生  getUserByD?departmentid=值
    @GetMapping("getUserByD")//强制只能使用get请求
    @ResponseBody
    public Result<List<UserDto>> getUserByD(Long departmentId){
        try {
            List<UserDto> userList = this.userService.getUsersByDe(departmentId);
            return new Result<>("1", "通过科室查寻医生成功", userList);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>("0", "通过科室查询医生失败");
        }
    }

    //通过类型查询相关人员 1管理 2挂号 3医生 4，收银员 5.药师
    @RequestMapping("getUserByType")
    @ResponseBody
    public Result<List<UserDto>> getUserByType(Byte type){
        try {
            List<UserDto> userList = this.userService.getUsers(type);
            return new Result<>("1", "通过类型查找医生成功", userList);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>("0", "通过类型查找医生失败");
        }
    }

    //通过用户的id获权限菜单 getMenu?userId=?
    @RequestMapping("getMenu")
    @ResponseBody
    public Result<List<MenuDto>> getMenu(Long userId){
        //调用业务
        List<MenuDto> list = this.userService.getUserMenu(userId);
        //返回
        return new Result<>("1", "获取菜单", list);
    }

    //通过id获取单条用户信息 getUserById?id=?
    @RequestMapping("getUserById")
    @ResponseBody
    public Result<SysUsers> getUserById(Long id){
        SysUsers user = this.userService.getUserById(id);
        if (user != null){
            return new Result<>("1", "查询用户成功", user);
        }
        return new Result<>("0", "查询用户失败");
    }

    //修改用户信息
    @RequestMapping("updateUser")
    @ResponseBody
    public Result updateUser(@RequestBody SysUsers record, HttpSession session){
        //使用实体类接受客户端数据
        //1.设置修改时间
        record.setUpdatedTime(new Date());
        //2.对密码加密码
        record.setPassword(MD5Utils.md5Encrypt(record.getPassword()));
        //3.设置创建的用户id，从session中获取
        //record.setCreatedUserId(new Long("1"));
        SysUsers sysUsers = (SysUsers) session.getAttribute("userInfo");
        record.setCreatedUserId(sysUsers.getId());
        //调用业务实现添加
        int result = this.userService.updateUser(record);
        if(result > 0){
            return new Result("1","修改用户成功");
        } else {
            return new Result("0","修改用户失败");
        }
    }

    //删除用户信息
    @RequestMapping("delUser")
    @ResponseBody
    public Result delUser(Long id){
        int result = this.userService.deleteUserById(id);
        if(result > 0){
            return new Result("1","删除用户成功");
        } else {
            return new Result("0","删除用户失败");
        }
    }
}
