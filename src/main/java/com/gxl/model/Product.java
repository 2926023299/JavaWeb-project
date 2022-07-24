package com.gxl.model;


import java.io.Serializable;
import java.sql.Date;

public class Product implements Serializable {
    private final static long serialVersionUID = 1L;

    private int pId;
    private int tId;
    private String pName;
    private java.sql.Date pTime;
    private String pImage;
    private double pPrice;
    private long pState;
    private String pInfo;

    @Override
    public String toString() {
        return "Product{" +
                "pId=" + pId +
                ", tId=" + tId +
                ", pName='" + pName + '\'' +
                ", pTime=" + pTime +
                ", pImage='" + pImage + '\'' +
                ", pPrice=" + pPrice +
                ", pState=" + pState +
                ", pInfo='" + pInfo + '\'' +
                '}';
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Date getpTime() {
        return pTime;
    }

    public void setpTime(Date pTime) {
        this.pTime = pTime;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public long getpState() {
        return pState;
    }

    public void setpState(long pState) {
        this.pState = pState;
    }

    public String getpInfo() {
        return pInfo;
    }

    public void setpInfo(String pInfo) {
        this.pInfo = pInfo;
    }
}
