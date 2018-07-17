package com.example.aspect;

import com.example.datasource.DataSourceContextHolder;
import com.example.datasource.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/11
 */
@Aspect
@Order(-10)
@Component
@Slf4j
public class DynamicDataSourceAspect {

    /*
     * @Before("@annotation(ds)")的意思是：
     * @Before：在方法执行之前进行执行：
     * @annotation(targetDataSource)：
     * 会拦截注解targetDataSource的方法，否则不拦截;
     */
    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint point, TargetDataSource targetDataSource) throws Throwable {
        //获取当前的指定的数据源;
        String dsId = targetDataSource.value();
        //如果不在我们注入的所有的数据源范围之内，那么输出警告信息，系统自动使用默认的数据源。
        String value = targetDataSource.value();
        DataSourceType dataSourceType = DataSourceType.valueOf(value);
        if (dataSourceType == null ){
            log.warn("数据源[{}]不存在，使用默认数据源 > {}" + targetDataSource.value() + point.getSignature());
            dataSourceType = DataSourceType.DS ;
        }else {
            log.info("Use DataSource : {} > {}" + targetDataSource.value() + point.getSignature());
        }
        DataSourceContextHolder.setDataSourceType(dataSourceType);
    }

    @After("@annotation(targetDataSource)")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        log.info("Revert DataSource : {} > {}" + targetDataSource.value() + point.getSignature());
        //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DataSourceContextHolder.clearDataSourceType();
    }

}
