package securityDemo.service.impl;

import securityDemo.service.GithubFeignService;

/**
 * @Package: securityDemo.service.impl
 * @ClassName: Hysitx
 * @Description:
 * @UpdateDate: 2021/10/20 15:49
 */
public class Hysitx implements GithubFeignService {
    @Override
    public String searchRepo(String queryStr) {
        return "调用github接口失败";
    }
}
