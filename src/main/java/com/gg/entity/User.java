package com.gg.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private Integer ID;//表ID

    private String sAccountNO;//账户号

    private String sPassword;//密码

    private String sName;//用户名

    private Integer nStatusID;//状态

    private List<Integer> IDs;//存储的多个ID值

    private List<Note> noteList;//用户所对应的笔记

    private List<Role> roleList;//用户对应的职责

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getsAccountNO() {
        return sAccountNO;
    }

    public void setsAccountNO(String sAccountNO) {
        this.sAccountNO = sAccountNO;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getnStatusID() {
        return nStatusID;
    }

    public void setnStatusID(Integer nStatusID) {
        this.nStatusID = nStatusID;
    }

    public List<Integer> getIDs() {
        return IDs;
    }

    public void setIDs(List<Integer> IDs) {
        this.IDs = IDs;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", sAccountNO='" + sAccountNO + '\'' +
                ", sPassword='" + sPassword + '\'' +
                ", sName='" + sName + '\'' +
                ", nStatusID=" + nStatusID +
                ", IDs=" + IDs +
                ", noteList=" + noteList +
                ", roleList=" + roleList +
                '}';
    }

}
