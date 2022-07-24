package com.gxl.model;


import java.io.Serializable;
import java.math.BigDecimal;

public class Cart implements Serializable {

    private final static long serialVersionUID = 1L;

    private Product product;
    private int cId;
    private int uId;
    private int pId;
    private BigDecimal cCount; //购物车小计
    private int cNum = 0; //购物车数量

    @Override
    public String toString() {
        return "Cart{" +
                "product=" + product +
                ", cId=" + cId +
                ", uId=" + uId +
                ", pId=" + pId +
                ", cCount=" + cCount +
                ", cNum=" + cNum +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public BigDecimal getcCount() {
        BigDecimal price = BigDecimal.valueOf(product.getpPrice());
        BigDecimal bd = new BigDecimal(cNum);

        return price.multiply(bd);
    }

    public void setcCount(BigDecimal cCount) {
        this.cCount = cCount;
    }

    public int getcNum() {
        return cNum;
    }

    public void setcNum(int cNum) {
        this.cNum = cNum;
    }
}
