package securityDemo;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import securityDemo.interceptor.StaticResourcesInterceptor;

/**
 * @Package: com.augurit.agcloud.agcom
 * @ClassName: WebSecurityConfig
 * @Description:
 * @UpdateDate: 2020/3/13 13:32
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
/*
        http.formLogin().and()
                .authorizeRequests()// 对请求授权
                .anyRequest()//其他请求需要认证
                .authenticated()
                .and()
                .csrf().disable();
*/
        http.csrf().disable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/kasuganoSora/**")
                // /apple/**表示在磁盘apple目录下的所有资源会被解析为以下的路径
                .addResourceLocations("file:D:\\others\\img\\"); //媒体资源
    }

    /**
     * 通过@Bean注解，将我们定义的拦截器注册到Spring容器
     * @return
     */
    @Bean
    public StaticResourcesInterceptor staticResourcesInterceptor(){
        return new StaticResourcesInterceptor();
    }

    /**
     * 重写接口中的addInterceptors方法，添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 通过registry来注册拦截器，通过addPathPatterns来添加拦截路径
//        registry.addInterceptor(staticResourcesInterceptor()).addPathPatterns("/kasuganoSora/**");
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
