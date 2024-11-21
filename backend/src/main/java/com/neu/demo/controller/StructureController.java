package com.neu.demo.controller;

import com.neu.demo.biz.ProjectBiz;
import com.neu.demo.biz.StructureBiz;
import com.neu.demo.entity.Structure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    //获取节点的父节点（获取节点的parent_id，再根据id查到父节点）
    @RequestMapping("/structure/getParent")
    public Map getStructureParent(String module_id) {
        Structure structure = this.structureBiz.getModuleById(module_id);
        Structure parent = this.structureBiz.getModuleById(structure.getParent_id());
        Map res = new HashMap<>();
        if (parent == null) {
            res.put("isOK", false);
            res.put("msg", "当前功能模块不存在上级功能模块");
            res.put("parent", parent);
        } else {
            res.put("isOK", true);
            res.put("msg", "获取当前功能模块上级功能成功");
            res.put("parent", parent);
        }
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
    public Map updateModule(@RequestParam("module_id") String module_id, @RequestParam("module_name") String module_name, @RequestParam("module_desc") String module_desc) {
        System.out.println(module_id);
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

    //更新节点未调整功能点信息（ufp/ei_num/eo_num/eq_num/ilf_num/elf_num/step）
    @RequestMapping("/structure/updateUFPInfo")
    public Map<String, Object> updateUFPInfo(@RequestParam Map<String, String> moduleData) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("Received module Data: " + moduleData);

        Structure module = new Structure();
        module.setModule_id(moduleData.get("module_id"));
        module.setUfp(Integer.parseInt(moduleData.get("ufp")));
        module.setEi_num(Integer.parseInt(moduleData.get("ei_num")));
        module.setEo_num(Integer.parseInt(moduleData.get("eo_num")));
        module.setEq_num(Integer.parseInt(moduleData.get("eq_num")));
        module.setIlf_num(Integer.parseInt(moduleData.get("ilf_num")));
        module.setElf_num(Integer.parseInt(moduleData.get("elf_num")));
        module.setStep(Double.parseDouble(moduleData.get("step")));

        structureBiz.updateUFPInfo(module);
        map.put("isOk", true);
        map.put("msg", "模块未调整功能点信息修改成功！");
        return map;
    }

    //添加新节点(模块id由项目id拼接而成，后面的功能点变量初始设置为0)
    @RequestMapping("/structure/addModule")
    public Map addModule(@RequestParam("parent_id") String parent_id, @RequestParam("project_id") String project_id,
                         @RequestParam("module_name") String module_name, @RequestParam("module_desc") String module_desc) {
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
            res.put("module",newModule);
        } else {
            res.put("isOK",false);
            res.put("msg","添加功能模块失败");
            res.put("module",newModule);
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

    //获取同一项目下属于一个parent的所有模块
    @RequestMapping("/structure/getModulesUnderParent")
    public Map getModulesUnderParent(@RequestParam("project_id") String project_id, @RequestParam("parent_id") String parent_id) {
        List<Structure> modules = this.structureBiz.getModuleByProjectIdAndParentId(project_id, parent_id);
        Map res = new HashMap<>();
        res.put("isOK",true);
        res.put("msg","获取子功能模块成功");
        res.put("modules", modules);
        return res;
    }

    //查看当前模块节点是不是叶子结点（第三级别），返回1表示是叶子结点，返回0则不是
    @RequestMapping("/structure/isLeaf")
    public Map getModuleLevel(String module_id) {
        boolean result = this.structureBiz.isLeaf(module_id);
        Map res = new HashMap<>();
        if (!result) {
            res.put("isOK",false);
            res.put("msg","当前功能模块处于第二级");
        } else {
            res.put("isOK",true);
            res.put("msg","当前功能模块处于第三级");
        }
        return res;
    }
}
