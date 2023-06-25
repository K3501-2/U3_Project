# U3_Project
存放U3阶段的项目代码

首次提交项目初始代码--2023年6月11日19:03:44



# 日志

## 第一次更新

2023年6月12日14:23:18

day19阿里云oss+添加用户

### 今日新增：

1. OSS文件上传工具类(OSSUtils.java)；
2. 文件上传接口：(UserController)→(/user/uploadFile)；
3. 添加用户接口：(UserController)→(/user/addUser) 
4. 用户接口对应前端页面(addUser.html)编辑，添加双重密码验证（邱）；
5. 接口写完一定测试！

### 与示例代码不同：

文件上传接口名称：upload2→uploadFile；

### 同步代码需注意事项：

1. OSS相关配置，接口相关属性名字配置；

   ​



## 第二次更新

2023年6月14日09:49:49

day20 项目四(创建就诊卡+挂号页面数据加载)

### 今日新增：

1. *新增创建就诊卡业务（PatientService）：*

   1. 病人业务相关上传接口：(PatientController)→(/patient/)；

   2. 添加就诊卡接口：(PatientController)→(/patient/add) ；

   3. 就诊卡接口对应前端页面(addPatient.html)编辑；

      出生日期样式换成日历（林）；

      验证身份证格式（validateSfz.js），在addPatient.html中导入模组module,

      导入模组注意：

      1.  &lt;head&gt;标签中添加&lt;script src="js/封装的js名字.js" type="module"&gt;&lt;/script&gt;
      2.  下方Vue标签导入时&lt;script type="application/javascript"&gt; → &lt;script type="module"&gt;，并且在new Vue上方添加import {封装在js中的函数名} from "/js/封装的js名字.js";

2. *挂号页面数据信息加载（PatientService）：*

   1. 通过身份证号显示单条病人信息；
   2. 通过身份证显示单条病人信息接口：(PatientController)→(/patient/getPatient) ；
   3. 对应前端页面（addRegistry.html）编辑：
      1. 病人信息回显（输入身份证号调用显示病人信息接口回显）；
      2. <u>调用加载科室后台接口显示科室信息；</u>
      3. <u>调用用户列表后台接口，通过就诊科室和时间段查询医师。</u>

3. *新增科室业务*（DepartmentService）：

   1. 查询所有科室接口（DepartmentController）→（/department/getAll)；
   2. 对应前端页面（addRegistry.html）编辑

4. *通过就诊科室和时间段查询医师（UserService）：*

   1. dao层、业务层和控制层均有更新（User相关）；
   2. 对应前端页面（addRegistry.html）编辑

5. 接口写完一定测试！

   ​



## 第三次更新

2023年6月16日09:15:53

day21 挂号信息保存+挂号信息管理

### 今日新增：

1. *DTO工具加入，新增：*
   1. 房间查询实体类（RoomDto.java）；
   2. 用户查询实体类（UserDto.java）;
2. *接口*：
   1. 文件上传(UserController)→(/user/uploadFile)；
   2. 用户列表后台(RegistryController)→(/registry/save)；
   3. 科室信息加载(UserController)→(/user/getUserByD);

### 与示例代码不同：

### 同步代码需注意事项：



## 第四次更新

2023年6月18日09:47:05

day22 挂号信息分页展示

### 今日新增：

1. *新增类：*
   1. 条件查询挂号信息工具类（RegCondition.java）；
   2. 挂号信息返回实体类（RegistryDto.java）;
   3. 查看详细挂号信息实体类（RegistryDescDto.java）;
2. *dao ( mapper )层新增*：
   1. 条件查询挂号信息( RegistryMapper.java )→( getRegistryByCondition );
   2. 查看详细挂号信息( RegistryMapper.java )→( getRegistryDesc );
3. *Service业务层新增*：
   1. 挂号信息条件查询（分页）业务( RegisterService )→( PageInfo&lt;RegistryDto&gt; searchRegistry )；
   2. 查看详细挂号信息业务( RegisterService )→( RegistryDescDto getRegistryDesc )；
