package securityDemo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import securityDemo.annotation.HasCustomPermission;
import securityDemo.domain.AgBimProject;
import securityDemo.enums.PermissionEnums;
import securityDemo.service.MyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Package: securityDemo.controller
 * @ClassName: MyController
 * @Description:
 * @UpdateDate: 2020/3/13 17:03
 */
@RestController
public class MyController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    MyService myService;

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('user:add')")
    public String add() {
        System.out.println("add");
        return "Hello add";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('user:delete')")
    public String delete() {
        System.out.println("delete");
        return "Hello delete";
    }

    @GetMapping("/update")
    @PreAuthorize("hasAuthority('user:update')")
    @HasCustomPermission(PermissionEnums.UPDATE)
    public List update(Map arg) {
        System.out.println(arg);
        return new ArrayList<String>(){{add("xixi");add("haha");add("hehe");add("hihi");}};
    }

    @GetMapping("/query")
    public String query() {
        System.out.println("query");
        return "Hello query";
    }

    @PostMapping("/doPost")
    public String doPost(String name) {
        System.out.println("doPost");
        System.out.println(name);
        return "Hello doPost";
    }

    @GetMapping("/getAll")
    public List<AgBimProject> getAll(){
        return myService.getAll();
    }

    @GetMapping("/getByProjectName")
    public List<AgBimProject> getByProjectName(){
        String projectName = "中山一院南沙院区（10栋）";
        return myService.getByProjectName(projectName);
    }

    @GetMapping("/auth")
    public void auth(HttpServletResponse response){
        response.setStatus(302);
        response.setHeader("Location", "http://www.baidu.com");
    }

    @GetMapping({"/getByIds/{ids}", "/echo"})
    public void getByIds(@PathVariable(value = "ids", required = false) String... ids){
    }
/*
    @GetMapping("/echo")
    public void echo(){
        echoWithIds();
    }*/
}