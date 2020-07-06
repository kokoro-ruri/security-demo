package securityDemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import securityDemo.annotation.HasCustomPermission;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Package: com.augurit.agcloud.agcom.agsupportbim.sc.bimfile.aspect
 * @ClassName: CustomPermissionAspect
 * @Description:
 * @UpdateDate: 2020/3/16 13:39
 */
/*@Component
@Aspect
@Order(2)*/
public class CustomPermissionAspect2 {
    private static final Logger logger = LoggerFactory.getLogger(CustomPermissionAspect2.class);

    @Pointcut("@annotation(securityDemo.annotation.HasCustomPermission)")
    private void cut(){
        System.out.println("koko ni iru");
    }

    @Around("cut() && @annotation(permission)")
    public Object around(ProceedingJoinPoint joinPoint, HasCustomPermission permission) throws Throwable {
        System.out.println("securityDemo.aspect.CustomPermissionAspect2.around begin");
        System.out.println("securityDemo.aspect.CustomPermissionAspect2*******" + permission.value());

        Object proceed = joinPoint.proceed(new Object[]{new HashMap<String, String>(){{put("11", "22");put("33", "44");}}});
        System.out.println("securityDemo.aspect.CustomPermissionAspect2.around end");
        ArrayList<String> proceed1 = (ArrayList<String>) proceed;
        proceed1.remove("hehe");
        proceed1.add("pupu");
        return proceed1;
    }

    @Before("cut()")
    public void before(){
        System.out.println("securityDemo.aspect.CustomPermissionAspect2.before");
    }
    @After("cut()")
    public void after(){
        System.out.println("securityDemo.aspect.CustomPermissionAspect2.after");
    }
    @AfterReturning("cut()")
    public void AfterReturning(){
        System.out.println("securityDemo.aspect.CustomPermissionAspect2.AfterReturning");
    }
    @AfterThrowing("cut()")
    public void AfterThrowing(){
        System.out.println("securityDemo.aspect.CustomPermissionAspect2.AfterThrowing");
    }
}
