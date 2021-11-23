package com.imooc.cloud.mall.practice.categoryproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 描述：     CategoryProductApplication
 */
@SpringBootApplication
//@EnableRedisHttpSession
@EnableFeignClients
@MapperScan(basePackages = "com.imooc.cloud.mall.practice.categoryproduct.model.dao")
@ComponentScan({"com.imooc.cloud.mall.practice.categoryproduct","com.imooc.cloud.mall.practice.common"})
public class CategoryProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoryProductApplication.class, args);
    }
}
