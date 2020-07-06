import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import securityDemo.MyApplication;
import securityDemo.controller.MyController;
import securityDemo.domain.AgBimProject;

import java.util.List;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: SpringTest
 * @Description:
 * @UpdateDate: 2020/5/26 15:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class SpringTest {
    @Autowired
    MyController controller;

    @Test
    public void test1(){
        String query = controller.query();
        List<AgBimProject> all = controller.getAll();
        List<AgBimProject> byProjectName = controller.getByProjectName();
        System.out.println(byProjectName);
    }
}
