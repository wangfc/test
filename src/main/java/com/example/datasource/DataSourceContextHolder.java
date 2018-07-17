package com.example.datasource;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/11
 */
public class DataSourceContextHolder {
    private static ThreadLocal<DataSourceType> context = new ThreadLocal<>();

    public static void setDataSourceType(DataSourceType dataSourceType) {
        context.set(dataSourceType);
    }

    public static DataSourceType getDataSourceType() {
        return context.get();
    }

    public static void clearDataSourceType(){
        context.remove();
    }

}
