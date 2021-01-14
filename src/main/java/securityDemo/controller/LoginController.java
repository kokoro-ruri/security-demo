package securityDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package: securityDemo.controller
 * @ClassName: LoginController
 * @Description:
 * @UpdateDate: 2021/1/14 14:14
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("login")
    public String login(){
        return "/login/login";
    }
    @RequestMapping("loginIndex")
    public String loginIndex(){
        return "index";
    }
    @RequestMapping("loginError")
    public String loginError(){
        return "error1";
    }
}
