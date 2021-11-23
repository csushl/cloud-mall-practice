package com.imooc.cloud.mall.practice.cartorder.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：     User过滤器的配置
 */
@Configuration
public class UserFilterConfig {

    @Bean
    public UserInfoFilter userInfoInterceptor() {
        return new UserInfoFilter();
    }

    @Bean(name = "userFilterConf")
    public FilterRegistrationBean userFilterConfig() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(userInfoInterceptor());
        filterRegistrationBean.addUrlPatterns("/cart/*");
        filterRegistrationBean.addUrlPatterns("/order/*");
        filterRegistrationBean.addUrlPatterns("/user/update");
        filterRegistrationBean.setName("userFilterConf");
        return filterRegistrationBean;
    }
}
