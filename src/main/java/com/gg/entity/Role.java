package com.gg.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Role implements Serializable {
    private Integer ID;//职责ID

    private String sRoleName;//职责名称

    private String sRoleDescription;//职责描述

    private Integer nInputUserID;//录入人

    private Date dtInputDate;//录入日期

    private Integer nModifyID;//修改人

    private Date dtModifyDate;//修改时间

    private Integer nStatusID;//状态;0：无效，1：有效

    private List<User> userList;//用户集合

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getsRoleName() {
        return sRoleName;
    }

    public void setsRoleName(String sRoleName) {
        this.sRoleName = sRoleName;
    }

    public String getsRoleDescription() {
        return sRoleDescription;
    }

    public void setsRoleDescription(String sRoleDescription) {
        this.sRoleDescription = sRoleDescription;
    }

    public Integer getnInputUserID() {
        return nInputUserID;
    }

    public void setnInputUserID(Integer nInputUserID) {
        this.nInputUserID = nInputUserID;
    }

    public Date getDtInputDate() {
        return dtInputDate;
    }

    public void setDtInputDate(Date dtInputDate) {
        this.dtInputDate = dtInputDate;
    }

    public Integer getnModifyID() {
        return nModifyID;
    }

    public void setnModifyID(Integer nModifyID) {
        this.nModifyID = nModifyID;
    }

    public Date getDtModifyDate() {
        return dtModifyDate;
    }

    public void setDtModifyDate(Date dtModifyDate) {
        this.dtModifyDate = dtModifyDate;
    }

    public Integer getnStatusID() {
        return nStatusID;
    }

    public void setnStatusID(Integer nStatusID) {
        this.nStatusID = nStatusID;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", sRoleName='" + sRoleName + '\'' +
                ", sRoleDescription='" + sRoleDescription + '\'' +
                ", nInputUserID=" + nInputUserID +
                ", dtInputDate=" + dtInputDate +
                ", nModifyID=" + nModifyID +
                ", dtModifyDate=" + dtModifyDate +
                ", nStatusID=" + nStatusID +
                ", userList=" + userList +
                '}';
    }
}
