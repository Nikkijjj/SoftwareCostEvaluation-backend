package com.neu.demo.biz;

import com.neu.demo.entity.Structure;
import com.neu.demo.mapper.StructureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StructureBiz {
    @Autowired
    private StructureMapper structureMapper;
    public void setStructureMapper(StructureMapper structureMapper) {
        this.structureMapper = structureMapper;
    }

    //获取节点的名称
    public String getModuleName(String module_id) {
        return this.structureMapper.getModuleName(module_id);
    }

    //获取节点的描述
    public String getModuleDesc(String module_id) {
        return this.structureMapper.getModuleDesc(module_id);
    }

    //更新节点的信息（名称、描述）
    public int updateModule(String module_id, String module_name, String module_desc){
        return this.structureMapper.updateModule(module_id, module_name, module_desc);
    }

    //更新节点未调整功能点信息
    public void updateUFPInfo(Structure module) {
        structureMapper.updateUFPInfo(module);
    }

    //添加新节点
    public int addModule(Structure structure){
        return this.structureMapper.insertModule(structure);
    }

    //删除节点
    public int deleteModule(String module_id){
        return this.structureMapper.deleteModule(module_id);
    }

    //获取所有功能结构
    public List<Structure> getModules(){
        return this.structureMapper.getModules();
    }

    //根据功能模块id获取选中功能模块的信息
    public Structure getModuleById(String module_id){
        return this.structureMapper.getModuleById(module_id);
    }

    //获取同一项目下属于一个parent的所有模块
    public List<Structure> getModuleByProjectIdAndParentId(String project_id, String parent_id){
        return this.structureMapper.getModuleByProjectIdAndParentId(project_id, parent_id);
    }

    //获取一个项目下的所有功能模块
    public List<Structure> getModuleByProjectId(String project_id){
        return this.structureMapper.getModuleByProjectId(project_id);
    }

    //当前功能模块是否为叶子节点（第三级别）
    public boolean isLeaf(String module_id){
        //获取当前节点的父节点，如果父节点为空，就不是叶子结点，如果父节点不为空，就是叶子结点
        Structure structure = this.structureMapper.getModuleById(module_id);
        Structure parent = this.structureMapper.getModuleById(structure.getParent_id());
        if(parent == null) return false;
        else return true;
    }

    //获取功能模块的ufp
    public int getModuleUfp(String module_id){
        return this.structureMapper.getUfp(module_id);
    }

    //获取功能模块的ei_num
    public int getModuleEiNum(String module_id){
        return this.structureMapper.getEiNum(module_id);
    }

    //获取功能模块的eo_num
    public int getModuleEoNum(String module_id){
        return this.structureMapper.getEoNum(module_id);
    }

    //获取功能模块的eq_num
    public int getModuleEqNum(String module_id){
        return this.structureMapper.getEqNum(module_id);
    }

    //获取功能模块的ilf_num
    public int getModuleIlfNum(String module_id){
        return this.structureMapper.getIlfNum(module_id);
    }

    //获取功能模块的elf_num
    public int getModuleElfNum(String module_id){
        return this.structureMapper.getElfNum(module_id);
    }

    //获取功能模块的step
    public double getModuleStep(String module_id){
        return this.structureMapper.getStep(module_id);
    }

}
