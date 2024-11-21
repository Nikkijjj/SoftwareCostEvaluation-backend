package com.neu.demo.mapper;

import com.neu.demo.entity.Structure;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StructureMapper {

    //获取节点的名称
    @Select("select module_name from t_structure where module_id = #{module_id}")
    String getModuleName(String module_id);

    //获取节点的描述
    @Select("select module_desc from t_structure where module_id = #{module_id}")
    String getModuleDesc(String module_id);

    //更新节点的信息（名称、描述）
    @Update("update t_structure set module_name = #{module_name}, module_desc = #{module_desc} where module_id = #{module_id}")
    int updateModule(String module_id, String module_name, String module_desc);

    //添加新节点
    @Insert("insert into t_structure values(#{module_id}, #{project_id}, #{parent_id}, #{module_name}, #{module_desc}, #{ufp}, #{ei_num}, #{eo_num}, #{eq_num}, #{ilf_num}, #{elf_num}, #{step})")
    int insertModule(Structure structure);

    //删除节点
    @Delete("delete from t_structure where module_id = #{module_id}")
    int deleteModule(String module_id);

    //获取所有功能结构
    @Select("select * from t_structure")
    List<Structure> getModules();

    //根据功能模块id获取选中功能模块的信息
    @Select("select * from t_structure where module_id = #{module_id}")
    Structure getModuleById(String module_id);
}
