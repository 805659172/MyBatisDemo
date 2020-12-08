package com.gg.entity;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {
    private Integer ID;//表ID

    private String sTitle;//笔记的标题

    private String ltText;//笔记的内容

    private Integer nInputUserID;//笔记录入人ID

    private Date dtInputDate;//录入时间

    private Date dtModifyDate;//笔记修改时间

    private Integer nStatusID;//笔记状态；0：无效，1：有效

    private User user;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getsTitle() {
        return sTitle;
    }

    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    public String getLtText() {
        return ltText;
    }

    public void setLtText(String ltText) {
        this.ltText = ltText;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Note{" +
                "ID=" + ID +
                ", sTitle='" + sTitle + '\'' +
                ", ltText='" + ltText + '\'' +
                ", nInputUserID=" + nInputUserID +
                ", dtInputDate=" + dtInputDate +
                ", dtModifyDate=" + dtModifyDate +
                ", nStatusID=" + nStatusID +
                ", user=" + user +
                '}';
    }
}
