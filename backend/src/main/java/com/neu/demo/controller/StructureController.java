package com.neu.demo.controller;

import com.neu.demo.biz.StructureBiz;
import com.neu.demo.entity.Structure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class StructureController {
    @Autowired
    private StructureBiz structureBiz;
    public void setStructureBiz(StructureBiz structureBiz) {
        this.structureBiz = structureBiz;
    }

    //所有的方法，传入参数都没加注解，自行调试、加注解

    //获取节点的父节点（获取节点的parent_id，再根据id查到父节点）
    @RequestMapping("/structure/getParent")
    public Map getStructureParent(String module_id) {
        Structure structure = this.structureBiz.getModuleById(module_id);
        Structure parent = this.structureBiz.getModuleById(structure.getParent_id());
        Map res = new HashMap<>();
        res.put("isOK", true);
        res.put("msg", "获取当前功能模块上级功能成功");
        res.put("parent", parent);
        return res;
    }

    //获取节点的名称
    @RequestMapping("/structure/getModuleName")
    public Map getStructureName(String module_id) {
        String module_name = this.structureBiz.getModuleName(module_id);
        Map res = new HashMap<>();
        res.put("isOK",true);
        res.put("msg","获取功能模块名称成功");
        res.put("module_name",module_name);
        return res;
    }

    //获取节点的描述
    @RequestMapping("/structure/getModuleDesc")
    public Map getStructureDesc(String module_id) {
        String module_desc = this.structureBiz.getModuleDesc(module_id);
        Map res = new HashMap<>();
        res.put("isOK",true);
        res.put("msg","获取功能模块描述成功");
        res.put("module_desc",module_desc);
        return res;
    }

    //更新节点的信息（名称、描述）
    @RequestMapping("/structure/updateModule")
    public Map updateModule(String module_id, String module_name, String module_desc) {
        int result = this.structureBiz.updateModule(module_id, module_name, module_desc);
        Map res = new HashMap<>();
        if (result > 0) {
            res.put("isOK",true);
            res.put("msg","修改功能模块信息成功");
            res.put("result",result);
        } else {
            res.put("isOK",false);
            res.put("msg","修改功能模块信息失败");
            res.put("result",result);
        }
        return res;
    }

    //添加新节点(模块id由项目id和三位随机数字拼接而成，后面的功能点变量初始设置为0)
    @RequestMapping("/structure/addModule")
    public Map addModule(String parent_id, String project_id, String module_name, String module_desc) {
        Structure newModule = new Structure();
        newModule.setParent_id(parent_id);
        newModule.setProject_id(project_id);
        newModule.setModule_name(module_name);
        newModule.setModule_desc(module_desc);
        newModule.setUfp(0);
        newModule.setEi_num(0);
        newModule.setEo_num(0);
        newModule.setEq_num(0);
        newModule.setIlf_num(0);
        newModule.setElf_num(0);
        newModule.setStep(0);
        Random random = new Random();
        int random_id = 100 + random.nextInt(900);
        String post = Integer.toString(random_id);
        String module_id = project_id + post;
        newModule.setModule_id(module_id);
        int result = this.structureBiz.addModule(newModule);
        Map res = new HashMap<>();
        if (result > 0) {
            res.put("isOK",true);
            res.put("msg","添加功能模块成功");
            res.put("result",result);
        } else {
            res.put("isOK",false);
            res.put("msg","添加功能模块失败");
            res.put("result",result);
        }
        return res;
    }

    //删除节点
    @RequestMapping("/structure/deleteModule")
    public Map deleteModule(String module_id) {
        int result = this.structureBiz.deleteModule(module_id);
        Map res = new HashMap<>();
        if (result > 0) {
            res.put("isOK",true);
            res.put("msg","删除功能模块成功");
            res.put("result",result);
        } else {
            res.put("isOK",false);
            res.put("msg","删除功能模块失败");
            res.put("result",result);
        }
        return res;
    }

    //获取所有功能结构
    @RequestMapping("/structure/getModules")
    public Map getModules() {
        List<Structure> modules = this.structureBiz.getModules();
        Map res = new HashMap<>();
        res.put("isOK",true);
        res.put("msg", "获取所有功能模块成功");
        res.put("modules", modules);
        return res;
    }

    //根据功能模块id获取选中功能模块的信息
    @RequestMapping("/structure/getModuleById")
    public Map getModuleById(String module_id) {
        Structure structure = this.structureBiz.getModuleById(module_id);
        Map res = new HashMap<>();
        res.put("isOK",true);
        res.put("msg","获取功能模块成功");
        res.put("structure", structure);
        return res;
    }
}
