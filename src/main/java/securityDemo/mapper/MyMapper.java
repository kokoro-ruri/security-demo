package securityDemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import securityDemo.domain.AgBimProject;

import java.util.List;

/**
 * @Package: securityDemo.mapper
 * @ClassName: MyMapper
 * @Description:
 * @UpdateDate: 2020/6/24 10:01
 */
public interface MyMapper extends BaseMapper<AgBimProject> {
    List<AgBimProject> getByProjectName(String projectName);
}
