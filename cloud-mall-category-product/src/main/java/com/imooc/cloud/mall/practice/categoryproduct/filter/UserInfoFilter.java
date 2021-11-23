package com.imooc.cloud.mall.practice.categoryproduct.filter;

import com.imooc.cloud.mall.practice.common.common.Constant;
import com.imooc.cloud.mall.practice.user.model.pojo.User;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 把Header里的用户信息，放到本地的ThreadLocal里
 */
@Configuration
@EnableFeignClients
public class UserInfoFilter implements Filter {

    public static ThreadLocal<User> userThreadLocal = new ThreadLocal();
    public User currentUser = new User();


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //通过RequestContextHolder获取本地请求
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        //获取本地线程绑定的请求对象
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        //给请求模板附加本地线程头部信息，把User信息放到ThreadLocal里
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                Enumeration<String> values = request.getHeaders(name);
                while (values.hasMoreElements()) {
                    String value = values.nextElement();
                    if (name.equals(Constant.USER_ID)) {
                        currentUser.setId(Integer.valueOf(value));
                    }
                    if (name.equals(Constant.USER_NAME)) {
                        currentUser.setUsername(value);
                    }
                    if (name.equals(Constant.USER_ROLE)) {
                        currentUser.setRole(Integer.valueOf(value));
                    }
                    //必须保证User的3个字段都完整，否则意味着网关传递信息时出错了
                    if (currentUser.getId() != null && currentUser.getUsername() != null && currentUser.getRole() != null) {
                        userThreadLocal.set(currentUser);
                    }
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
