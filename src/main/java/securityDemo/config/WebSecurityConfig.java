package securityDemo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import securityDemo.interceptor.StaticResourcesInterceptor;

/**
 * @Package: securityDemo.configs
 * @ClassName: WebSecurityConfig
 * @Description:
 * @UpdateDate: 2020/3/13 13:32
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

    /**
     * 用于通过允许AuthenticationProvider容易地添加来建立认证机制。
     * 默认配置自己实现的UserDetailsService类和PasswordEncoder
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        //以下定义了内置认证与内置的“user”和“admin”登录。
/*
        auth
            .inMemoryAuthentication()
            .withUser("user")
            .password("password")
            .roles("USER")
            .and()
            .withUser("admin")
            .password("password")
            .roles("ADMIN","USER");
*/
        //
    }

    /**
     * 用于影响全局安全性(配置资源，设置调试模式，通过实现自定义防火墙定义拒绝请求)的配置设置。
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //以下方法将导致以/ resources /开头的任何请求被忽略, 以用于认证目的。
/*
        web
           .ignoring()
           .antMatchers("/resources/**");
*/
        super.configure(web);
    }

    /**
     * 允许基于选择匹配在资源级配置基于网络的安全性。
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()//使用 spring security 默认登录页面
            .and().authorizeRequests()//限定签名成功的请求
            .antMatchers("/admin/login", "/oauth/**").permitAll()///admin/login和oauth 不限定
            .antMatchers("/admin/**").hasRole("ADMIN")//对admin下的接口 需要ADMIN权限
            .anyRequest().authenticated()//没有配置的其他请求需要认证
//            .and().anonymous()//对于没有配置权限的其他请求允许匿名访问
            .and()
            .csrf().disable();//禁用csrf 功能
    }
}
