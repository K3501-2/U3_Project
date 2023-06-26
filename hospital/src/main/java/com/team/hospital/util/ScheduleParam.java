package com.team.hospital.util;

import java.util.Date;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/26 16:44
 * @Java version: 1.8.0_361
 * @Project U3_Project
 * @Package com.team.hospital.util
 * @Classname ScheduleParam
 * @Created by Administrator
 * @Description:NULL
 */
public class ScheduleParam extends PageParmeter{
    private Long departmentId;
    private Long userId;
    private Date beginTime;
    private Date endTime;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
