package com.gxl.model;


import java.io.Serializable;

public class Type implements Serializable {

    private final static long serialVersionUID = 1L;

    private long tId;
    private String tName;
    private String tInfo;

    @Override
    public String toString() {
        return "Type{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                ", tInfo='" + tInfo + '\'' +
                '}';
    }

    public long gettId() {
        return tId;
    }

    public void settId(long tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettInfo() {
        return tInfo;
    }

    public void settInfo(String tInfo) {
        this.tInfo = tInfo;
    }
}
