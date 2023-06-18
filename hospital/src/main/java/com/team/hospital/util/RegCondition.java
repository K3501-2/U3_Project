package com.team.hospital.util;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/18 10:42
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.util
 * @Classname RegCondition
 * @Created by Administrator
 * @Description:查询挂号信息实体类
 */
//挂号的条件
public class RegCondition extends PageParmeter{
    private String cardId;
    private Long departmentId;
    private Long userId;
    private Byte status;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
