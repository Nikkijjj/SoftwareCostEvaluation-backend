package com.neu.demo.controller;

import com.neu.demo.biz.ProjectBiz;
import com.neu.demo.biz.StructureBiz;
import com.neu.demo.entity.Project;
import com.neu.demo.entity.Structure;
import com.neu.demo.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProjectController {
    @Autowired
    private ProjectBiz projectBiz;
    @Autowired
    private StructureBiz structureBiz;
    public void setProjectBiz(ProjectBiz projectBiz) {
        this.projectBiz = projectBiz;
    }

    //获取所有项目
    @RequestMapping("/project/selectAllProjects")
    public Map findProjects() {
        List<Project> list = projectBiz.selectProjects();
        Map res = new HashMap<>();
            res.put("isOK", true);
        res.put("msg", "查询所有项目信息成功");
        res.put("projects", list);
        return res;
    }

    //根据项目ID获取项目
    @RequestMapping("/project/selectProjectById")
    public Map findProjectById(String project_id) {
        Project project = projectBiz.selectProjectById(project_id);
        Map res = new HashMap<>();
        res.put("isOK", true);
        res.put("msg", "查询项目成功");
        res.put("project", project);
        return res;
    }

    //更新项目的ufp,ei_num,eo_num,eq_num,ilf_num,elf_num
    @RequestMapping("/project/updateValues")
    public Map updateValues(String project_id){
        List<Structure> structures = structureBiz.getModuleByProjectId(project_id);
        int ufp= 0;
        int ei_num = 0;
        int eo_num = 0;
        int eq_num = 0;
        int ilf_num = 0;
        int elf_num = 0;

        for(Structure structure : structures) {
            if (structureBiz.isLeaf(structure.getModule_id())){
                ufp += structureBiz.getModuleUfp(structure.getModule_id());
                ei_num += structureBiz.getModuleEiNum(structure.getModule_id());
                eo_num += structureBiz.getModuleEoNum(structure.getModule_id());
                eq_num += structureBiz.getModuleEqNum(structure.getModule_id());
                ilf_num += structureBiz.getModuleIlfNum(structure.getModule_id());
                elf_num += structureBiz.getModuleElfNum(structure.getModule_id());
            }
        }

        int result = projectBiz.updateValues(project_id, ufp, ei_num, eo_num, eq_num, ilf_num, elf_num);

        Map res = new HashMap<>();
        if (result == 1) {
            res.put("isOK",true);
            res.put("msg","更新项目信息成功");
        } else {
            res.put("isOK",false);
            res.put("msg","更新项目信息失败");
        }
        return res;
    }

    //更新项目的step和status
    @RequestMapping("/project/updateStep")
    public Map updateStep(String project_id){
        List<Structure> structures = structureBiz.getModuleByProjectId(project_id);
        List<Structure> leafModules = new ArrayList<>();
        double step_sum = 0.0;

        for(Structure structure : structures) {
            if (structureBiz.isLeaf(structure.getModule_id())){
                leafModules.add(structure);
                step_sum += structureBiz.getModuleStep(structure.getModule_id());
            }
        }

        double project_step = step_sum / leafModules.size()*0.5;
        String project_status="";
        if(project_step == 0.0) {project_status="未评估";}
        if(project_step > 0.0&&project_step<1) {project_status="评估中";}
        if(project_step == 1) {project_status="已评估";}
        int result = projectBiz.updateStep(project_id, project_step,project_status);

        Map res = new HashMap<>();
        if(result == 1){
            res.put("isOK",true);
            res.put("msg","更新项目step成功");
        }else{
            res.put("isOK",false);
            res.put("msg","更新项目step失败");
        }
        return res;
    }


    @PostMapping("/project/selectProjectByIdshr")
    public Map findProjectByIdshr(@RequestBody Map<String, String> request) {
        String project_id = request.get("project_id");
        Project project = projectBiz.selectProjectById(project_id);
        Map res = new HashMap<>();
        res.put("isOK", true);
        res.put("msg", "查询项目成功");
        res.put("project", project);
        return res;
    }

    //根据项目所属公司获取项目
    @RequestMapping("/project/selectProjectsByCompany")
    public Map findProjectsByCompany(String company) {
        List<Project> list = projectBiz.selectProjectsByCompany(company);
        Map res = new HashMap<>();
        res.put("isOK", true);
        res.put("msg", "查询租户下项目成功");
        res.put("projects", list);
        return res;
    }

    @RequestMapping("/project/selectProjectsByNameshr")
    public Map findProjectsByName(@RequestBody Map<String, String> request) {
        String project_name = request.get("project_name");
        List<Project> list = projectBiz.selectProjectsByName(project_name);
        Map res = new HashMap<>();
        res.put("isOK", true);
        res.put("msg", "查询项目成功");
        res.put("projects", list);
        return res;
    }

    @RequestMapping("/project/selectProjectsByStatusshr")
    public Map findProjectsByStatus(@RequestBody Map<String, String> request) {
        String status = request.get("status");
        List<Project> list = projectBiz.selectProjectsByStatus(status);
        Map res = new HashMap<>();
        res.put("isOK", true);
        res.put("msg", "查询项目成功");
        res.put("projects", list);
        return res;
    }

    @RequestMapping("/project/selectProjectsByDDLshr")
    public Map findProjectsByDDL(@RequestBody Map<String, String> request) {
        String ddl = request.get("ddl");
        List<Project> list = projectBiz.selectProjectsByDDL(ddl);
        Map res = new HashMap<>();
        res.put("isOK", true);
        res.put("msg", "查询项目成功");
        res.put("projects", list);
        return res;
    }

    @RequestMapping("/project/selectProjectsByNSD")
    public Map findProjectsByNSD(@RequestBody Map<String, String> request) {
        String ddl = request.get("ddl");
        String project_name = request.get("project_name");
        String status = request.get("status");
        int pageNum = Integer.parseInt(request.get("pageNum"));
        int pageSize = Integer.parseInt(request.get("pageSize"));

        List<Project> list = projectBiz.selectProjectsByNSD(project_name, status, ddl, pageNum, pageSize);
        List<Project> listt = projectBiz.countProjectsBNSD(project_name,status,ddl);
        Map res = new HashMap<>();
        res.put("isOK", true);
        res.put("msg", "查询项目成功");
        res.put("projects", list);
        res.put("total", listt.size());
        return res;
    }

    @RequestMapping("/project/selectAllProjectsByNSD")
    public Map findAllProjectsByNSD(@RequestBody Map<String, String> request) {
        String ddl = request.get("ddl");
        String project_name = request.get("project_name");
        String status = request.get("status");
        int pageNum = Integer.parseInt(request.get("pageNum"));
        int pageSize = Integer.parseInt(request.get("pageSize"));

        List<Project> list = projectBiz.selectProjectsByNSD(project_name, status, ddl, pageNum, pageSize);
        List<Project> listt = projectBiz.countProjectsBNSD(project_name,status,ddl);
        Map res = new HashMap<>();
        res.put("isOK", true);
        res.put("msg", "查询项目成功");
        res.put("projects", listt);
        res.put("total", listt.size());
        return res;
    }

    
}
