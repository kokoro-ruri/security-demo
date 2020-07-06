package securityDemo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: securityDemo.handler
 * @ClassName: GlobalExceptionHandler
 * @Description:
 * @UpdateDate: 2020/4/20 16:43
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public List excption(HttpServletRequest request, Exception e){
//        e.printStackTrace();
        return new ArrayList(){{
            add(new HashMap(){{
                put("Exception", e.getMessage());
                put("message", "你是哈麻批");
            }});
        }};
    }

    @ExceptionHandler(ArithmeticException.class)
    public List excption1(HttpServletRequest request, Exception e){
        e.printStackTrace();
        return new ArrayList(){{
            add(new HashMap(){{
                put("ArithmeticException", e.getMessage());
            }});
        }};
    }

    @ExceptionHandler(NullPointerException.class)
    public List excption2(HttpServletRequest request, Exception e){
        e.printStackTrace();
        return new ArrayList(){{
            add(new HashMap(){{
                put("NullPointerException", e.getMessage());
            }});
        }};
    }
}