4. *控制层接口*：
   1. 分页查询挂号信息(RegistryController)→(/registery/regSearch)；
   2. 查看详细挂号信息业务((RegistryController)→(/registry/regDesc)；
5. 对应前端页面更改

### 与示例代码不同：

显示性别：

```vue
//显示性别
filters: {
    genderFilter(value) {
        if (value === '1')
            return '男';
        if (value === '2')
            return '女';
    }
}
```

详细挂号信息页面右上角叉号退出：

```html
<!--挂号单详情  :visible="true"  显示  :visible="false"不显示 -->
<el-dialog title="查看挂号信息" :visible.sync="dialogFormVisible" width="70%" :before-close="handleClose">
```

```vue
handleClose(done) {
    this.$confirm('确认关闭？')
        .then(_ => {
            done();
        })
        .catch(_ => {});
},
```

### 同步代码需注意事项：



## 第五次更新

2023年6月19日09:02:35

day22 挂号信息分页展示

### 今日新增：

1. *新增实体类：*
   1. 挂号信息实体类（RegistryDto.java）新增属性：
      1. private Long pid;  //病人编号
      2. private String userName;//医生姓名
      3. private Byte status;//就诊状态
   2. 挂号详细信息实体类 ( RegistryDescDto.java ) 新增属性：
      1. private Long userId;//用户编号
      2. private Long mId;//医嘱编号
2. *dao ( mapper )层新增*：
   1. 通过用户类型查询医生信息( SysUsersMapper.java )→( List&lt;UserDto&gt; getUsers(Byte type) );
   2. 查看详细挂号信息( RegistryMapper.java )→( List&lt;RegistryDto&gt; getRegistryByCondition2(RegCondition condition);
3. *Service业务层新增*：
   1. 通过用户类型查询医生信息业务( UserService )→( List&lt;UserDto&gt; getUsers(Byte type) )；
   2. 查看详细挂号信息业务( RegisterService )→( PageInfo&lt;RegistryDto&gt; searchRegistry2(RegCondition condition) );
   3. 医嘱接口&gt;添加医嘱（ MedicalService.java )→( int addMedical(MedicalAdvice advice) ) ;
4. *控制层接口*：
   1. 通过用户类型查询医生信息( UserController )→( /user/getUserByType )；
   2. 查看详细挂号信息业务((RegistryController)→(/registry/regSearch)→调用业务改为“searchRegistry2”；
5. 对应前端页面更改

### 与示例代码不同：

### 同步代码需注意事项：

1. 所有代码参数类型为了避免出错我统一改为了包装类，可改可不改；
2. 代码规范美观，希望开始注意，代码的缩进，规范和美观程度，适当添加注释；





## 第六次更新

2023年6月20日14:52:42

day23 权限动态加载菜单

### 今日新增：

1. *新增实体类：*

   1. 查询菜单实体类 ( MenuDto.java );

      1. private Long pid;  //病人编号
      2. private String userName;//医生姓名
      3. private Byte status;//就诊状态

      ​

      1. private Long userId;//用户编号
      2. private Long mId;//医嘱编号

2. *dao ( mapper )层新增*：

   1. 通过用户查找菜单( SysUsersMapper.java )：

      1. //通过用户编号id找一级菜单

          List&lt;MenuDto&gt; getMenuByUser(Long uid); 

      2. //通过一级菜单的编号查找对应的二级菜单

         List&lt;MenuDto&gt; getMenuByParentId(Long parentId)；

   2. 通过一级菜单的编号查找对应的二级菜单 ( SysUsersMapper.java )→( List&lt;MenuDto&gt; getMenuByParentId(Long parentId) );

3. *Service业务层新增*：

   1. 通过用户查找菜单业务( UserService )：

      1. //查询用户的权限菜单

         List&lt;MenuDto&gt; getUserMenu(Long uid);

4. *控制层接口*：

   1. 通过用户id查看菜单信息( UserController )→( /user/getMenu )；

5. 对应前端页面更改

### 与示例代码不同：

1. 查询菜单实体类 ( MenuDto.java )中类型为Integer的几个id相关属性全部改成了Long，为了和数据库jdbcType=BIGINT对应；
2. DAO层(SysUsersMapper.java) 下的getMenuByPid(Integer pid)改成了getMenuByParentId(Long parentId);为了更好的读懂代码，和昨天的pid相区分而做修改；
3. 业务层（UserService.java)下的List&lt;MenuDto&gt; getUserMenu(Long uid)中，二级菜单的变量名字从two改成了secondMenu，主要是two意义不明我感觉有些；

### 同步代码需注意事项：

都比较抠细节，想着是代码的易读性，可修改可不改。



**小更新：**

**所有实体类的Date日期类型变量添加该语句，避免前端显示时间差异：**

```java
@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
```



## 第七次更新

2023年6月22日12:32:18

### 今日新增：

1. *新增实体类：*

   1. 查询菜单实体类 ( MenuDto.java );

      1. private Long pid;  //病人编号
      2. private String userName;//医生姓名
      3. private Byte status;//就诊状态

      ​

      1. private Long userId;//用户编号
      2. private Long mId;//医嘱编号

2. *dao ( mapper )层新增*：

   1. 通过用户查找菜单( SysUsersMapper.java )：

      1. //通过用户编号id找一级菜单

         List&lt;MenuDto&gt; getMenuByUser(Long uid); 

      2. //通过一级菜单的编号查找对应的二级菜单

         List&lt;MenuDto&gt; getMenuByParentId(Long parentId)；

   2. 通过一级菜单的编号查找对应的二级菜单 ( SysUsersMapper.java )→( List&lt;MenuDto&gt; getMenuByParentId(Long parentId) );

3. *Service业务层新增*：

   1. 通过修用户信息业务( UserService )：

      1. //修改用户信息

         public int updateUser(SysUsers record);

      2. 1

4. *控制层接口*：

   1. 通过修改信息( UserController )→( /user/updateUser )；

5. 对应前端页面更改

### 与示例代码不同：

1. 查询菜单实体类 ( MenuDto.java )中类型为Integer的几个id相关属性全部改成了Long，为了和数据库jdbcType=BIGINT对应；
2. DAO层(SysUsersMapper.java) 下的getMenuByPid(Integer pid)改成了getMenuByParentId(Long parentId);为了更好的读懂代码，和昨天的pid相区分而做修改；
3. 业务层（UserService.java)下的List&lt;MenuDto&gt; getUserMenu(Long uid)中，二级菜单的变量名字从two改成了secondMenu，主要是two意义不明我感觉有些；

