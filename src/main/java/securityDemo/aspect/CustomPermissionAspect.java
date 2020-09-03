package securityDemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import securityDemo.annotation.HasCustomPermission;
import securityDemo.enums.PermissionEnums;

import java.util.ArrayList;
import java.util.HashMap;

@Component
@Aspect
@Order(1)
public class CustomPermissionAspect {
    private static final Logger logger = LoggerFactory.getLogger(CustomPermissionAspect.class);

    @Pointcut("@annotation(securityDemo.annotation.HasCustomPermission)")
    private void cut(){
        System.out.println("koko ni iru");
    }

    @Around("cut() && @annotation(permission)")
    public Object around(ProceedingJoinPoint joinPoint, HasCustomPermission permission) throws Throwable {
        System.out.println("securityDemo.aspect.CustomPermissionAspect.around begin");
        System.out.println("securityDemo.aspect.CustomPermissionAspect*******" + permission.value());
        System.out.println(permission.value() == PermissionEnums.UPDATE);
        System.out.println(permission.value().equals(PermissionEnums.UPDATE));
        System.out.println(permission.value().getClass());
//        Object proceed = joinPoint.proceed(new Object[]{"aa"});
        Object proceed = joinPoint.proceed(new Object[]{new HashMap<String, String>(){{put("aa", "bb");put("cc", "dd");}}});
        ArrayList<String> proceed1 = (ArrayList<String>) proceed;
        proceed1.add("pipi");
        System.out.println("securityDemo.aspect.CustomPermissionAspect.around end");
        return proceed1;
    }

    @Before("cut()")
    public void before() throws Throwable {
        System.out.println("securityDemo.aspect.CustomPermissionAspect.before");
    }
//    @After("cut()")
    public void after(){
        System.out.println("securityDemo.aspect.CustomPermissionAspect.after");
    }
//    @AfterReturning("cut()")
    public void AfterReturning(){
        System.out.println("securityDemo.aspect.CustomPermissionAspect.AfterReturning");
    }
//    @AfterThrowing("cut()")
    public void AfterThrowing(){
        System.out.println("securityDemo.aspect.CustomPermissionAspect.AfterThrowing");
    }
}
