package com.example.web.interceptor;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/10
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurationSupport {

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHandlerInteceptor()).addPathPatterns("/**");
        registry.addInterceptor(new MyHandlerInteceptor2()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /**
     * 使用fastjson解析json
     * @param converters
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
                SerializerFeature.SortField,
                SerializerFeature.WriteDateUseDateFormat
        );
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastJsonHttpMessageConverter);
        super.configureMessageConverters(converters);
    }

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/")
                .allowedOrigins("http://127.0.0.1");
        registry
                .addMapping("/v2/api-docs.*")
                .allowedOrigins("http://127.0.0.1");

        super.addCorsMappings(registry);
    }
}
