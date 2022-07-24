package com.gxl.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@ToString
public class Address implements Serializable {
    private final static long serialVersionUID = 1L;

    private long aId;
    private long uId;
    private String aName;
    private String aPhone;
    private String aDetail;
    private long aState;

    @Override
    public String toString() {
        return "Address{" +
                "aId=" + aId +
                ", uId=" + uId +
                ", aName='" + aName + '\'' +
                ", aPhone='" + aPhone + '\'' +
                ", aDetail='" + aDetail + '\'' +
                ", aState=" + aState +
                '}';
    }

    public long getaId() {
        return aId;
    }

    public void setaId(long aId) {
        this.aId = aId;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone;
    }

    public String getaDetail() {
        return aDetail;
    }

    public void setaDetail(String aDetail) {
        this.aDetail = aDetail;
    }

    public long getaState() {
        return aState;
    }

    public void setaState(long aState) {
        this.aState = aState;
    }
}
