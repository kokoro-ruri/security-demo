package securityDemo.service;

import securityDemo.domain.AgBimProject;

import java.util.List;

/**
 * @Package: securityDemo.service
 * @ClassName: MyService
 * @Description:
 * @UpdateDate: 2020/6/24 9:54
 */
public interface MyService {
    List<AgBimProject> getAll();

    List<AgBimProject> getByProjectName(String projectName);
}
