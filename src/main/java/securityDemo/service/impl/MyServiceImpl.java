package securityDemo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import securityDemo.domain.AgBimProject;
import securityDemo.mapper.MyMapper;
import securityDemo.service.MyService;

import java.util.List;
import java.util.Map;

/**
 * @Package: securityDemo.service.impl
 * @ClassName: MyServiceImpl
 * @Description:
 * @UpdateDate: 2020/6/24 9:55
 */
@Service
public class MyServiceImpl extends ServiceImpl<MyMapper, AgBimProject> implements MyService {
    @Autowired
    MyMapper myMapper;

    @Override
    public List<AgBimProject> getAll(){
        return myMapper.selectList(null);
    }

    @Override
    public List<AgBimProject> getByProjectName(String projectName) {
        LambdaQueryWrapper<AgBimProject> lqw = new LambdaQueryWrapper<>();
        lqw.eq(AgBimProject::getProjectName, projectName);
        List<AgBimProject> agBimProjects = myMapper.selectList(lqw);

        QueryWrapper<AgBimProject> objectQueryWrapper = new QueryWrapper<>();

        Page<AgBimProject> agBimProjectPage = new Page<>(1, 10);
        Page<AgBimProject> agBimProjectPage1 = myMapper.selectPage(agBimProjectPage, objectQueryWrapper);

        Page<Map<String,Object>> agBimProjectPage0 = new Page<>(1, 10);
        Page<Map<String, Object>> mapPage = myMapper.selectMapsPage(agBimProjectPage0, objectQueryWrapper);

        objectQueryWrapper.eq(true,"project_name", projectName);
        return myMapper.selectList(objectQueryWrapper);
//        return myMapper.getByProjectName(projectName);
    }

    @Override
    @DS("slave_1")
    public List<AgBimProject> getByProjectNameInSlave(String projectName) {
        QueryWrapper<AgBimProject> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq(true,"project_name", projectName);
        return myMapper.selectList(objectQueryWrapper);
    }
}