### 同步代码需注意事项：

都比较抠细节，想着是代码的易读性，可修改可不改。



## 第八次更新

2023年6月24日16:24:19

### 今日新增：

1. 添加日志

2. *新增实体类：*

   null

3. *dao ( mapper )层新增*：

   1. 新增用户业务( SysUsersMapper.java )：

      1. ```java
         //通过id查找单条用户信息
         SysUsers getUserById(Long id);
         ```

      2. ```java
         //删除用户信息
         public int deleteUserById(Long id);
         ```

   2. 通过一级菜单的编号查找对应的二级菜单 ( SysUsersMapper.java )→( List&lt;MenuDto&gt; getMenuByParentId(Long parentId) );

4. *Service业务层新增*：

   1. 新增用户业务( UserService )：

      1. ```java
         //通过id查询用户信息
         public SysUsers getUserById(Long id);
         ```

      2. ```java
         //修改用户信息
         public int updateUser(SysUsers record);
         ```

5. *控制层接口*：

   1. 用户控制器（UserController.java）：

      1. ```java
         //通过id获取单条用户信息 getUserById?id=?
         @RequestMapping("getUserById")
         @ResponseBody
         public Result<SysUsers> getUserById(Long id)
         ```

      2. ```java
          //修改用户信息
             @RequestMapping("updateUser")
             @ResponseBody
             public Result updateUser(@RequestBody SysUsers record, HttpSession session)
          ```
         ```

      3. ```java
         //删除用户信息
             @RequestMapping("delUser")
             @ResponseBody
             public Result delUser(Long id)
         ```

6. 对应前端页面更改



## 第九次更新

2023年6月25日10:50:16

挂号状态业务改变

登录拦截器

### 今日新增：

1. 添加日志

2. *新增实体类：*

   null

3. *新增拦截器：*

   com/team/hospital/interceptor/LoginInterceptor.java

4. *dao ( mapper )层新增*：

   null

5. *Service业务层新增*：

   1. 挂号状态业务 (RegistryService.java)：

      1. ```java
         //改变问诊状态
         int changeStatus(Registry record);
         ```

6. *控制层接口*：

   1. 挂号信息控制器（RegistryController.java）：

      1. ```java
         //修改状态信息
         @RequestMapping("alterStatus")
         @ResponseBody
         public Result alterStatus(Long id, Byte status)
         ```

   2. 用户控制器（UserController.java）：

      1. 在登录成功后添加一句语句设置登录状态：

         ```java
         // 登录验证通过后，设置登录状态
         request.getSession().setAttribute("loggedIn", true);
         ```

7. 对应前端页面更改