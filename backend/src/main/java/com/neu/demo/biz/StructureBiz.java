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
}
