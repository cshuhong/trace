package cn.edu.zut.trace.config;

import cn.edu.zut.trace.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private LoginInterceptor loginInterceptor;
    private static List<String> excludeUrl;
    static {
        excludeUrl = new ArrayList<>();
        excludeUrl.add("/user/login");
        excludeUrl.add("/user/register");
        excludeUrl.add("/company/register");
        excludeUrl.add("/swagger-ui.html");
        excludeUrl.add("/swagger-resources/**");
        excludeUrl.add("/webjars/**");
        excludeUrl.add("/v2/api-docs");
    }

    @Autowired
    public void setLoginInterceptor(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/*").excludePathPatterns(excludeUrl);
    }
}
