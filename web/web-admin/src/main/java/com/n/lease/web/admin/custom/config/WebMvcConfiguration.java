package com.n.lease.web.admin.custom.config;

import com.n.lease.web.admin.custom.converter.StringToBaseEnumConverterFactory;
import com.n.lease.web.admin.custom.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Autowired
    private StringToBaseEnumConverterFactory stringToBaseEnumConverterFactory;

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;


    //注册Converter，转换枚举和String
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(stringToBaseEnumConverterFactory);
    }
    //注册token校验拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //                                                 指定拦截路径,校验拦截后台系统，登录接口不拦截
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/admin/login/**");
    }
}
