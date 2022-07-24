package com.gxl.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

public class AlibabaDataSource extends UnpooledDataSourceFactory {
    public AlibabaDataSource() {
        this.dataSource = new DruidDataSource();
    }
}
