package securityDemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import securityDemo.domain.AgBimProject;

import java.util.List;

/**
 * @Package: securityDemo.service
 * @ClassName: MyService
 * @Description:
 * @UpdateDate: 2020/6/24 9:54
 */
public interface MyService extends IService<AgBimProject> {
    /**
     * 获取主库所有
     * @return
     */
    List<AgBimProject> getAll();

    /**
     * 根据projectName查询主库
     * @param projectName
     * @return
     */
    List<AgBimProject> getByProjectName(String projectName);

    /**
     * 根据projectName查询从库
     * @param projectName
     * @return
     */
    List<AgBimProject> getByProjectNameInSlave(String projectName);
}
