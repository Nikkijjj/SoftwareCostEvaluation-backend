package com.neu.demo.biz;

import com.neu.demo.entity.Project;
import com.neu.demo.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectBiz {
    @Autowired
    private ProjectMapper projectMapper;
    public void setProjectMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    //获取所有项目
    public List<Project> selectProjects() {
        return this.projectMapper.getProjects();
    }

    //根据项目Id获取项目
    public Project selectProjectById(String project_id) {
        return projectMapper.getProjectById(project_id);
    }

    //根据项目所属公司名称获取项目
    public List<Project> selectProjectsByCompany(String company) {
        return this.projectMapper.getProjectsByCompany(company);
    }

    //更新项目的ufp, ei_num, eo_num, eq_num, ilf_num, elf_num
    public int updateValues(String project_id, int ufp, int ei_num, int eo_num, int eq_num, int ilf_num, int elf_num) {
        return this.projectMapper.updateUFP(project_id, ufp, ei_num, eo_num, eq_num, ilf_num, elf_num);
    }

    //更新项目的step和status
    public int updateStep(String project_id, double step, String project_status) {
        return this.projectMapper.updateStep(project_id, step,project_status);
    }

    public List<Project> selectProjectsByName(String project_name) {
        List<Project> projects = projectMapper.getProjectByName(project_name);
        System.out.println(projects);
        return projects;
    }

    public List<Project> selectProjectsByStatus(String status) {
        List<Project> projects = projectMapper.getProjectByStatus(status);
        System.out.println(projects);
        return projects;
    }

    public List<Project> selectProjectsByDDL(String ddl) {
        List<Project> projects = projectMapper.getProjectByDDL(ddl);
        System.out.println(projects);
        return projects;
    }

    public List<Project> selectProjectsByNSD(String project_name, String status, String ddl, int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return projectMapper.getProjectByNameStatusDDL(project_name, status, ddl, offset, pageSize);
    }


    public List<Project> countProjectsBNSD(String project_name,String status,String ddl) {
        List<Project> projects = projectMapper.countProjects(project_name,status,ddl);
        System.out.println(projects);
        return projects;
    }




}
