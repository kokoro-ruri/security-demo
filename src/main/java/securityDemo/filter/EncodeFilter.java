package securityDemo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Package: securityDemo.filter
 * @ClassName: EncodeFilter
 * @Description:
 * @UpdateDate: 2020/7/8 9:14
 */
@WebFilter(filterName = "encodeFilter", urlPatterns = "/*")
public class EncodeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        chain.doFilter(request, response);
    }
}
