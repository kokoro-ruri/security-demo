package securityDemo.annotation;

import securityDemo.enums.PermissionEnums;

import java.lang.annotation.*;

/**
 * @Package: com.augurit.agcloud.agcom.agsupportbim.sc.bimfile.annotation
 * @ClassName: HasCustomPermission
 * @Description:
 * @UpdateDate: 2020/3/16 11:56
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HasCustomPermission {
    PermissionEnums value() default PermissionEnums.ADD;
}
