package com.gxl.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Orders implements Serializable {
  private final static long serialVersionUID = 1L;

  private Address address;
  private List<Item> items;
  private String oId;
  private long uId;
  private long aId;
  private BigDecimal oCount;
  private Date oTime;
  private int oState;

  @Override
  public String toString() {
    return "Orders{" +
            "address=" + address +
            ", oId='" + oId + '\'' +
            ", uId=" + uId +
            ", aId=" + aId +
            ", oCount=" + oCount +
            ", oTime=" + oTime +
            ", oState=" + oState +
            '}';
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getoId() {
    return oId;
  }

  public void setoId(String oId) {
    this.oId = oId;
  }

  public long getuId() {
    return uId;
  }

  public void setuId(long uId) {
    this.uId = uId;
  }

  public long getaId() {
    return aId;
  }

  public void setaId(long aId) {
    this.aId = aId;
  }

  public BigDecimal getoCount() {
    return oCount;
  }

  public void setoCount(BigDecimal oCount) {
    this.oCount = oCount;
  }

  public Date getoTime() {
    return oTime;
  }

  public void setoTime(Date oTime) {
    this.oTime = oTime;
  }

  public int getoState() {
    return oState;
  }

  public void setoState(int oState) {
    this.oState = oState;
  }
}
