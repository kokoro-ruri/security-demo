package securityDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import securityDemo.interceptor.StaticResourcesInterceptor;

/**
 * @Package: securityDemo.config
 * @ClassName: webMvcConfig
 * @Description:
 * @UpdateDate: 2020/7/10 10:04
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

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
        // 通过registry来注册拦截器，通过addPathPatterns来添加拦截路径。放开下面注释后通过拦截器将访问的所有资源都变成默认下载
//        registry.addInterceptor(staticResourcesInterceptor()).addPathPatterns("/kasuganoSora/**");
    }

}
