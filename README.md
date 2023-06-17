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

