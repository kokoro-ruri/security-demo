package securityDemo.enums;

/**
 * @Package: securityDemo.enums
 * @ClassName: PermissionEnums
 * @Description:
 * @UpdateDate: 2020/3/24 16:40
 */
public enum PermissionEnums {
    DELETE("user:delete"), ADD("user:add"), UPDATE("user:update"), QUERY("user:query");
    private String value;

    PermissionEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
