package securityDemo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import securityDemo.service.impl.Hysitx;

/**
 * @Package: securityDemo.service
 * @ClassName: GithubFeignService
 * @Description:
 * @UpdateDate: 2021/10/20 15:19
 */
@FeignClient(name = "github-client", url = "https://api.github.com", fallback = Hysitx.class)
public interface GithubFeignService {
    @RequestMapping(value = "/search/repositories", method = RequestMethod.GET)
    String searchRepo(@RequestParam("q") String queryStr);
}
