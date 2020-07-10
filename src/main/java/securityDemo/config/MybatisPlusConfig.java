package securityDemo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Package: securityDemo.config
 * @ClassName: MybatisPlusConfig
 * @Description:
 * @UpdateDate: 2020/7/10 10:06
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * mybatisPlus分页拦截器
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
