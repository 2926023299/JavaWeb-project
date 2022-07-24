package com.gxl.model;


import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable {
  private final static long serialVersionUID = 1L;

  private Product product;
  private long iId;
  private String oId;
  private int pId;
  private BigDecimal iCount;
  private int iNum;

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public long getiId() {
    return iId;
  }

  public void setiId(long iId) {
    this.iId = iId;
  }

  public String getoId() {
    return oId;
  }

  public void setoId(String oId) {
    this.oId = oId;
  }

  public int getpId() {
    return pId;
  }

  public void setpId(int pId) {
    this.pId = pId;
  }

  public BigDecimal getiCount() {
    return iCount;
  }

  public void setiCount(BigDecimal iCount) {
    this.iCount = iCount;
  }

  public int getiNum() {
    return iNum;
  }

  public void setiNum(int iNum) {
    this.iNum = iNum;
  }
}
